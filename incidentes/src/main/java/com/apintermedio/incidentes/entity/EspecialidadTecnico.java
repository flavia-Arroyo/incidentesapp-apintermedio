package com.apintermedio.incidentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EspecialidadTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long especialidadId;
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "listaEspecialidades")
    @JsonIgnoreProperties("listaEspecialidades")
    private List<Tecnico>listaTecnicos;
    @ManyToMany(mappedBy = "listaEspecialidades")
    @JsonIgnoreProperties("listaEspecialidades")
    private List<TipoProblema>tipoProblema;



}
