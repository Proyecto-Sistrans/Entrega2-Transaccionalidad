package com.example.demo.services;

import java.util.List;
import com.example.demo.modelo.Medico;

public interface MedicoService {
    List<Medico> findAll();
    Medico findById(String registro);
    Medico save(Medico medico);
    void deleteById(String registro);
    Medico update(Medico m);
    Medico create(Medico m);
    List<Medico> listAll();
}