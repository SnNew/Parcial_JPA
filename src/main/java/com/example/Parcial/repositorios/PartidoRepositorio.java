package com.example.Parcial.repositorios;

import com.example.Parcial.modelos.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidoRepositorio extends JpaRepository<Partido, Integer> {

    // Obtener los resultados de todos los partidos indicando los nombres de los equipos
    @Query("SELECT p.fecha, p.golesLocal, p.golesVisita, p.equipoLocal.nombre AS equipoLocal, p.equipoVisita.nombre AS equipoVisita " +
            "FROM Partido p")
    List<Object[]> findResultadosPartidos();
}
