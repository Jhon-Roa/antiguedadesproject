package com.antiguedades.antiguedadesproject.antiguedad.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.detalletransaccion.domain.entity.DetalleTransaccion;
import com.antiguedades.antiguedadesproject.sucursal.domain.entity.Sucursal;

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
@Table(name = "antiguedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Antiguedad {
    @Id
    @Column(name = "antiguedad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntiguedad;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @ManyToOne
    private Sucursal sucursal;

    @OneToMany(mappedBy = "antiguedad")
    private List<DetalleTransaccion> detallesTransaccion; 
}
