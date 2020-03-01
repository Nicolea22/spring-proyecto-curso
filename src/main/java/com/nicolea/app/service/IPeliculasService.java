package com.nicolea.app.service;

import com.nicolea.app.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Page<Pelicula> buscarPorPagina(int page);

    Pelicula buscarPorId(int idPelicula);

    void insertar(Pelicula pelicula);

    void eliminar(Pelicula pelicula);

    List<String> buscarGeneros();

}