package com.nicolea.app.controller;


import com.nicolea.app.model.Contacto;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ContactoController {

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
        model.addAttribute("generos", peliculasService.buscarGeneros());
        return "formContacto";
    }

}
