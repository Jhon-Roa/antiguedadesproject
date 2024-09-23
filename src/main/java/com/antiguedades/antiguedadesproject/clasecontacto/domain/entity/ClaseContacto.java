package com.antiguedades.antiguedadesproject.clasecontacto.domain.entity;

import com.antiguedades.antiguedadesproject.contactopersona.domain.entity.ContactoPersona;

import jakarta.persistence.CascadeType;
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
@Table(name = "clase_contacto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaseContacto {
    @Id
    @Column(name = "clase_contacto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClaseContacto;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @OneToMany(mappedBy = "claseContacto", cascade = CascadeType.ALL)
    private java.util.List<ContactoPersona> contactosPersona;
}
