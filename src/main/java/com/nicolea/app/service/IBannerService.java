package com.nicolea.app.service;

import com.nicolea.app.model.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBannerService {

    void insertar(Banner banner);
    List<Banner> buscarTodos();
}
