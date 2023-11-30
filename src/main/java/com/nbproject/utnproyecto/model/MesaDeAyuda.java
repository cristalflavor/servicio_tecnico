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
    private Integer idMesaDeAyuda;

    private String password;
    private String apellido;
    private String nombre;
}
