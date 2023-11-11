package com.apintermedio.incidentes.entity;

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
    private Long especialidadId;
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "listaEspecialidades")
    private List<Tecnico>listaTecnicos;



}
