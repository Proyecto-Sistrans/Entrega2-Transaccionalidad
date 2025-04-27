package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.modelo.Medico;
import com.example.demo.services.MedicoService;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {
    @Autowired private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAll() { return medicoService.listAll(); }

    @GetMapping("/{id}")
    public Medico getById(@PathVariable String id) { return medicoService.findById(id); }

    @PostMapping
    public Medico create(@RequestBody Medico m) { return medicoService.create(m); }

    @PutMapping("/{id}")
    public Medico update(@PathVariable String id, @RequestBody Medico m) {
        m.setRegistroMedico(id);
        return medicoService.update(m);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}