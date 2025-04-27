package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.IPS;
import com.example.demo.repositorio.IPSRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
class IPSServiceImpl implements IPSService {
    @Autowired private IPSRepository repo;
    @Override public List<IPS> findAll() { return repo.findAll(); }
    @Override public IPS findById(String nit) { return repo.findById(nit).orElse(null); }
    @Override public IPS save(IPS i) { return repo.save(i); }
    @Override public void deleteById(String nit) { repo.deleteById(nit); }
    @Override
    public List<IPS> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }
    @Override
    public IPS update(IPS i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public IPS create(IPS i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
}
