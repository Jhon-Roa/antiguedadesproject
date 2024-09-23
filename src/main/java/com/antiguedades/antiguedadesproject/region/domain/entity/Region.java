package com.antiguedades.antiguedadesproject.region.domain.entity;

import com.antiguedades.antiguedadesproject.ciudad.domain.entity.Ciudad;
import com.antiguedades.antiguedadesproject.pais.domain.entity.Pais;

import java.util.List;

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
@Table(name = "regiones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long idRegion;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @ManyToOne 
    private Pais pais;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Ciudad> ciudades;

}
