package com.apintermedio.incidentes.repository;

import com.apintermedio.incidentes.entity.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IServicioRepository extends JpaRepository<Servicios, Long> {
}
