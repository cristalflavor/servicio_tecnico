package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Incidentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentesRepository extends JpaRepository<Incidentes, Integer> {

}
