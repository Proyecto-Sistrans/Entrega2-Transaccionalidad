package com.example.demo.dto;

import java.time.LocalDateTime;

/**
 * DTO para transferir la información de disponibilidad de un servicio.
 */
public class DisponibilidadDTO {

    private String nombreServicio;
    private LocalDateTime fechaHora;
    private String nombreIPS;
    private String nombreMedico;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(String nombreServicio,
                             LocalDateTime fechaHora,
                             String nombreIPS,
                             String nombreMedico) {
        this.nombreServicio = nombreServicio;
        this.fechaHora = fechaHora;
        this.nombreIPS = nombreIPS;
        this.nombreMedico = nombreMedico;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreIPS() {
        return nombreIPS;
    }

    public void setNombreIPS(String nombreIPS) {
        this.nombreIPS = nombreIPS;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    @Override
    public String toString() {
        return "DisponibilidadDTO{" +
               "nombreServicio='" + nombreServicio + '\'' +
               ", fechaHora=" + fechaHora +
               ", nombreIPS='" + nombreIPS + '\'' +
               ", nombreMedico='" + nombreMedico + '\'' +
               '}';
    }
}
