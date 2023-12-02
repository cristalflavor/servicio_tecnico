package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Incidentes;
import com.nbproject.utnproyecto.model.TiempoResolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RRHHRepository extends JpaRepository<Incidentes, Integer> {

    @Query(value = "SELECT new com.nbproject.utnproyecto.model.TiempoResolucion(i.tecnico.idTecnico, cast (i.tiempoResolucion as double)) FROM Incidentes i")
    List<TiempoResolucion> obtenerTiempoResolucionTecnicos();

    List<Incidentes> findByFechaVisita(LocalDate fechaVisita);

    @Query("SELECT t.idTecnico, COUNT(i) AS totalIncidentes " +
            "FROM Tecnicos t JOIN t.incidentes i " +
            "WHERE i.resuelto = true " +
            "AND i.fechaVisita BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY t.idTecnico " +
            "ORDER BY totalIncidentes DESC")
    List<Object[]> findTecnicoConMasIncidentesEnRango(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin);

    /*

    No llegué con esto

    @Query("SELECT t.idTecnico, COUNT(i) AS totalIncidentes " +
            "FROM Tecnicos t " +
            "JOIN t.incidentes i " +
            "JOIN t.especialidades_Tecnicos et " + // Usar el nombre de la entidad
            "JOIN et.especialidad e " +
            "WHERE i.resuelto = true " +
            "AND i.fechaVisita BETWEEN :fechaInicio AND :fechaFin " +
            "AND e.idEspecialidad = :idEspecialidad " + // Usar el nombre del atributo
            "GROUP BY t.idTecnico " +
            "ORDER BY totalIncidentes DESC")
    List<Object[]> findTecnicoConMasIncidentesEnRangoConEspecialidad(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("idEspecialidad") Integer idEspecialidad);*/




}