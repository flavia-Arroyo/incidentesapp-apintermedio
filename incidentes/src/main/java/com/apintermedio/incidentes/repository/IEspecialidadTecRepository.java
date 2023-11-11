package com.apintermedio.incidentes.repository;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadTecRepository extends JpaRepository<EspecialidadTecnico, Long> {
}
