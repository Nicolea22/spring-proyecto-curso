package com.nicolea.app.repository;

import com.nicolea.app.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {
}
