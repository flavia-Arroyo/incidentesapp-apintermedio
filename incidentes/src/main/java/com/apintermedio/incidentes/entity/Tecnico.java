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
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long tecnicoId;
    private String nombreCompleto;
    private String email;
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private Set<Incidente> listIncidente;
    @ManyToMany
    @JoinTable(name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "idTecnico"),
            inverseJoinColumns = @JoinColumn(name="especialidadId"))
    private Set<EspecialidadTecnico> listaEspecialidades;

    public Tecnico(String nombreCompleto, String email) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public Set<Incidente> asignarIncidente(Incidente incidente) {
        this.listIncidente.add(incidente);

        return listIncidente;
    }



    public void asignarEpecialidad(EspecialidadTecnico espe){
        this.listaEspecialidades.add(espe);


    }

}
