package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.repository.ClienteRepository;
import com.nbproject.utnproyecto.repository.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ServiciosService {

    private final ClienteRepository clienteRepository;
    private final ServiciosRepository serviciosRepository;
    @Autowired
    public ServiciosService(ClienteRepository clienteRepository, ServiciosRepository serviciosRepository){
        this.clienteRepository = clienteRepository;
        this.serviciosRepository = serviciosRepository;
    }

    public List<Servicios> obtenerServiciosPorCliente(String razonSocial, Long cuit){
        Clientes cliente = clienteRepository.findByRazonSocialAndCuit(razonSocial, cuit);

        if(cliente != null){
            return serviciosRepository.findByClienteIdCliente(cliente.getIdCliente());
        }else{
            return Collections.emptyList();
        }

    }

}
