package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Especialidades_Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Especialidades_TecnicosRepository extends JpaRepository<Especialidades_Tecnicos, Integer> {
    List<Especialidades_Tecnicos> findByEspecialidad_IdEspecialidad(Integer idEspecialidad);
}
