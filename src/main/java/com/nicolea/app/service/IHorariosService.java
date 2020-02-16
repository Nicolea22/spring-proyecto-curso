package com.nicolea.app.service;

import com.nicolea.app.model.Horario;

public interface IHorariosService {

    Horario buscarPorId(int idHorario);
    void insertar(Horario horario);

}
