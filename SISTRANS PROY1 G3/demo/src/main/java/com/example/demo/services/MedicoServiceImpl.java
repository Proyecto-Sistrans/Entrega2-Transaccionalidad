package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Medico;
import com.example.demo.repositorio.MedicoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
class MedicoServiceImpl implements MedicoService {
    @Autowired private MedicoRepository repo;

    @Override public List<Medico> findAll() { return repo.findAll(); }
    @Override public Medico findById(String r) { return repo.findById(r).orElse(null); }
    @Override public Medico save(Medico m) { return repo.save(m); }
    @Override public void deleteById(String r) { repo.deleteById(r); }

    @Override public Medico create(Medico m) { return repo.save(m); }
    @Override public List<Medico> listAll() { return repo.findAll(); }
    @Override public Medico update(Medico m) { 
        if (repo.existsById(m.getId())) {
            return repo.save(m);
        }
        return null;
    }
}