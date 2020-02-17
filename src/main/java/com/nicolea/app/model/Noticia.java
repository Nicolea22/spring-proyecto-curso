package com.nicolea.app.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "noticias")
public class Noticia {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="titulo", length = 250, nullable = false)
    private String titulo;

    @Column(name="fecha", nullable = false)
    private Date fecha;

    @Column(name="detalle", nullable = false)
    private String detalle;

    private String estatus;

    public Noticia() {
        this.fecha = new Date();
        this.estatus = "Activa";
    }

    public Noticia(String titulo, String detalle, String estatus) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }

    public enum Status {
        Activa,
        Inactiva;
    }
}


