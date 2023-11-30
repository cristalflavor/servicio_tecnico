package com.nbproject.utnproyecto.repository;

import com.nbproject.utnproyecto.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
    Clientes findByRazonSocialAndCuit(String razonSocial, Long cuit);

    @Modifying
    @Query("UPDATE Clientes c SET c.estado = false WHERE c.idCliente = ?1")
    void darDeBajaCliente(int idCliente);
}
