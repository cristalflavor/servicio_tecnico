package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Tecnicos {
    @Id
    private Integer idTecnico;

    private String apellido;
    private String nombre;
    private String contacto;
    private boolean disponible;
    private boolean estado;

}