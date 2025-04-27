package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.Servicio;

public interface ServicioService {
    List<Servicio> findAll();
    Servicio findById(Long id);
    Servicio save(Servicio servicio);
    void deleteById(Long id);
    Servicio findById(String id);
    void deleteById(String id);
    Servicio update(Servicio s);
    List<Servicio> listAll();
    Servicio create(Servicio s);
}