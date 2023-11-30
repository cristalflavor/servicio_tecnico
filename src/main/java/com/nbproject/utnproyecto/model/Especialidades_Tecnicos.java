package com.nbproject.utnproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
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
