package com.example.demo.controllers;
import java.util.List;
import com.example.demo.modelo.Afiliado;
import com.example.demo.modelo.Medico;
import com.example.demo.modelo.IPS;
import com.example.demo.modelo.Servicio;
import com.example.demo.services.AfiliadoService;
import com.example.demo.modelo.Orden;
import com.example.demo.modelo.Parentesco;
import com.example.demo.modelo.Agenda;
import com.example.demo.dto.DisponibilidadDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/afiliados")
public class AfiliadoController {
    @Autowired private AfiliadoService afiliadoService;

    @GetMapping
    public List<Afiliado> getAll() {
        return afiliadoService.listAll();
    }

    @GetMapping("/{id}")
    public Afiliado getById(@PathVariable String id) {
        return afiliadoService.findById(id);
    }

    @PostMapping
    public Afiliado create(@RequestBody Afiliado a) {
        return afiliadoService.create(a);
    }

    @PutMapping("/{id}")
    public Afiliado update(@PathVariable String id, @RequestBody Afiliado a) {
        a.setIdentificacion(id);
        return afiliadoService.update(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        afiliadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}