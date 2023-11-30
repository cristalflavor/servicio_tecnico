package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Especialidades {
    @Id
    private Integer idEspecialidad;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno entorno;

    @ManyToOne
    @JoinColumn(name = "idAplicacion")
    private Aplicaciones aplicacion;
}
