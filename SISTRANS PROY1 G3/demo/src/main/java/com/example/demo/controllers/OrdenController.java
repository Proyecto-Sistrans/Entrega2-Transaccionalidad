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

import com.example.demo.modelo.Orden;
import com.example.demo.services.OrdenService;

@RestController
@RequestMapping(path = "/ordenes")
public class OrdenController {
    @Autowired private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAll() { return ordenService.listAll(); }

    @GetMapping("/{numero}")
    public Orden getById(@PathVariable Long numero) { return ordenService.findById(numero); }

    @PostMapping
    public Orden create(@RequestBody Orden o) { return ordenService.create(o); }

    @PutMapping("/{numero}")
    public Orden update(@PathVariable Long numero, @RequestBody Orden o) {
        o.setNumero(numero.toString());
        return ordenService.update(o);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> delete(@PathVariable String numero) {
        ordenService.deleteById(numero);
        return ResponseEntity.noContent().build();
    }
}
