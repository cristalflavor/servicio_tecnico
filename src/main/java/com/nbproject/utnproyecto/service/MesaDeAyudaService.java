package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Servicios;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.repository.EspecialidadesRepository;
import com.nbproject.utnproyecto.repository.TecnicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MesaDeAyudaService {
    @Autowired
    private final TecnicosService tecnicosService;
    @Autowired
    private final EspecialidadesService especialidadesService;
    private final ServiciosService serviciosService;
    @Autowired
    public MesaDeAyudaService(TecnicosService tecnicosService, ServiciosService servicioService, EspecialidadesService especialidadesService) {
        this.serviciosService = servicioService;
        this.tecnicosService = tecnicosService;
        this.especialidadesService = especialidadesService;
    }
    public List<Servicios> obtenerServiciosPorCliente(String razonSocial, Long cuit) {

        return serviciosService.obtenerServiciosPorCliente(razonSocial, cuit);
    }

    public List<Tecnicos> obtenerTecnicosParaServicio(int idAplicacion, int idEntorno) {
        Integer idEspecialidad = especialidadesService.obtenerIdEspecialidad(idAplicacion, idEntorno);

        return tecnicosService.findByEspecialidadIdEspecialidad(idEspecialidad);

    }
}
