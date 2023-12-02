package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.service.IncidentesService;
import com.nbproject.utnproyecto.service.MesaDeAyudaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mesadeayuda")
public class MesaDeAyudaController {

    private final MesaDeAyudaService mesaDeAyudaService;
    private final IncidentesService incidentesService;

    @GetMapping("/servicios/{razonSocial}/{cuit}")
    public ResponseEntity<List<Servicios>> obtenerServiciosPorCliente(
            @PathVariable String razonSocial,
            @PathVariable Long cuit) {
        List<Servicios> servicios = mesaDeAyudaService.obtenerServiciosPorCliente(razonSocial, cuit);
        return ResponseEntity.ok(servicios);
    }

    /*  CICLO DE VIDA: CLIENTES dan datos para MESA DE AYUDA conocer los SERVICIOS
        POSTMAN
        Ejemplo:
        GET
        http://localhost:9090/serviciotecnico/mesadeayuda/servicios/Vinchuca%20Records/16245454629

        El CLIENTE suministra la RAZÓN SOCIAL y el CUIT a la MESA DE AYUDA
        y se obtiene una lista con el o los SERVICIOS asociados
        Un SERVICIO es la conjunción del ENTORNO (Windows, Linux, etc) y APLICACIONES (Tango, SAP, etc)
        La tabla "servicios" en la base de datos cuenta de:
        idServicio, idAplicacion, idEntorno, y idCliente(foránea utilizada)

        Con los datos suministrados se obtiene el idCliente, y con éste, con el método
        de ServiciosService se obtiene el/los registros de la tabla servicios

        Devuelve:
        [
            {
                "idServicio": 2,
                "idAplicacion": {
                    "idAplicacion": 2,
                    "nombre": "SAP"
                },
                "idEntorno": {
                    "idEntorno": 2,
                    "nombre": "Mac"
                },
                "cliente": {
                    "idCliente": 1557,
                    "apellido": "Robledo",
                    "nombre": "Lucía Elmira",
                    "cuit": 16245454629,
                    "razonSocial": "Vinchuca Records",
                    "estado": true
                }
            },
            {
                "idServicio": 3,
                "idAplicacion": {
                    "idAplicacion": 3,
                    "nombre": "Trello"
                },
                "idEntorno": {
                    "idEntorno": 4,
                    "nombre": "Navegador"
                },
                "cliente": {
                    "idCliente": 1557,
                    "apellido": "Robledo",
                    "nombre": "Lucía Elmira",
                    "cuit": 16245454629,
                    "razonSocial": "Vinchuca Records",
                    "estado": true
                }
            }
        ]

     */

    @GetMapping("/tecnicos/{idAplicacion}/{idEntorno}")
    public ResponseEntity<List<Tecnicos>> obtenerTecnicosParaServicio(
            @PathVariable int idAplicacion,
            @PathVariable int idEntorno) {
        List<Tecnicos> tecnicos = mesaDeAyudaService.obtenerTecnicosParaServicio(idAplicacion, idEntorno);
        return ResponseEntity.ok(tecnicos);
    }

    /*
        CICLO DE VIDA: MESA DE AYUDA obtiene listado de TECNICOS con las ESPECIALIDADES adecuadas
        POSTMAN
        Ejemplo:
        GET
        http://localhost:9090/serviciotecnico/mesadeayuda/tecnicos/1/1

        MESA DE AYUDA con los datos idAplicacion (1 - "Tango") idEntorno (1 - "Windows") puede pedir
        un listado de los TECNICOS con las ESPECIALIDADES de expertise de Tango en Windows

        Devuelve:

        [
            {
                "idTecnico": 2556,
                "apellido": "Ruggeri",
                "nombre": "Horacio Jeremías",
                "contacto": "3413208245",
                "disponible": true,
                "estado": true
            },
            {
                "idTecnico": 2561,
                "apellido": "Mamana",
                "nombre": "Alicia María José",
                "contacto": "3413208245",
                "disponible": true,
                "estado": true
            }
        ]
     */


    @PostMapping("/tecnicos/informarIncidente")
    public ResponseEntity<String> informarIncidente(@RequestBody Incidentes incidente){
        mesaDeAyudaService.informarIncidente(incidente);

        return ResponseEntity.ok("Incidente informado al técnico");
    }


    /*
        No se llamó al método obtenerTecnicosParaServicio dentro de informarIncidente
        porque la Mesa de Ayuda debía elegir uno, por lo cual se supuso que se hace
        desde el front, por tanto es lógica dependiente y por tanto pendiente de front

        CICLO DE VIDA: MESA DE AYUDA informa el INCIDENTES al TECNICOS elegido
        Informarlo supone crear un registro en la tabla incidentes la cual tiene toda la información
        necesaria: la fechaVisita, tiempoResolucion, si esta resuelto o no, el idTecnico, etc
        AGREGAR MÉTODOS PARA DIFERENCIAR MAIL DE WHATSAPP

        Se puede utilizar este ejemplo:
        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/mesadeayuda/tecnicos/informarIncidente

        En el body enviar el JSON:

        {
        "idIncidente": 3590,
        "cliente": {
            "idCliente": 1557,
            "apellido": "Robledo",
            "nombre": "Lucía Elmira",
            "cuit": 16245454629,
            "razonSocial": "Vinchuca Records",
            "estado": true
        },
        "aplicacion": {
            "idAplicacion": 2,
            "nombre": "SAP"
        },
        "entorno": {
            "idEntorno": 2,
            "nombre": "Mac"
        },
        "tecnico": {
            "idTecnico": 2558,
            "apellido": "Kossman",
            "nombre": "David Sebastián",
            "contacto": "kossmantec@hotmail.com",
            "disponible": 0,
            "estado": 1
        },
        "tiempoResolucion": 3,
        "fechaVisita": "2023-01-12",
        "complejidad": "BAJA",
        "resuelto": 0
        }

     */

    @PostMapping("/cliente/notificarVisita/{idIncidente}")
    public ResponseEntity<String> notificarVisita(@PathVariable int idIncidente){
        LocalDate fechaVisita = incidentesService.obtenerFechaVisita(idIncidente);

        return ResponseEntity.ok("El Técnico atenderá el incidente el día: "  + fechaVisita);
    }

    /*
        CICLO DE VIDA: MESA DE AYUDA notifica al CLIENTE el día en que el operario irá
        a atender el INCIDENTE

        POSTMAN
        Ejemplo:
        POST
        http://localhost:9090/serviciotecnico/mesadeayuda/cliente/notificarVisita/3589

        (En este ejemplo la fecha estará vieja porque la base de datos me quedó viejita)

        Devuelve:

        El Técnico atenderá el incidente el día: 2023-11-01
   */

}
