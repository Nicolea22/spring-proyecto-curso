package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Pelicula;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class PeliculasServiceImp implements IPeliculasService {

    List<Pelicula> peliculas = new LinkedList<Pelicula>();

    public PeliculasServiceImp() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Pelicula pelicula1 = new Pelicula();
            pelicula1.setId(1);
            pelicula1.setTitulo("Power Rangers");
            pelicula1.setDuracion(120);
            pelicula1.setClasificacion("B");
            pelicula1.setGenero("Aventura");
            pelicula1.setImagen("cinema.png");
            pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
            pelicula1.setStatus("Activa");

            Pelicula pelicula2 = new Pelicula();
            pelicula2.setId(2);
            pelicula2.setTitulo("La bella y la bestia");
            pelicula2.setDuracion(132);
            pelicula2.setClasificacion("A");
            pelicula2.setGenero("Infantil");
            pelicula2.setImagen("bella.png");
            pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
            pelicula2.setStatus("Activa");

            Pelicula pelicula3 = new Pelicula();
            pelicula3.setId(3);
            pelicula3.setTitulo("Contratiempo");
            pelicula3.setDuracion(106);
            pelicula3.setClasificacion("B");
            pelicula3.setGenero("Thriller");
            pelicula3.setImagen("contratiempo.png");
            pelicula3.setFechaEstreno(formatter.parse("20-05-2017"));
            pelicula3.setStatus("Inactiva");

            Pelicula pelicula4 = new Pelicula();
            pelicula4.setId(4);
            pelicula4.setTitulo("Kong La Isla Calavera");
            pelicula4.setDuracion(118);
            pelicula4.setClasificacion("B");
            pelicula4.setGenero("Accion y Aventura");
            pelicula4.setImagen("kong.png");
            pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
            pelicula4.setStatus("Inactiva");

            peliculas.add(pelicula1);
            peliculas.add(pelicula2);
            peliculas.add(pelicula3);
            peliculas.add(pelicula4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> buscarTodas() {
        return peliculas;
    }

    public Pelicula buscarPorId(int idPelicula){
        for(Pelicula pelicula : peliculas){
            if(pelicula.getId() == idPelicula ) {
                return pelicula;
            }
        }
        return null;
    }

    @PostMapping("/save")
    public void insertar(Pelicula pelicula) {
        peliculas.add(pelicula);
    }



}
