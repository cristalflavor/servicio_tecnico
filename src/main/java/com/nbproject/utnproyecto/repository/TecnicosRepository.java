package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnicos, Integer> {
    Optional<Tecnicos> findByIdTecnico(Integer idTecnico);
}