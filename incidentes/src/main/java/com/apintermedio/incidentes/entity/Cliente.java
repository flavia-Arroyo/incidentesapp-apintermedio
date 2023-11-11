package com.apintermedio.incidentes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String razonSocial;
    private Long cuit;
    private String domicilio;
    private String email;
    @ManyToMany
    @JoinTable(name = "clientes_servicios",
    joinColumns = @JoinColumn(name ="id_cliente"),
    inverseJoinColumns = @JoinColumn(name="id_servicio"))
    private List<Servicios> listaServicios;



}
