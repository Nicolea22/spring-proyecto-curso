package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Horario;
import com.nicolea.app.service.IHorariosService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

@Service
public class HorariosServiceImp implements IHorariosService {

    private List<Horario> horarios = new LinkedList<Horario>();

    public HorariosServiceImp() throws ParseException {
    }

    public Horario buscarPorId(int idHorario) {
        for(Horario horario : horarios) {
            if(horario.getId() == idHorario) {
                return horario;
            }
        }
        return null;
    }

    public void insertar(Horario horario) {
        horarios.add(horario);
    }

}
