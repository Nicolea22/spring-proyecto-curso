package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Horario;
import com.nicolea.app.repository.HorariosRepository;
import com.nicolea.app.service.IHorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HorariosServiceImp implements IHorariosService {

    @Autowired
    private HorariosRepository horariosRepository;

    public HorariosServiceImp() throws ParseException {
    }

    public List<Horario> buscarPorIdYFecha(int idPelicula, Date fecha) {
        return horariosRepository.findByFecha(fecha);
    }

    public void insertar(Horario horario) {
        horariosRepository.save(horario);
    }

}
