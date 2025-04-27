package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Servicio;
import com.example.demo.repositorio.ServicioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
class ServicioServiceImpl implements ServicioService {
    @Autowired private ServicioRepository repo;
    @Override public List<Servicio> findAll() { return repo.findAll(); }
    @Override public Servicio findById(String id) { 
        try {
            Long longId = Long.parseLong(id);
            return repo.findById(longId).orElse(null);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format. ID must be a number.", e);
        }
    }
    @Override public Servicio save(Servicio s) { return repo.save(s); }
    @Override public void deleteById(String id) { 
        try {
            Long longId = Long.parseLong(id);
            repo.deleteById(longId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format. ID must be a number.", e);
        }
    }
    @Override
    public Servicio findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    @Override
    public Servicio create(Servicio s) {
        return repo.save(s);
    }
    @Override
    public List<Servicio> listAll() {
        return repo.findAll();
    }
    @Override
    public Servicio update(Servicio s) {
        if (repo.existsById(s.getId())) {
            return repo.save(s);
        }
        throw new IllegalArgumentException("Servicio not found");
    }
}
