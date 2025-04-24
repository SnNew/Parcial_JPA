package com.example.Parcial.servicios;

import com.example.Parcial.modelos.Entrenador;
import com.example.Parcial.repositorios.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorServicio {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepositorio.findAll();
    }

    public Optional<Entrenador> obtenerPorId(Long id) {
        return entrenadorRepositorio.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepositorio.save(entrenador);
    }

    public void eliminar(Long id) {
        entrenadorRepositorio.deleteById(id);
    }
}
