package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaDeAyudaService {
    private final ServiciosService serviciosService; // Un servicio dedicado para las operaciones con servicios
    @Autowired
    public MesaDeAyudaService(ServiciosService servicioService) {
        this.serviciosService = servicioService;
    }
    public List<Servicios> obtenerServiciosPorCliente(String razonSocial, int cuit) {
        // Lógica para obtener servicios por cliente, podría incluir validaciones y llamadas al servicio de servicios
        return serviciosService.obtenerServiciosPorCliente(razonSocial, cuit);
    }
}
