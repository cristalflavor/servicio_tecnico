package com.nbproject.utnproyecto.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncidentesResueltos {
    @Id
    private Integer idTecnico;
    private Integer numeroIncidentes;


}