package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Table(name = "especialidades_tecnicos")
public class Especialidades_Tecnicos {

    @Id
    private Integer idEspecialidades_tecnicos;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidades especialidad;
}
