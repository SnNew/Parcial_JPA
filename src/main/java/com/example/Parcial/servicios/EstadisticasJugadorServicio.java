package com.example.Parcial.servicios;

import com.example.Parcial.modelos.EstadisticasJugador;
import com.example.Parcial.repositorios.EstadisticasJugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorServicio {

    @Autowired
    private EstadisticasJugadorRepositorio estadisticasJugadorRepositorio;

    public List<EstadisticasJugador> obtenerTodos() {
        return estadisticasJugadorRepositorio.findAll();
    }

    public Optional<EstadisticasJugador> obtenerPorId(Long id) {
        return estadisticasJugadorRepositorio.findById(id);
    }

    public EstadisticasJugador guardar(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepositorio.save(estadisticasJugador);
    }

    public void eliminar(Long id) {
        estadisticasJugadorRepositorio.deleteById(id);
    }
}
