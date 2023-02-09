package com.besy.bcsb.dominio;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeliculaSerie {


    private Long id;
    private String titulo;
    private LocalDate fechaDeCreacion;
    private int calificacion;
    private Genero genero;
    @JsonIgnore
    private List<Personaje> listaPersonajes;

    public PeliculaSerie(){
    };

     public PeliculaSerie(Long id, String titulo, LocalDate fechaDeCreacion, int calificacion, Genero genero) {
         this.id = id;
         this.titulo = titulo;
         this.fechaDeCreacion = fechaDeCreacion;
         this.calificacion = calificacion;
         this.genero = genero;
         this.listaPersonajes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
         return titulo;
    }

    public void setTitulo(String titulo) {
         this.titulo = titulo;
    }

    public LocalDate getFechaDeCreacion() {
         return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
         this.fechaDeCreacion = fechaDeCreacion;
    }

    public int getCalificacion() {
         return calificacion;
    }

    public void setCalificacion(int calificacion) {
         this.calificacion = calificacion;
    }

    public Genero getGenero() {
         return genero;
    }

    public void setGenero(Genero genero) {
         this.genero = genero;
    }
}
