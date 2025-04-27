package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.*;
import com.example.demo.repositorio.AfiliadoRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
class AfiliadoServiceImpl implements AfiliadoService {
    @Autowired private AfiliadoRepository repo;
    @Override public List<Afiliado> findAll() { return repo.findAll(); }
    @Override public Afiliado findById(String id) { return repo.findById(id).orElse(null); }
    @Override public Afiliado save(Afiliado a) { return repo.save(a); }
    @Override public void deleteById(String id) { repo.deleteById(id); }
}