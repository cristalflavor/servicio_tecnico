package com.nbproject.utnproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MesaDeAyuda {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMesaDeAyuda;

    private String password;
    private String apeliido;
    private String nombre;
}
