package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Clientes;
import com.nbproject.utnproyecto.model.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer> {
    List<Servicios> findByClienteIdCliente(Integer idCliente);
}
