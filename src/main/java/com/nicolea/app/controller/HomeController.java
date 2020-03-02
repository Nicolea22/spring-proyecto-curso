package com.nicolea.app.controller;

import com.nicolea.app.model.Horario;
import com.nicolea.app.model.Pelicula;
import com.nicolea.app.service.IBannerService;
import com.nicolea.app.service.IHorariosService;
import com.nicolea.app.service.IPeliculasService;
import com.nicolea.app.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IPeliculasService servicePeliculas;

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private IHorariosService horariosService;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String buscar(Model model, @RequestParam("fecha") String fecha) {
        model.addAttribute("fechaBusqueda", fecha);
        List<String> listaFechas = Utileria.getNextDays(3);
        List<Pelicula> peliculas = servicePeliculas.buscarTodas();
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("peliculas", servicePeliculas.buscarTodas());
        return "home";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") Date fecha) {
        List<Horario> lista = horariosService.buscarPorIdYFecha(idPelicula, fecha);
        model.addAttribute("horarios", lista);
        model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
        return "detalles";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPrincipal(Model model) {
        List<String> listaFechas = Utileria.getNextDays(3);
        model.addAttribute("fechaBusqueda", formatter.format(new Date()));
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("peliculas", servicePeliculas.buscarTodas());
        model.addAttribute("banners", bannerService.buscarTodos());
        return "home";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
