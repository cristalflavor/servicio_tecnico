package com.nbproject.utnproyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "incidentes"})
public class Tecnicos {
    @Id
    private Integer idTecnico;

    private String apellido;
    private String nombre;
    private String contacto;
    private boolean disponible;
    private boolean estado;

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<Incidentes> incidentes;

}