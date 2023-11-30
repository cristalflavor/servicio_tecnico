package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.service.MesaDeAyudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mesadeayuda")
public class MesaDeAyudaController {

    private final MesaDeAyudaService mesaDeAyudaService;
    @Autowired
    public MesaDeAyudaController(MesaDeAyudaService mesaDeAyudaService) {
        this.mesaDeAyudaService = mesaDeAyudaService;
    }
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
}
