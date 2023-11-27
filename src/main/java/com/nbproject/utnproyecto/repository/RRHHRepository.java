package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.RRHH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRHHRepository extends JpaRepository<RRHH, Integer> {

}
