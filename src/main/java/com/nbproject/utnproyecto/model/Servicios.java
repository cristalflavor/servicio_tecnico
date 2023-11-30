package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Servicios {
    @Id
    private Integer idServicio;

    @ManyToOne
    @JoinColumn(name = "idAplicacion")
    private Aplicaciones idAplicacion;

    @ManyToOne
    @JoinColumn(name = "idEntorno")
    private Entorno idEntorno;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;
}
