package com.apintermedio.incidentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals ( razonSocial, cliente.razonSocial ) && Objects.equals ( cuit, cliente.cuit ) && Objects.equals ( domicilio, cliente.domicilio ) && Objects.equals ( email, cliente.email ) && Objects.equals ( listaServicios, cliente.listaServicios ) && Objects.equals ( listIncidentes, cliente.listIncidentes );
    }


}
