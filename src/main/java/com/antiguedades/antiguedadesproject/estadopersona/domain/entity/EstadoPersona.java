package com.antiguedades.antiguedadesproject.estadopersona.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estados_persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_persona_id")
    private Long idEstadoPersona;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @OneToMany(mappedBy = "estadoPersona")
    private List<Persona> personas;
}
