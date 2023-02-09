package com.besy.bcsb.controlador;

import com.besy.bcsb.dominio.PeliculaSerie;
import com.besy.bcsb.dominio.Personaje;
import com.besy.bcsb.utilidades.DatosUtilidad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    @GetMapping
    public ResponseEntity<List<Personaje>> filtrarPersonaje() {
        List<Personaje> personajes = (DatosUtilidad.creacionPersonajes());
        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity filtrarPorNombre(@PathVariable("nombre") String nombrePersonaje) {
        try {
            return ResponseEntity.ok().body(DatosUtilidad.filtrarPersonajesPorNombre(nombrePersonaje));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity filtrarPorEdad(@PathVariable ("edad") int edad){
        try {
            return ResponseEntity.ok().body(DatosUtilidad.filtrarPersonajesPorEdad(edad));
        } catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/edades")
    public ResponseEntity filtrarPorRangoDeEdad(@RequestParam int desde, @RequestParam int hasta){
        try {
            return new ResponseEntity(DatosUtilidad.filtrarPorRangoDeEdad(desde, hasta), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<?> agregarNuevoPersonaje(@RequestBody Personaje personajeAgregado){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(DatosUtilidad.agregarPersonaje(personajeAgregado));
        } catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPersonaje(@PathVariable Long id, @RequestBody Personaje personajeModificado) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(DatosUtilidad.modificarPersonaje(id, personajeModificado));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}


