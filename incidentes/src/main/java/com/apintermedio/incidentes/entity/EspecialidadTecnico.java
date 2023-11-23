package com.apintermedio.incidentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor

@Data
//@ToString
@Table(name="especialidad")
public class EspecialidadTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long especialidadId;
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "listaEspecialidades")
    @JsonIgnore
    private List<Tecnico>listaTecnicos;
    @ManyToMany(mappedBy = "listaEspecialidades")
    @JsonIgnore
    private List<TipoProblema>tipoProblema;

    public EspecialidadTecnico(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    public void asignarTecnico(Tecnico tecnico){
        this.listaTecnicos.add(tecnico);
    }
}
