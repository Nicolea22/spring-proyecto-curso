package com.nicolea.app.controller;

import com.nicolea.app.model.Noticia;
import com.nicolea.app.service.implementation.INoticiasServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {


    @Autowired
    private INoticiasServiceImp noticiasService;

    @GetMapping(value="/create")
    public String crear() {
        return "noticias/formNoticia";
    }

    @PostMapping(value = "/save")
    public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, @RequestParam("detalle") String detalle){
        noticiasService.guardar(new Noticia(titulo, detalle, estatus));
        return "noticias/formNoticia";
    }

}