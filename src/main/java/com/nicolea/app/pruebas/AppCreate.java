package com.nicolea.app.pruebas;

import com.nicolea.app.model.Noticia;
import com.nicolea.app.repository.NoticiasRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AppCreate {

    public static void main(String[] args) {
//        Noticia noticia = new Noticia();
//        noticia.setTitulo("Proximo estreno: Juego Macabro 8");
//        noticia.setDetalle("El mes de septiembre se estrena la nueva entrega de SAW 8");

        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

//        NoticiasRepository repo = ctx.getBean("noticiasRepository", NoticiasRepository.class);
//        repo.save(noticia);

        ((ConfigurableApplicationContext)ctx).close();


    }
}
