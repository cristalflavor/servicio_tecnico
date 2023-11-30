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
    /*
        POSTMAN
        Ejemplo:
        GET
        http://localhost:9090/serviciotecnico/mesadeayuda/tecnicos/1/1
     */

    @GetMapping("/tecnicos/{idAplicacion}/{idEntorno}")
    public ResponseEntity<List<Tecnicos>> obtenerTecnicosParaServicio(
            @PathVariable int idAplicacion,
            @PathVariable int idEntorno) {
        List<Tecnicos> tecnicos = mesaDeAyudaService.obtenerTecnicosParaServicio(idAplicacion, idEntorno);
        return ResponseEntity.ok(tecnicos);
    }
    /*
        POSTMAN
        Ejemplo:
        GET
        http://localhost:9090/serviciotecnico/mesadeayuda/tecnicos/1/1
     */

    @PostMapping("/informarIncidente")
    public ResponseEntity<String> informarIncidente(@RequestBody Incidentes incidente){
        mesaDeAyudaService.informarIncidente(incidente);

        return ResponseEntity.ok("Incidente informado al técnico");
    }

    /*
        No llamé al método obtenerTecnicosParaServicio dentro de informarIncidente
        porque la Mesa de Ayuda debía elegir uno, por lo cual supongo que se hace
        desde el front, por tanto es lógica dependiente y por tanto pendiente de front


        Se puede utilizar este ejemplo:

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/mesadeayuda/informarIncidente
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
        "fechaVisita": "2023-30-11",
        "complejidad": "ALTA",
        "resuelto": 0
        }


     */

    @PostMapping("/notificarVisita/{idIncidente}")
    public ResponseEntity<String> notificarVisita(@PathVariable int idIncidente){
        LocalDate fechaVisita = incidentesService.obtenerFechaVisita(idIncidente);

        return ResponseEntity.ok("El Técnico atenderá el incidente el día:"  + fechaVisita);
    }

    /*
        POSTMAN
        Ejemplo:
        POST
        http://localhost:9090/serviciotecnico/mesadeayuda/notificarVisita/3589

        (En este ejemplo la fecha estará vieja porque la base de datos me quedó viejita)
   */

}
