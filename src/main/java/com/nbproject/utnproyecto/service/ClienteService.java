package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Clientes addCliente(Clientes clientes){
        Clientes clientes1 = null;
        clientes1 = clienteRepository.save(clientes);
        return clientes1;
    };

    public void eliminarCliente(int idCliente){
        clienteRepository.deleteById(idCliente);
    }

    public List<Clientes> getAllCliente(){
        List<Clientes> listClientes = clienteRepository.findAll();
      return listClientes;
    };


}
