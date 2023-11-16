package com.apintermedio.incidentes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idTipoProblema;
    private String descripcionProblema;
    private String complegidad;
    private LocalTime horasMaximaResolucion;
    private LocalTime horaEstimadaTecnico;
    @ManyToMany
    @JoinTable(name = "tipoProblema_Especialidad",
            joinColumns = @JoinColumn(name ="id_problema"),
            inverseJoinColumns = @JoinColumn(name="id_especialidades"))
    private List<EspecialidadTecnico>listaEspecialidades;
    @ManyToOne
    @JoinColumn(name="fk_incidente", referencedColumnName = "id")
    private Incidente incidente;


}
