package com.apintermedio.incidentes.entity;

import com.apintermedio.incidentes.enumerados.Estados;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor

@Data
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

    @ManyToOne
    @JoinColumn(name="fk_cliente", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="fk_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;

    @OneToMany(mappedBy = "incidente")
    @JsonIgnore
    private List<TipoProblema> tipoProblema;

    public Incidente(String descripcionProblema, Cliente cliente) {
        this.descripcionProblema = descripcionProblema;

        this.cliente = cliente;
        this.estado = Estados.ABIERTO;
    }
    public void determinarFecha (){
        this.fechaIncidente = LocalDate.now ();
    }


}
