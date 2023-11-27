package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Incidentes {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidente;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idAplicacion")
    private Aplicaciones aplicacion;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno entorno;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnico;

    private int tiempoResolucion;
    private LocalDate fechaVista;
    private String complejidad;
    private boolean resuelto;
}
