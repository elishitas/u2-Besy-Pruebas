package com.besy.bcsb.dominio;

import java.security.PrivateKey;

public class Genero {

    private Long Id;
    private String nombre;

    public Genero(Long Id,String nombre) {
        this.Id = Id;
        this.nombre = nombre;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
