package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.IncidentesResueltos;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.model.TiempoResolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface RRHHRepository extends JpaRepository<Incidentes, Integer> {

    @Query(value = "SELECT new com.nbproject.utnproyecto.model.TiempoResolucion(i.tecnico.idTecnico, cast (i.tiempoResolucion as double)) FROM Incidentes i")
    List<TiempoResolucion> obtenerTiempoResolucionTecnicos();

    List<Incidentes> findByFechaVisita(LocalDate fechaVisita);

    @Query("SELECT t, COUNT(i) AS totalIncidentes FROM Tecnicos t JOIN t.incidentes i " +
            "WHERE i.resuelto = true AND i.fechaVisita BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY t ORDER BY totalIncidentes DESC")
    List<Object[]> findTecnicoConMasIncidentesEnRango(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin);
}