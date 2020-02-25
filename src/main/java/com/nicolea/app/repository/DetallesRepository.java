package com.nicolea.app.repository;

import com.nicolea.app.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallesRepository extends JpaRepository<Detalle, Integer> {
}
