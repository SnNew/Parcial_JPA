package com.example.Parcial.repositorios;

import com.example.Parcial.modelos.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticasJugadorRepositorio extends JpaRepository<EstadisticasJugador, Long> {  // Cambiar Integer a Long
}
