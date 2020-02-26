package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Detalle;
import com.nicolea.app.repository.DetallesRepository;
import com.nicolea.app.service.IDetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImp implements IDetallesService {

    @Autowired
    private DetallesRepository detallesRepository;

    @Override
    public void insertar(Detalle detalle) {
        detallesRepository.save(detalle);
    }
}
