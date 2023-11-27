package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    @NonNull
    private ClienteService clienteService;
    @PostMapping("/crear")
    public ResponseEntity<String> guardarCliente(@RequestBody Clientes clientes){
        clienteService.addCliente(clientes);
        return ResponseEntity.ok("clientes guardado con éxito");
    }

    @GetMapping("/todos")
    public ResponseEntity<Object> listarClientes (){

        return ResponseEntity.ok(clienteService.getAllCliente());
    }


}