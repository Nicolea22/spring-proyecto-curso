package com.nicolea.app.service;

import com.nicolea.app.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int idPelicula);

    void insertar(Pelicula pelicula);

    List<String> buscarGeneros();

}