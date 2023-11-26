package com.apintermedio.incidentes.entity;

import com.apintermedio.incidentes.enumerados.Estados;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
//@ToString
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long incidenteId;
    private String descripcionProblema;
    private LocalDate fechaIncidente;
    private Estados estado;
    private LocalTime horaIncidente;
    private LocalTime horaEstimadaTecnico;
    private LocalDateTime fechaHoraTerminara;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_tecnico", nullable = false)
    private Tecnico tecnico;
    @ManyToMany
    @JoinTable(name="incidente_problema",
    joinColumns = @JoinColumn(name="incidente_id"),
    inverseJoinColumns = @JoinColumn(name="problema_id"))
    private Set<TipoProblema> tipoProblema;


    public void determinarFecha (){

        this.fechaIncidente = LocalDate.now ();

    }

    public void horaIncidente() {
        horaIncidente= LocalTime.now ();

    }



}
