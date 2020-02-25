package com.nicolea.app.repository;

import com.nicolea.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
}
