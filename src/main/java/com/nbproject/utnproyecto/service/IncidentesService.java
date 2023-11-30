package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.repository.IncidentesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class IncidentesService {

    private final IncidentesRepository incidentesRepository;

    public LocalDate obtenerFechaVisita(int idIncidente){

        return incidentesRepository.findById(idIncidente)
                .map(Incidentes::getFechaVisita)
                .orElse(null);
    }
}
