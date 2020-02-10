package com.nicolea.app.controller;

import com.nicolea.app.model.Banner;
import com.nicolea.app.service.IBannerService;
import com.nicolea.app.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/banners")
public class BannersController {

    @Autowired
    IBannerService bannerService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Banner> banners = bannerService.buscarTodos();
        model.addAttribute("banners", banners);
        return "banners/listBanner";
    }

    @GetMapping("/create")
    public String crear() {
        return "banners/formBanner";
    }

    @PostMapping("/save")
    public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
        if (!multiPart.isEmpty()) {
            banner.setArchivo(Utileria.guardarImagen(multiPart, request));
        }

        if (result.hasErrors()) {
            return "banners/formBanner";
        }
        bannerService.insertar(banner);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/banners/index";
    }


}