package com.antiguedades.antiguedadesproject.sucursal.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.ciudad.domain.entity.Ciudad;
import com.antiguedades.antiguedadesproject.empresa.domain.entity.Empresa;
import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id")
    private Long idsucursal;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    private List<Persona> personas;

    @OneToMany(mappedBy = "sucursal")
    private List<Sucursal> sucursales;
}
