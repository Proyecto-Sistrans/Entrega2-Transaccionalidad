package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Orden;
import com.example.demo.repositorio.OrdenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
class OrdenServiceImpl implements OrdenService {
    @Autowired private OrdenRepository repo;
    @Override public List<Orden> findAll() { return repo.findAll(); }
    public Orden findById(String id) { return repo.findById(id).orElse(null); }
    @Override public Orden save(Orden o) { return repo.save(o); }
    @Override public void deleteById(String id) { repo.deleteById(id); }
    @Override
    public Orden findById(Long numero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public List<Orden> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }
    @Override
    public Orden create(Orden o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Orden update(Orden o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
