package com.apintermedio.incidentes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long incidenteId;
    private String descripcionProblema;
    private LocalDate fechaIncidente;
    private Boolean estado;
    private LocalTime horaIncidente;
    @ManyToOne
    @JoinColumn(name="fk_cliente", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="fk_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;

    @OneToMany(mappedBy = "incidente")
    private List<TipoProblema> tipoProblema;






}
