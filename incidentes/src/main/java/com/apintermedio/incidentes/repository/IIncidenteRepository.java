package com.apintermedio.incidentes.repository;

import com.apintermedio.incidentes.entity.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidenteRepository extends JpaRepository<Incidente, Long> {
}
