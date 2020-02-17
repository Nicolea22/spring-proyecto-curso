package com.nicolea.app.pruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class PruebaConexion {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
        System.out.println(((DriverManagerDataSource)ctx.getBean("dataSource")).getUrl());
        ((ConfigurableApplicationContext)ctx).close();
    }
}