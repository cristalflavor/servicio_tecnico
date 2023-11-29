package com.nbproject.utnproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
public class Clientes {
    @Id
    private Integer idCliente;

    private String apellido;

    private String nombre;

    private Long cuit;

    private String razonSocial;

    private boolean estado;

    public Integer getIdCliente() {
        return this.idCliente;
    }
}
