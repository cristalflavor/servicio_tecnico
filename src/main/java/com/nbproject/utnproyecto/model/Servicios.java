package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Servicios {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    @ManyToOne
    @JoinColumn(name = "idAplicacion")
    private Aplicaciones aplicacion;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno entorno;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;
}
