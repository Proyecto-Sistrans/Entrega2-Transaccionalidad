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

import com.example.demo.modelo.Servicio;
import com.example.demo.services.ServicioService;

@RestController
@RequestMapping(path = "/servicios")
public class ServicioController {
    @Autowired private ServicioService servicioService;

    @GetMapping
    public List<Servicio> getAll() { return servicioService.listAll(); }

    @GetMapping("/{id}")
    public Servicio getById(@PathVariable Long id) { return servicioService.findById(id); }

    @PostMapping
    public Servicio create(@RequestBody Servicio s) { return servicioService.create(s); }

    @PutMapping("/{id}")
    public Servicio update(@PathVariable Long id, @RequestBody Servicio s) {
        s.setId(id);
        return servicioService.update(s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}