package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    @NonNull
    private final ClienteService clienteService;


    @GetMapping("/todos")
    public ResponseEntity<Object> listarClientes (){

        return ResponseEntity.ok(clienteService.getAllCliente());
    }


}