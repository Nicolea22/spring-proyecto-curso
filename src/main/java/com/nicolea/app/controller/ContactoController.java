package com.nicolea.app.controller;


import com.nicolea.app.model.Contacto;
import com.nicolea.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
        model.addAttribute("generos", peliculasService.buscarGeneros());
        model.addAttribute("tipos", tipoNotificaciones());
        return "formContacto";
    }

    @PostMapping("/contacto")
    public String guardar(@ModelAttribute Contacto contacto) {
        return "redirect:/contacto";
    }

    private List<String> tipoNotificaciones() {
        List<String> tipos = new LinkedList<String>();
        tipos.add("Estrenos");
        tipos.add("Promociones");
        tipos.add("Noticias");
        tipos.add("Preventas");
        return tipos;
    }

}