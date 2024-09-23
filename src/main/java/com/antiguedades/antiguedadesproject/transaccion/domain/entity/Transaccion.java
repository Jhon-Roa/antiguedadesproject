package com.antiguedades.antiguedadesproject.transaccion.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.antiguedades.antiguedadesproject.detalletransaccion.domain.entity.DetalleTransaccion;
import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transacciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {
    @Id
    @Column(name = "transaccion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacionn;

    @ManyToOne
    private Persona persona;

    @OneToMany(mappedBy = "transaccion", cascade = CascadeType.ALL)
    private List<DetalleTransaccion> detallesTransaccion;
}
