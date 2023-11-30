package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Incidentes {
    @Id
    private Integer idIncidente;

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
    private LocalDate fechaVisita;
    private String complejidad;
    private boolean resuelto;
}
