package com.nicolea.app.controller;

import com.nicolea.app.model.Pelicula;
import com.nicolea.app.util.Utileria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public List<Pelicula> getLista() {
        List<Pelicula> peliculas = new LinkedList<Pelicula>();
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
            pelicula3.setStatus("Activa");

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

			return peliculas;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String buscar(Model model, @RequestParam("fecha") String fecha) {
        model.addAttribute("fechaBusqueda", fecha);
        List<String> listaFechas = Utileria.getNextDays(3);
        List<Pelicula> peliculas = getLista();
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("peliculas", peliculas);
        return "home";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
        return "detalles";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPrincipal(Model model) {
        List<String> listaFechas = Utileria.getNextDays(3);
        List<Pelicula> peliculas = getLista();
        model.addAttribute("fechaBusqueda", formatter.format(new Date()));
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("peliculas", peliculas);
        return "home";
    }

}
