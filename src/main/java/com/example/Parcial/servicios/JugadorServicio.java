package com.example.Parcial.servicios;

import com.example.Parcial.modelos.Jugador;
import com.example.Parcial.repositorios.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServicio {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    public List<Jugador> obtenerTodos() {
        return jugadorRepositorio.findAll();
    }

    public Optional<Jugador> obtenerPorId(Long id) {
        return jugadorRepositorio.findById(Math.toIntExact(id));
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepositorio.save(jugador);
    }

    public void eliminar(Long id) {
        jugadorRepositorio.deleteById(Math.toIntExact(id));
    }
}
