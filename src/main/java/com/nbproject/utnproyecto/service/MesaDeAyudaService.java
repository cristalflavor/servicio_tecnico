package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.repository.EspecialidadesRepository;
import com.nbproject.utnproyecto.repository.IncidentesRepository;
import com.nbproject.utnproyecto.repository.TecnicosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MesaDeAyudaService {
    /*
        Acá dejé los Autowired para que me queden de ejemplo de cómo se usan
        sé que con annotations se ahorra esto!

     */
    @Autowired
    private final TecnicosService tecnicosService;
    @Autowired
    private final EspecialidadesService especialidadesService;
    @Autowired
    private final ServiciosService serviciosService;
    @Autowired
    private final IncidentesRepository incidentesRepository;
    @Autowired
    public MesaDeAyudaService(IncidentesRepository incidentesRepository, TecnicosService tecnicosService, ServiciosService servicioService, EspecialidadesService especialidadesService) {
        this.serviciosService = servicioService;
        this.tecnicosService = tecnicosService;
        this.especialidadesService = especialidadesService;
        this.incidentesRepository = incidentesRepository;
    }
    public List<Servicios> obtenerServiciosPorCliente(String razonSocial, Long cuit) {

        return serviciosService.obtenerServiciosPorCliente(razonSocial, cuit);
    }

    public List<Tecnicos> obtenerTecnicosParaServicio(int idAplicacion, int idEntorno) {
        Integer idEspecialidad = especialidadesService.obtenerIdEspecialidad(idAplicacion, idEntorno);

        return tecnicosService.findByEspecialidadIdEspecialidad(idEspecialidad);

    }

    public void informarIncidente(Incidentes incidente){
        incidentesRepository.save(incidente);
    }
}
