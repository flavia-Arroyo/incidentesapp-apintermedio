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
    private Set<Servicios> listaServicios;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)

    private Set<Incidente>listIncidentes;






}
