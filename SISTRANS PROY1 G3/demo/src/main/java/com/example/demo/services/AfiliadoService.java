package com.example.demo.services;

import java.util.List;
import com.example.demo.modelo.*;

public interface AfiliadoService {
    List<Afiliado> findAll();
    Afiliado findById(String id);
    Afiliado save(Afiliado afiliado);
    void deleteById(String id);

    List<Afiliado> listAll();
    
}

