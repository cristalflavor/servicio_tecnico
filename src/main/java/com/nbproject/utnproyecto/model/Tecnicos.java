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
public class Tecnicos {
    @Id
    private Integer idTecnico;

    private String apellido;
    private String nombre;
    private String contacto;
    private boolean disponible;
    private boolean estado;
}
