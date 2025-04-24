package com.example.Parcial.repositorios;

import com.example.Parcial.modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {

    // Obtener los jugadores que han marcado más de X goles
    @Query("SELECT j FROM Jugador j WHERE j.goles > ?1")
    List<Jugador> findJugadoresByGolesGreaterThan(Integer goles);
}
