package com.apintermedio.incidentes.repository;

import com.apintermedio.incidentes.entity.TipoProblema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProblemaRepository extends JpaRepository<TipoProblema,Long> {
}
