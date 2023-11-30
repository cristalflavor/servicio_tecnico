package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;

    public void saveCliente(Clientes cliente){

        clienteRepository.save(cliente);
    }

    public void darDeBajaCliente(int idCliente){
        clienteRepository.darDeBajaCliente(idCliente);
    }
    /*
        POSTMAN
        POST
        http://localhost:9090/comercial/altaCliente
    */
    public List<Clientes> getAllCliente(){
        List<Clientes> listClientes = clienteRepository.findAll();
        return listClientes;
    };


}
