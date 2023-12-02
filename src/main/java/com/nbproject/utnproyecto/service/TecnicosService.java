package com.nbproject.utnproyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.nbproject.utnproyecto.model.Especialidades_Tecnicos;
import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.repository.Especialidades_TecnicosRepository;
import com.nbproject.utnproyecto.repository.IncidentesRepository;
import com.nbproject.utnproyecto.repository.TecnicosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class TecnicosService {

    private final JavaMailSender mailSender;
    private final TecnicosRepository tecnicosRepository;
    private final IncidentesRepository incidentesRepository;
    @Autowired
    private Especialidades_TecnicosRepository especialidades_TecnicosRepository;

    public List<Tecnicos> findByEspecialidadIdEspecialidad(Integer idEspecialidad){
        List<Especialidades_Tecnicos> especialidades_TecnicosList = especialidades_TecnicosRepository.findByEspecialidad_IdEspecialidad(idEspecialidad);

        return especialidades_TecnicosList.stream().map(Especialidades_Tecnicos::getTecnico).collect(Collectors.toList());
    }

    public void actualizarTiempoResolucion(Integer idIncidente, int nuevoTiempo) {
        Incidentes incidente = incidentesRepository.findById(idIncidente).orElseThrow(() -> new RuntimeException("Incidente no encontrado con ID: " + idIncidente));

        //Tecnicos tecnico = incidente.getTecnico();

        if (!incidente.isResuelto() && incidente.getTiempoResolucion() < nuevoTiempo) {
            incidente.setTiempoResolucion(nuevoTiempo);

            if ("BAJA".equals(incidente.getComplejidad())) {
                incidente.setComplejidad("ALTA");
            }

            incidentesRepository.save(incidente);
        }
    }

    @Transactional
    public ResponseEntity<String> reducirTiempoResolucion(Integer idIncidente, int horasAReducir) {
        try {
            Incidentes incidente = incidentesRepository.findById(idIncidente)
                    .orElseThrow(() -> new RuntimeException("Incidente no encontrado con ID: " + idIncidente));

            if (!incidente.isResuelto() && incidente.getTiempoResolucion() > horasAReducir) {
                incidente.setTiempoResolucion(incidente.getTiempoResolucion() - horasAReducir);
                incidentesRepository.save(incidente);
                return ResponseEntity.ok("Horas de resolución reducidas con éxito para el incidente con ID: " + idIncidente);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("No se cumplen las condiciones para reducir las horas de resolución para el incidente con ID: " + idIncidente);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al reducir las horas de resolución para el incidente con ID: " + idIncidente);
        }
    }

    @Transactional
    public ResponseEntity<String> marcarComoResuelto(Integer idIncidente, String consideraciones) {
        try {
            Incidentes incidente = incidentesRepository.findById(idIncidente)
                    .orElseThrow(() -> new RuntimeException("Incidente no encontrado con ID: " + idIncidente));

            if (!incidente.isResuelto()) {
                incidente.setResuelto(true);
                incidentesRepository.save(incidente);

                enviarCorreoAlCliente(incidente.getCliente().getMail(), "Su incidente ha sido resuelto\n" + consideraciones);

                return ResponseEntity.ok("Incidente marcado como resuelto con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El incidente ya está marcado como resuelto");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al marcar el incidente como resuelto");
        }
    }

    private void enviarCorreoAlCliente(String destino, String mensaje) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mesa-de-ayuda@utnproyecto.com");
        mailMessage.setTo(destino);
        mailMessage.setSubject("Notificación de resolución de incidente");
        mailMessage.setText(mensaje);
        mailSender.send(mailMessage);
    }

    /*

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/tecnicos/marcarComoResuelto/3590

        El técnico indica el incidente que quiere marcar como resuelto y envía las consideraciones
        en el body.
        En la tabla incidentes, en el campo "resuelto" se cambia de "0" a "1"
        Con mailtrap se simula el envío al mail del cliente que realizó el reclamo por parte del sistema
        en donde se le informa que se ha solucionado el incidente y además las consideraciones del
        operario.

     */
}

