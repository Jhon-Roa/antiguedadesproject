package com.antiguedades.antiguedadesproject.detalletransaccion.domain.entity;

import com.antiguedades.antiguedadesproject.antiguedad.domain.entity.Antiguedad;
import com.antiguedades.antiguedadesproject.transaccion.domain.entity.Transaccion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_transaccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleTransaccion {
    @Id
    @Column(name = "detalle_transaccion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleTransaccion;

    @ManyToOne
    private Transaccion transaccion;

    @ManyToOne
    private Antiguedad antiguedad;
}
