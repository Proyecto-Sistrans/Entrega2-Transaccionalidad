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

import com.example.demo.modelo.Agenda;
import com.example.demo.services.AgendaService;

@RestController
@RequestMapping(path = "/agendas")
public class AgendaController {
    @Autowired private AgendaService agendaService;

    @GetMapping
    public List<Agenda> getAll() { return agendaService.listAll(); }

    @GetMapping("/{id}")
    public Agenda getById(@PathVariable Long id) { return agendaService.findById(id); }

    @PostMapping
    public Agenda create(@RequestBody Agenda a) { return agendaService.create(a); }

    @PutMapping("/{id}")
    public Agenda update(@PathVariable Long id, @RequestBody Agenda a) {
        a.setId(id);
        return agendaService.update(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
