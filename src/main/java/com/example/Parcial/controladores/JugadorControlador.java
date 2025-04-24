package com.example.Parcial.controladores;

import com.example.Parcial.modelos.Jugador;
import com.example.Parcial.servicios.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorControlador {

    @Autowired
    private JugadorServicio jugadorServicio;

    @GetMapping
    public List<Jugador> obtenerTodos() {
        return jugadorServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorServicio.obtenerPorId(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorServicio.guardar(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
        if (jugadorServicio.obtenerPorId(id).isPresent()) {
            jugador.setIdJugador(Math.toIntExact(id));
            return ResponseEntity.ok(jugadorServicio.guardar(jugador));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (jugadorServicio.obtenerPorId(id).isPresent()) {
            jugadorServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
