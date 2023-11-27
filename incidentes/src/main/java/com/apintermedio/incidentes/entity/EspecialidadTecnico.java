package com.apintermedio.incidentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Table(name="especialidad")
public class EspecialidadTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long especialidadId;
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "listaEspecialidades")

    private Set<Tecnico> listaTecnicos;
    @ManyToMany(mappedBy = "listaEspecialidades")

    private Set<TipoProblema>tipoProblema;

    public EspecialidadTecnico(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

}
