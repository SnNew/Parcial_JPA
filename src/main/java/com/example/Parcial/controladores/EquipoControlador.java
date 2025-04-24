package com.example.Parcial.controladores;

import com.example.Parcial.modelos.Equipo;
import com.example.Parcial.servicios.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;

    @GetMapping
    public List<Equipo> obtenerTodos() {
        return equipoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoServicio.obtenerPorId(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoServicio.guardar(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        if (equipoServicio.obtenerPorId(id).isPresent()) {
            equipo.setIdEquipo(Math.toIntExact(id));
            return ResponseEntity.ok(equipoServicio.guardar(equipo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (equipoServicio.obtenerPorId(id).isPresent()) {
            equipoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
