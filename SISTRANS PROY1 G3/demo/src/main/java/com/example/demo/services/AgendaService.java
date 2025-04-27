package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.dto.DisponibilidadDTO;
import com.example.demo.modelo.Agenda;

public interface AgendaService {
    List<Agenda> findAll();
    Agenda findById(Long id);
    Agenda save(Agenda agenda);
    void deleteById(Long id);

    // RF9 - transaccional
    void agendarTransaccional(String agendaId, String ordenId);

    // RFC5 - nivel SERIALIZABLE
    List<DisponibilidadDTO> consultarDisponibilidadSerializable(
        String servicioId, String medicoRegistro,
        LocalDateTime desde, LocalDateTime hasta);

    // RFC6 - nivel READ_COMMITTED
    List<DisponibilidadDTO> consultarDisponibilidadReadCommitted(
        String servicioId, String medicoRegistro,
        LocalDateTime desde, LocalDateTime hasta);
    List<com.example.demo.modelo.Agenda> listAll();
    Agenda create(Agenda a);
    Agenda update(Agenda a);
}
