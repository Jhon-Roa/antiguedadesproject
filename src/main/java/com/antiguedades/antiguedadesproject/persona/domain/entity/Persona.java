package com.antiguedades.antiguedadesproject.persona.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.coleccionista.domain.entity.Coleccionista;
import com.antiguedades.antiguedadesproject.contactopersona.domain.entity.ContactoPersona;
import com.antiguedades.antiguedadesproject.direccionpersona.domain.entity.DireccionPersona;
import com.antiguedades.antiguedadesproject.empleado.domain.entity.Empleado;
import com.antiguedades.antiguedadesproject.estadopersona.domain.entity.EstadoPersona;
import com.antiguedades.antiguedadesproject.genero.domain.entity.Genero;
import com.antiguedades.antiguedadesproject.sucursal.domain.entity.Sucursal;
import com.antiguedades.antiguedadesproject.tipopersona.domain.entity.TipoPersona;
import com.antiguedades.antiguedadesproject.transaccion.domain.entity.Transaccion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @Column(name = "persona_id")
    private String idPersona;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Genero genero;

    @ManyToOne 
    @JoinColumn(name = "estado_persona_id")
    private EstadoPersona estadoPersona;

    @ManyToOne
    @JoinColumn(name = "contacto_persona_id")
    private ContactoPersona contactoPersona;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Empleado empleado;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Coleccionista coleccionista;

    @ManyToMany
    @JoinTable(
        name = "persona_tipo_persona",
        joinColumns = @JoinColumn(name = "persona_id"),
        inverseJoinColumns = @JoinColumn(name = "tipo_persona_id")
    )
    private List<TipoPersona> tiposPersona;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<DireccionPersona> direccionesPersona;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;
}
