package com.example.Parcial.repositorios;

import com.example.Parcial.modelos.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {  // Cambiar Integer a Long
}
