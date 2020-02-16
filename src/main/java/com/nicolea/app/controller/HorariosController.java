package com.nicolea.app.controller;

import com.nicolea.app.model.Horario;
import com.nicolea.app.model.Pelicula;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    private IPeliculasService servicePeliculas;

    @GetMapping("/create")
    public String create(@ModelAttribute Horario horario, Model model) {
        List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
        model.addAttribute("peliculas", listaPeliculas);
        return "horarios/formHorarios";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model) {

        if (result.hasErrors()){
            List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
            model.addAttribute("peliculas", listaPeliculas);
            return "horarios/formHorarios";
        }

        return "redirect:/horarios/create";
    }

    /**
     * Personalizamos el Data Binding para todas las propiedades de tipo Date
     * @param binder
     */
    @InitBinder("horario")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
