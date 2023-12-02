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
    /*
        Este ejemplo puede utilizarse:

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/comercial/altaCliente

        En body, elegir raw, y luego JSON y enviar por ejemplo:
        {
            "idCliente": 1569,
            "apellido": "Elanga",
            "nombre": "Romina Luna",
            "cuit": 22246772829,
            "razonSocial": "UTN Programming",
            "mail": "utn-programing@utn.com",
            "estado": 1
        }

        No existen AUTO_INCREMENT en la base de datos porque al probar y errar se salteaban
        los id y por tanto me quedaban 1564 y pasaba al 1572
        como me hacía doler los ojos lo quité
    */

    @PostMapping("/bajaCliente/{idCliente}")
    public ResponseEntity<String> bajaCliente(@PathVariable int idCliente){
        clienteService.darDeBajaCliente(idCliente);

        return ResponseEntity.ok("Cliente dado de baja!");
    }

    /*
        Este ejemplo puede utilizarse (Si previamente se dio de alta el ejemplo de alta):

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/comercial/bajaCliente/1569
     */
}