package com.nicolea.app.repository;

import com.nicolea.app.model.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
