package com.nicolea.app.service;

import com.nicolea.app.model.Horario;

import java.util.Date;
import java.util.List;

public interface IHorariosService {

    List<Horario> buscarPorIdYFecha(int idPelicula, Date fecha);
    void insertar(Horario horario);

}
