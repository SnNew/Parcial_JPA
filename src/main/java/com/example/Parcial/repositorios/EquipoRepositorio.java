package com.example.Parcial.repositorios;

import com.example.Parcial.modelos.Equipo;
import com.example.Parcial.modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> {

    // Obtener todos los jugadores de un equipo específico
    @Query("SELECT j FROM Jugador j WHERE j.equipo.idEquipo = ?1")
    List<Jugador> findJugadoresByEquipoId(Integer equipoId);

    // Obtener el número total de goles marcados por un equipo en todos sus partidos
    @Query("SELECT SUM(p.golesLocal) + SUM(p.golesVisita) FROM Partido p WHERE p.equipoLocal.idEquipo = ?1 OR p.equipoVisita.idEquipo = ?1")
    Integer findTotalGolesByEquipoId(Integer equipoId);

    // Obtener los resultados de todos los partidos indicando los nombres de los equipos
    @Query("SELECT p.fecha, p.golesLocal, p.golesVisita, p.equipoLocal.nombre AS equipoLocal, p.equipoVisita.nombre AS equipoVisita " +
            "FROM Partido p")
    List<Object[]> findResultadosPartidos();
}
