package com.nicolea.app.repository;

import com.nicolea.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

    @Query(value = "SELECT * FROM Horarios h WHERE h.fecha = :fecha", nativeQuery = true)
    List<Horario> findByFecha(@Param("fecha") Date fecha);

}
