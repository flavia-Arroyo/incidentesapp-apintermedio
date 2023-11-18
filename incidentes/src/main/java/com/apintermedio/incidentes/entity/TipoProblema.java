package com.apintermedio.incidentes.entity;

import com.apintermedio.incidentes.enumerados.Complegidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor

@Data
@ToString
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
    @ManyToOne
    @JoinColumn(name="fk_incidente", referencedColumnName = "id")
    private Incidente incidente;

    public TipoProblema(String descripcionProblema, Complegidad complegidad) {
        this.descripcionProblema = descripcionProblema;
        this.complegidad = complegidad;

    }

    public void asignarEspecialidad (EspecialidadTecnico espe){
        this.listaEspecialidades.add(espe);
    }
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
