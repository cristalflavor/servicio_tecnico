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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidente;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes idCliente;

    @ManyToOne
    @JoinColumn(name = "idAplicacion")
    private Aplicaciones idAplicacion;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno idEntorno;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos idTecnico;

    private int tiempoResolucion;
    private LocalDate fechaVista;
    private String complejidad;
    private boolean resuelto;
}
