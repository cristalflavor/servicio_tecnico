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
public class Especialidades {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno entorno;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;
}
