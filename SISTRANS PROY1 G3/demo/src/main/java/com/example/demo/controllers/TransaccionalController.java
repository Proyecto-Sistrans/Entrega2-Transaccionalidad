package com.example.demo.controllers;
import com.example.demo.services.TransaccionalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/transaccional")
public class TransaccionalController {
    @Autowired private TransaccionalService txService;

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarServicio(@RequestParam Long agendaId,
                                                  @RequestParam Long ordenId) {
        boolean ok = txService.agendar(agendaId, ordenId);
        if (ok) return ResponseEntity.ok("Agendamiento exitoso");
        else return ResponseEntity.badRequest().body("No hay disponibilidad");
    }
}
