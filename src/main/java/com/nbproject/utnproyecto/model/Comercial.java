package com.nbproject.utnproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Comercial {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComercial;

    private String password;
    private String apeliido;
    private String nombre;
}
