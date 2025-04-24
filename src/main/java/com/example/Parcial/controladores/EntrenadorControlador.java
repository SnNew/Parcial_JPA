package com.example.Parcial.controladores;

import com.example.Parcial.modelos.Entrenador;
import com.example.Parcial.servicios.EntrenadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorControlador {

    @Autowired
    private EntrenadorServicio entrenadorServicio;

    @GetMapping
    public List<Entrenador> obtenerTodos() {
        return entrenadorServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerPorId(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorServicio.obtenerPorId(id);
        return entrenador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return entrenadorServicio.guardar(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        if (entrenadorServicio.obtenerPorId(id).isPresent()) {
            entrenador.setIdEntrenador(Math.toIntExact(id));
            return ResponseEntity.ok(entrenadorServicio.guardar(entrenador));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (entrenadorServicio.obtenerPorId(id).isPresent()) {
            entrenadorServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
