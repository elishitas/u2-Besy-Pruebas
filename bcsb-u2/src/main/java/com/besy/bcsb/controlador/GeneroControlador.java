
package com.besy.bcsb.controlador;

import com.besy.bcsb.dominio.Genero;
import com.besy.bcsb.dominio.PeliculaSerie;
import com.besy.bcsb.utilidades.DatosUtilidad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")

public class GeneroControlador {
    //http://localhost:9080/generos
    @GetMapping ResponseEntity<List<Genero>> verTodosLosGeneros(){
        List<Genero> generos = DatosUtilidad.creacionGeneros();
        return ResponseEntity.ok().body(generos);
    }

    //http://localhost:9080/generos/aventura
    @GetMapping("/{nombre}")
    public List<PeliculaSerie> buscarPorNombreDeGenero(@PathVariable("nombre") String nombreGenero){
        return DatosUtilidad.filtrarPeliculasSeriesPorNombreDeGenero(nombreGenero);
    }

    @PostMapping
    public ResponseEntity<List<Genero>> agragarNuevoGenero(@RequestBody Genero nuevoGenero){
        return ResponseEntity.status(HttpStatus.CREATED).body(DatosUtilidad.agregarGenero(nuevoGenero));
    }
    //http://localhost:9080/generos/2
    // {
    //        "nombre": "Comediana",
    //        "id": 1
    //    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarGenero(@PathVariable Long id, @RequestBody Genero genero){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(DatosUtilidad.modificarGenero(id, genero));
        } catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
