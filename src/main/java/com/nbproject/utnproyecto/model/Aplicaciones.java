package com.nbproject.utnproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Aplicaciones {
    @Id
    private Integer idAplicacion;

    private String nombre;

}
