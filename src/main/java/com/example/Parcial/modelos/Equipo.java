package com.example.Parcial.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partido> partidosVisita;

    public Equipo() {
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(List<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }

    public List<Partido> getPartidosVisita() {
        return partidosVisita;
    }

    public void setPartidosVisita(List<Partido> partidosVisita) {
        this.partidosVisita = partidosVisita;
    }
}
