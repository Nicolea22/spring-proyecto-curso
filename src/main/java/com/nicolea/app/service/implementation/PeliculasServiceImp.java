package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Pelicula;
import com.nicolea.app.repository.PeliculasRepository;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PeliculasServiceImp implements IPeliculasService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    public List<Pelicula> buscarTodas() {
        return peliculasRepository.findAll();
    }

    public Pelicula buscarPorId(int idPelicula) {
        return peliculasRepository.findById(idPelicula).get();
    }

    public void insertar(Pelicula pelicula) {
        peliculasRepository.save(pelicula);
    }

    public List<String> buscarGeneros() {
        List<String> generos = new LinkedList<String>();
        generos.add("Aventura");
        generos.add("Clasicas");
        generos.add("Comedia");
        generos.add("Drama");
        generos.add("Terror");
        generos.add("Infantil");
        generos.add("Accion");
        generos.add("Romantica");
        return generos;
    }
}
