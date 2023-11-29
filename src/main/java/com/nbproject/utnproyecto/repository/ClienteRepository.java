package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
    Clientes findByRazonSocialAndCuit(String razonSocial, Long cuit);
}
