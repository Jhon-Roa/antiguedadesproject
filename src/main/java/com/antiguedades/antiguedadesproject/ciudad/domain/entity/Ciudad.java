package com.antiguedades.antiguedadesproject.ciudad.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.region.domain.entity.Region;
import com.antiguedades.antiguedadesproject.sucursal.domain.entity.Sucursal;

import jakarta.persistence.CascadeType;
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
@Table(name = "ciudades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciudad_id")
    private Long idCiudad;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @ManyToOne
    private Region region;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales;
}
