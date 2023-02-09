package com.besy.bcsb.controlador;

import com.besy.bcsb.dominio.Genero;
import com.besy.bcsb.dominio.PeliculaSerie;
import com.besy.bcsb.utilidades.DatosUtilidad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas-series")
public class PeliculaSerieControlador {

    @GetMapping
    public ResponseEntity<List<PeliculaSerie>> mostrarTodos(){
        List<Genero> generos = DatosUtilidad.creacionGeneros();
        return ResponseEntity.ok().body(DatosUtilidad.creacionPeliculasSerie(generos));
    }

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<?> buscarporTitulo(@PathVariable("titulo") String titulo) {
        return ResponseEntity.ok().body(DatosUtilidad.filtrarPeliculasSeriesPorTitulo(titulo));
    }

    @GetMapping("/calificaciones")
    public ResponseEntity<?> peliculasSeriesPorRangoDeCalificacion(@RequestParam int desde, @RequestParam int hasta){
        try {
            return ResponseEntity.ok().body(DatosUtilidad.filtrarPeliculasSeriesPorRangoDeCalificacion(desde, hasta));
        }catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/fechas")
    ResponseEntity<?> peliculasSeriesPorRangoDeFecha(@RequestParam String desde, @RequestParam String hasta){
        try {
            return ResponseEntity.ok().body(DatosUtilidad.filtrarPeliculaSeriesPorFecha(desde, hasta));
        }catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public  ResponseEntity<?> agregarNuevaPeliculaSerie (@RequestBody PeliculaSerie peliculaSerieNueva){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(DatosUtilidad.agregarPeliculaSerie(peliculaSerieNueva));
        } catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<?>modificarPeliculaSerie(@PathVariable Long id, @RequestBody PeliculaSerie peliculaSerieModificada){
        try{
            return ResponseEntity.ok(DatosUtilidad.modificarPeliculaSerie(id,peliculaSerieModificada));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}