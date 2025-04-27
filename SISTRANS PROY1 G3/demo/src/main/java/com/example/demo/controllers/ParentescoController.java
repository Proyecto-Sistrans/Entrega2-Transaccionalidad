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

import com.example.demo.modelo.Parentesco;

@RestController
@RequestMapping(path = "/parentescos")
public class ParentescoController {
    @Autowired private ParentescoService parentescoService;

    @GetMapping
    public List<Parentesco> getAll() { return parentescoService.listAll(); }

    @GetMapping("/{id}")
    public Parentesco getById(@PathVariable Long id) { return parentescoService.findById(id); }

    @PostMapping
    public Parentesco create(@RequestBody Parentesco p) { return parentescoService.create(p); }

    @PutMapping("/{id}")
    public Parentesco update(@PathVariable Long id, @RequestBody Parentesco p) {
        p.getpk().setId(id);
        return parentescoService.update(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        parentescoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
