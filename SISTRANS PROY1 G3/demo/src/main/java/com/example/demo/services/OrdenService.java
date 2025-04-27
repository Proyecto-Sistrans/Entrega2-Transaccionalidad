package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.Orden;

public interface OrdenService {
    List<Orden> findAll();
    Orden findById(Long numero);
    Orden save(Orden orden);
    void deleteById(String id);
    List<Orden> listAll();
    Orden create(Orden o);
    Orden update(Orden o);
}
