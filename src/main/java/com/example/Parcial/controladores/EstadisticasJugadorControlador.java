package com.example.Parcial.controladores;

import com.example.Parcial.modelos.EstadisticasJugador;
import com.example.Parcial.servicios.EstadisticasJugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas-jugadores")
public class EstadisticasJugadorControlador {

    @Autowired
    private EstadisticasJugadorServicio estadisticasJugadorServicio;

    @GetMapping
    public List<EstadisticasJugador> obtenerTodos() {
        return estadisticasJugadorServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> obtenerPorId(@PathVariable Long id) {
        Optional<EstadisticasJugador> estadisticasJugador = estadisticasJugadorServicio.obtenerPorId(id);
        return estadisticasJugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstadisticasJugador crear(@RequestBody EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorServicio.guardar(estadisticasJugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> actualizar(@PathVariable Long id, @RequestBody EstadisticasJugador estadisticasJugador) {
        if (estadisticasJugadorServicio.obtenerPorId(id).isPresent()) {
            estadisticasJugador.setIdEstadistica(Math.toIntExact(id));
            return ResponseEntity.ok(estadisticasJugadorServicio.guardar(estadisticasJugador));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (estadisticasJugadorServicio.obtenerPorId(id).isPresent()) {
            estadisticasJugadorServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
