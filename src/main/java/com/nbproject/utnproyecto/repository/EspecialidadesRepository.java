package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadesRepository extends JpaRepository<Especialidades, Integer> {
    Optional<Especialidades> findByAplicacionIdAplicacionAndEntornoIdEntorno(int idAplicacion, int idEntorno);
}
