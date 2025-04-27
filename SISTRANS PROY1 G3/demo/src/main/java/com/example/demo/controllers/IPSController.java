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

import com.example.demo.modelo.IPS;
import com.example.demo.services.IPSService;

@RestController
@RequestMapping(path = "/ips")
public class IPSController {
    @Autowired private IPSService ipsService;

    @GetMapping
    public List<IPS> getAll() { return ipsService.listAll(); }

    @GetMapping("/{nit}")
    public IPS getById(@PathVariable String nit) { return ipsService.findById(nit); }

    @PostMapping
    public IPS create(@RequestBody IPS i) { return ipsService.create(i); }

    @PutMapping("/{nit}")
    public IPS update(@PathVariable String nit, @RequestBody IPS i) {
        i.setNit(nit);
        return ipsService.update(i);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> delete(@PathVariable String nit) {
        ipsService.deleteById(nit);
        return ResponseEntity.noContent().build();
    }
}
