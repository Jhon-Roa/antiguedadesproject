package com.antiguedades.antiguedadesproject.direccionpersona.domain.entity;

import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion_persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionPersona {
    @Id
    @Column(name = "direccion_persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccionPersona;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @ManyToOne
    private Persona persona;
}
