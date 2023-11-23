package com.apintermedio.incidentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@ToString
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long clienteId;
    private String razonSocial;
    private Long cuit;
    private String domicilio;
    private String email;
    @ManyToMany
    @JoinTable(name = "clientes_servicios",
    joinColumns = @JoinColumn(name ="id_cliente"),
    inverseJoinColumns = @JoinColumn(name="id_servicio"))
    private List<Servicios> listaServicios;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Incidente>listIncidentes;


    public List<Servicios> asignarServicios(Servicios serv){
        this.listaServicios.add(serv);
        return listaServicios;

    }



}
