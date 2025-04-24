package com.example.Parcial.controladores;

import com.example.Parcial.modelos.Partido;
import com.example.Parcial.servicios.PartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoControlador {

    @Autowired
    private PartidoServicio partidoServicio;

    @GetMapping
    public List<Partido> obtenerTodos() {
        return partidoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
        Optional<Partido> partido = partidoServicio.obtenerPorId(id);
        return partido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoServicio.guardar(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(@PathVariable Long id, @RequestBody Partido partido) {
        if (partidoServicio.obtenerPorId(id).isPresent()) {
            partido.setIdPartido(Math.toIntExact(id));
            return ResponseEntity.ok(partidoServicio.guardar(partido));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (partidoServicio.obtenerPorId(id).isPresent()) {
            partidoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
