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
public class Clientes {
    @Id
    private int idCliente;

    private String apellido;

    private String nombre;

    private int cuit;

    private String razonSocial;

    private boolean estado;

}
