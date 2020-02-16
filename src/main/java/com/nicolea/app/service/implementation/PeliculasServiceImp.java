package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Detalle;
import com.nicolea.app.model.Pelicula;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.stereotype.Service;

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
            Detalle detalle1 = new Detalle();

            pelicula1.setId(1);
            pelicula1.setTitulo("Power Rangers");
            pelicula1.setDuracion(120);
            pelicula1.setClasificacion("B");
            pelicula1.setGenero("Aventura");
            pelicula1.setImagen("cinema.png");
            pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
            pelicula1.setStatus("Activa");

            detalle1.setTrailer("https://www.youtube.com/embed/5kIe6UZHSXw");
            detalle1.setSinopsis("Cinco adolescentes ordinarios deben convertirse en superhéroes cuando se enteran de que su pequeña ciudad de Ángel Grove, y el mundo entero, están a punto de ser borrados por una amenaza alienígena.");
            pelicula1.setDetalle(detalle1);

            Pelicula pelicula2 = new Pelicula();
            Detalle detalle2 = new Detalle();

            pelicula2.setId(2);
            pelicula2.setTitulo("La bella y la bestia");
            pelicula2.setDuracion(132);
            pelicula2.setClasificacion("A");
            pelicula2.setGenero("Infantil");
            pelicula2.setImagen("bella.png");
            pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
            pelicula2.setStatus("Activa");

            detalle2.setTrailer("https://www.youtube.com/embed/XpMjfUJ1lUc");
            detalle2.setSinopsis("Belle, una joven hermosa y brillante, asume el lugar de su padre como prisionero en el castillo de una bestia. Poco a poco, la valiente Belle irá dándose cuenta de que el príncipe bestia no es el malvado ser que todos creen que es y tiene, en realidad, un gran corazón.");
            pelicula2.setDetalle(detalle2);


            Pelicula pelicula3 = new Pelicula();
            Detalle detalle3 = new Detalle();

            pelicula3.setId(3);
            pelicula3.setTitulo("Contratiempo");
            pelicula3.setDuracion(106);
            pelicula3.setClasificacion("B");
            pelicula3.setGenero("Thriller");
            pelicula3.setImagen("contratiempo.png");
            pelicula3.setFechaEstreno(formatter.parse("20-05-2017"));
            pelicula3.setStatus("Inactiva");

            detalle3.setTrailer("https://www.youtube.com/embed/Fo6-sfYjn1s");
            detalle3.setSinopsis("La vida del exitoso empresario Adrián Doria se vuelve una pesadilla cuando una mañana se despierta en una habitación de hotel junto al cadáver de su amante. Él está convencido de su inocencia, pero las pruebas demuestran lo contrario. Después de que su esposa lo abandone, Adrián contrata los servicios de Virginia Goodman, la mejor preparadora de testigos del país. Asesora y cliente deberán trabajar para encontrar la manera de demostrar la inocencia de Adrián.");
            pelicula3.setDetalle(detalle3);

            Pelicula pelicula4 = new Pelicula();
            Detalle detalle4 = new Detalle();

            pelicula4.setId(4);
            pelicula4.setTitulo("Kong La Isla Calavera");
            pelicula4.setDuracion(118);
            pelicula4.setClasificacion("B");
            pelicula4.setGenero("Accion y Aventura");
            pelicula4.setImagen("kong.png");
            pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
            pelicula4.setStatus("Inactiva");

            detalle4.setTrailer("https://www.youtube.com/embed/8wP_3OO3Res");
            detalle4.setSinopsis("En la década de 1970, un grupo de soldados y exploradores, acompañados por una fotoperiodista, llega a una isla del Pacífico habitada por un simio gigantesco y otros monstruos. Marlow, un peculiar habitante del lugar, guía a los aventureros a través de las misteriosas junglas y marismas de la isla.");
            pelicula4.setDetalle(detalle4);

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

    public Pelicula buscarPorId(int idPelicula) {
        for(Pelicula pelicula : peliculas){
            if(pelicula.getId() == idPelicula ) {
                return pelicula;
            }
        }
        return null;
    }

    public void insertar(Pelicula pelicula) {
        peliculas.add(pelicula);
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
