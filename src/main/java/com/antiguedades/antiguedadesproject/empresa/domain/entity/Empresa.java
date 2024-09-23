package com.antiguedades.antiguedadesproject.empresa.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.sucursal.domain.entity.Sucursal;

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
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @Column(name = "empresa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;
}
