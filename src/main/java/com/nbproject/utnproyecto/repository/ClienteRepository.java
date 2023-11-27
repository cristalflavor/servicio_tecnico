package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

}
