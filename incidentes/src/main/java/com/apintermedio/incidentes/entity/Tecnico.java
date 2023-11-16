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
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long tecnicoId;
    private String nombreCompleto;
    private String email;
    @OneToMany(mappedBy = "tecnico")
    private List<Incidente> listIncidente;
    @ManyToMany
    @JoinTable(name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "idTecnico"),
            inverseJoinColumns = @JoinColumn(name="especialidadId"))
    private List<EspecialidadTecnico> listaEspecialidades;




}
