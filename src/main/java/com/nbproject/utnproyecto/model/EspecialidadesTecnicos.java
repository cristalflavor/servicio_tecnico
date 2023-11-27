package com.nbproject.utnproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EspecialidadesTecnicos {
    @Id
    @ManyToOne
    private Tecnicos tecnico;

    @Id
    @ManyToOne
    private Especialidades especialidad;
}
