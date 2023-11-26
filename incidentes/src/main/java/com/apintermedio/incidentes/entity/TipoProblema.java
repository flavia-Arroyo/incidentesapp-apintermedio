package com.apintermedio.incidentes.entity;

import com.apintermedio.incidentes.enumerados.Complegidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idTipoProblema;
    private String descripcionProblema;
    private Complegidad complegidad;
    private Integer horasMaximaResolucion;

    @ManyToMany
    @JoinTable(name = "tipoProblema_Especialidad",
            joinColumns = @JoinColumn(name ="id_problema"),
            inverseJoinColumns = @JoinColumn(name="id_especialidades"))
    private List<EspecialidadTecnico>listaEspecialidades;

    @ManyToMany(mappedBy = "tipoProblema")
    private Set<Incidente> listIncidente;




    public void borrarEspecialidad (EspecialidadTecnico espe){
        this.listaEspecialidades.remove ( espe );
    }


    public void asignarHoraMaxima(TipoProblema problema){
        switch (problema.getComplegidad ()){
            case ALTA -> setHorasMaximaResolucion(36);
            case MEDIA -> setHorasMaximaResolucion ( 24 );
            case BAJA -> setHorasMaximaResolucion ( 12);
        }
    }


}
