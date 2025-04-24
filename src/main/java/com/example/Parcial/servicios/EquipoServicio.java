package com.example.Parcial.servicios;

import com.example.Parcial.modelos.Equipo;
import com.example.Parcial.repositorios.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServicio {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    public List<Equipo> obtenerTodos() {
        return equipoRepositorio.findAll();
    }

    public Optional<Equipo> obtenerPorId(Long id) {
        return equipoRepositorio.findById(Math.toIntExact(id));
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    public void eliminar(Long id) {
        equipoRepositorio.deleteById(Math.toIntExact(id));
    }
}
