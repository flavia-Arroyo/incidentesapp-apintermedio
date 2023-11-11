package com.apintermedio.incidentes.repository;

import com.apintermedio.incidentes.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnicoRepository extends JpaRepository<Tecnico,Long> {

}
