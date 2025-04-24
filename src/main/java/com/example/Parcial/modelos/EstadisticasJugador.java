package com.example.Parcial.modelos;

import jakarta.persistence.*;

@Entity
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadistica;

    private Integer goles;
    private Integer asistencias;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    // Getters y setters
    public Integer getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Integer idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
