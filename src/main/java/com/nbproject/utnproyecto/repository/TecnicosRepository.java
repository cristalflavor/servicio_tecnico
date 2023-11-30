package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnicos, Integer> {
}