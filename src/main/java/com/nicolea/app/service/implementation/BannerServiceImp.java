package com.nicolea.app.service.implementation;

import com.nicolea.app.model.Banner;
import com.nicolea.app.service.IBannerService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class BannerServiceImp implements IBannerService {

    List<Banner> banners;

    public BannerServiceImp() {
        this.banners = new LinkedList<Banner>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Banner banner1 =  new Banner();
            banner1.setId(1);
            banner1.setTitulo("Kong: La isla calavera");
            banner1.setArchivo("slide1.jpg");
            banner1.setStatus("Activa");
            banner1.setFecha(formatter.parse("02-05-2017"));

            Banner banner2 =  new Banner();
            banner2.setId(2);
            banner2.setTitulo("La bella y la bestia");
            banner2.setArchivo("slide2.jpg");
            banner2.setStatus("Activa");
            banner2.setFecha(formatter.parse("02-05-2017"));

            Banner banner3 =  new Banner();
            banner3.setId(3);
            banner3.setTitulo("Spiderman: De regreso a casa");
            banner3.setArchivo("slide3.jpg");
            banner3.setStatus("Activa");
            banner3.setFecha(formatter.parse("02-05-2017"));

            Banner banner4 =  new Banner();
            banner4.setId(4);
            banner4.setTitulo("Cars 3");
            banner4.setArchivo("slide4.jpg");
            banner4.setStatus("Activa");
            banner4.setFecha(formatter.parse("02-05-2017"));

            Banner banner5 =  new Banner();
            banner5.setId(5);
            banner5.setTitulo("Un golpe con estilo");
            banner5.setArchivo("slide5.jpg");
            banner5.setStatus("Activa");
            banner5.setFecha(formatter.parse("02-05-2017"));

            Banner banner6 =  new Banner();
            banner6.setId(6);
            banner6.setTitulo("Alien Covenant");
            banner6.setArchivo("slide6.jpg");
            banner6.setStatus("Activa");
            banner6.setFecha(formatter.parse("02-05-2017"));

            Banner banner7 =  new Banner();
            banner7.setId(7);
            banner7.setTitulo("El rey Arturo");
            banner7.setArchivo("slide7.jpg");
            banner7.setStatus("Activa");
            banner7.setFecha(formatter.parse("02-05-2017"));

            banners.add(banner1);
            banners.add(banner2);
            banners.add(banner3);
            banners.add(banner4);
            banners.add(banner5);
            banners.add(banner6);
            banners.add(banner7);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void insertar(Banner banner) {
        banner.setId(banners.get(banners.size() - 1).getId() + 1);
        banner.setFecha(new Date());
        banners.add(banner);
    }

    public List<Banner> buscarTodos() {
        return banners;
    }

}
