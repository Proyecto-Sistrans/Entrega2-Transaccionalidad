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

    private Long id;
    private LocalDateTime fecha; // Fecha y hora de la cita
    private int duracion; // Duración de la cita en minutos
    private EstadoCita estado;

        
    public enum EstadoCita {
        CANCELADA, TERMINADA, AUSENCIA, AGENDADA
    }

    public Agenda(LocalDateTime fecha, int duracion, EstadoCita estado) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.estado = estado;
    }

    private String ordenCita;

    public String getOrdenCita() {
        return ordenCita;
    }

    public void setOrdenCita(String ordenId) {
        this.ordenCita = String.valueOf(ordenId);
    }


    public Agenda () 
    {;}

    //Getters
    public Long getId() {
        return id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public int getDuracion() {
        return duracion;
    }
    public String getEstado() {
        return estado.name();
    }

    //Setters
    public void setId(Long id2) {
        this.id = id2;
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

    public void setPacienteCita(String afiliadoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPacienteCita'");
    }

}
