package com.antiguedades.antiguedadesproject.contactopersona.domain.entity;

import java.util.List;

import com.antiguedades.antiguedadesproject.clasecontacto.domain.entity.ClaseContacto;
import com.antiguedades.antiguedadesproject.persona.domain.entity.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacto_persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactoPersona {
    @Id
    @Column(name = "contacto_persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContactoPersona;

    @NotNull
    @Size(max = 50)
    @Column(name = "informacion_contacto")
    private String informacionContacto;

    @ManyToOne
    @JoinColumn(name = "clase_contacto_id")
    private ClaseContacto claseContacto;

    @OneToMany(mappedBy = "contactoPersona")
    private List<Persona> personas;
}
