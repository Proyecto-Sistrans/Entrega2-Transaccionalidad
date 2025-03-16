package com.example.demo.modelo;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="agendas")
public class Agenda {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String id;
    private LocalDateTime fecha; // Fecha y hora de la cita
    private int duracion; // Duración de la cita en minutos
    private EstadoCita estado;

        
    enum EstadoCita {
        CANCELADA, TERMINADA, AUSENCIA, AGENDADA
    }

    public Agenda(LocalDateTime fecha, int duracion, EstadoCita estado) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.estado = estado;
    }


    public Agenda () 
    {;}

    //Getters
    public String getId() {
        return id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public int getDuracion() {
        return duracion;
    }
    public EstadoCita getEstado() {
        return estado;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

}
