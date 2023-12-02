package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.*;
import com.nbproject.utnproyecto.repository.RRHHRepository;
import com.nbproject.utnproyecto.service.RRHHService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rrhh")
public class RRHHController {
    private final RRHHService rrhhService;
    private final RRHHRepository rrhhRepository;

    @GetMapping("/tiempoResolucionTecnicos")
    public ResponseEntity<List<TiempoResolucion>> obtenerTiempoResolucionTecnicos(){
        List<TiempoResolucion> tiempoResolucion = rrhhService.obtenerTiempoResolucionTecnicos();

        return ResponseEntity.ok(tiempoResolucion);
    }

    /*
        RRHH Pide una lista con los tecnicos más rápidos

        POSTMAN
        GET
        http://localhost:9090/serviciotecnico/rrhh/tiempoResolucionTecnicos


     */

    @GetMapping("/incidentes-diarios")
    public ResponseEntity<List<Incidentes>> obtenerIncidentesDiarios(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaVisita) {
        List<Incidentes> incidentesDiarios = rrhhService.obtenerIncidentesDiarios(fechaVisita);
        return ResponseEntity.ok(incidentesDiarios);
    }

    /*
        RRHH consulta los incidentes diarios según la fecha suministrada

        POSTMAN
        GET
        http://localhost:9090/serviciotecnico/rrhh/incidentes-diarios?fechaVisita=2023-10-21

        Este ejemplo devolverá un JSON con los 4 incidentes del día suministrado

        Key: fechaVisita
        Value: 2023-10-21

     */

    @GetMapping("/tecnico/masIncidentes/{fechaInicio}/{fechaFin}")
    public List<Object[]> encontrarTecnicoConMasIncidentesEnRango(
            @PathVariable("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @PathVariable("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return rrhhService.encontrarTecnicoConMasIncidentesEnRango(fechaInicio, fechaFin);
    }



}
