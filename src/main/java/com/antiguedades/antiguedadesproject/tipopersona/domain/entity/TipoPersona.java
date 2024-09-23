package com.antiguedades.antiguedadesproject.tipopersona.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipos_persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_persona_id")
    private Long idTipoPersona;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @ManyToMany(mappedBy = "tiposPersona", cascade = CascadeType.ALL)
    private List<Persona> personas;
}
