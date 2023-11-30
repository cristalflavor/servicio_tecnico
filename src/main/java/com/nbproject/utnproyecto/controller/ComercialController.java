package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comercial")
public class ComercialController {

    private final ClienteService clienteService;

    @PostMapping("/altaCliente")
    public ResponseEntity<String> altaCliente(@RequestBody Clientes cliente){
        clienteService.saveCliente(cliente);

        return ResponseEntity.ok("Cliente dado de alta!");
    }

    @PostMapping("/bajaCliente/{idCliente}")
    public ResponseEntity<String> bajaCliente(@PathVariable int idCliente){
        clienteService.darDeBajaCliente(idCliente);

        return ResponseEntity.ok("Cliente dado de baja!");
    }
}