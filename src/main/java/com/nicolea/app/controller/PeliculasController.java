package com.nicolea.app.controller;


import com.nicolea.app.model.Pelicula;
import javax.servlet.http.HttpServletRequest;
import com.nicolea.app.service.IPeliculasService;
import com.nicolea.app.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Pelicula> lista = peliculasService.buscarTodas();
        model.addAttribute("peliculas", lista);
        return "peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Pelicula pelicula) {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

        if (!multiPart.isEmpty()) {
            pelicula.setImagen(Utileria.guardarImagen(multiPart, request));
        }

        if (result.hasErrors()) {
            return "peliculas/formPelicula";
        }
        peliculasService.insertar(pelicula);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/peliculas/index";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }





}
