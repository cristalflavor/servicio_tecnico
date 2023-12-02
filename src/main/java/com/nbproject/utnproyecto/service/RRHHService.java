package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.model.TiempoResolucion;
import com.nbproject.utnproyecto.repository.RRHHRepository;
import com.nbproject.utnproyecto.repository.TecnicosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RRHHService {
    private final RRHHRepository rrhhRepository;
    private final TecnicosRepository tecnicosRepository;

    public List<TiempoResolucion> obtenerTiempoResolucionTecnicos() {
        List<TiempoResolucion> resultados = rrhhRepository.obtenerTiempoResolucionTecnicos();

        List<TiempoResolucion> tiempoResolucion = new ArrayList<>();

        Map<Integer, Double> promedios = resultados.stream()
                .collect(Collectors.groupingBy(
                        TiempoResolucion::getIdTecnico,
                        Collectors.averagingDouble(TiempoResolucion::getTiempoResolucion)
                ));

        for (Map.Entry<Integer, Double> entry : promedios.entrySet()) {
            tiempoResolucion.add(new TiempoResolucion(entry.getKey(), entry.getValue().doubleValue()));
        }

        tiempoResolucion.sort(Comparator.comparingDouble(TiempoResolucion::getTiempoResolucion));

        return tiempoResolucion;

    }

    public List<Incidentes> obtenerIncidentesDiarios(LocalDate fechaVisita) {
        return rrhhRepository.findByFechaVisita(fechaVisita);
    }

    public List<Object[]> encontrarTecnicoConMasIncidentesEnRango(LocalDate fechaInicio, LocalDate fechaFin) {
        return rrhhRepository.findTecnicoConMasIncidentesEnRango(fechaInicio, fechaFin);
    }

    public Optional<Tecnicos> getTecnicoById(Integer idTecnico) {
        return tecnicosRepository.findByIdTecnico(idTecnico);
    }

    /*
    No llegué con esto

    public List<Object[]> encontrarTecnicoConMasIncidentesEnRangoConEspecialidad(
            LocalDate fechaInicio, LocalDate fechaFin, Integer idEspecialidad) {
        return rrhhRepository.findTecnicoConMasIncidentesEnRangoConEspecialidad(fechaInicio, fechaFin, idEspecialidad);
    }*/


}