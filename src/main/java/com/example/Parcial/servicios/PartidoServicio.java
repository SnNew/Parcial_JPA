package com.example.Parcial.servicios;

import com.example.Parcial.modelos.Partido;
import com.example.Parcial.repositorios.PartidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoServicio {

    @Autowired
    private PartidoRepositorio partidoRepositorio;

    public List<Partido> obtenerTodos() {
        return partidoRepositorio.findAll();
    }

    public Optional<Partido> obtenerPorId(Long id) {
        return partidoRepositorio.findById(Math.toIntExact(id));
    }

    public Partido guardar(Partido partido) {
        return partidoRepositorio.save(partido);
    }

    public void eliminar(Long id) {
        partidoRepositorio.deleteById(Math.toIntExact(id));
    }
}
