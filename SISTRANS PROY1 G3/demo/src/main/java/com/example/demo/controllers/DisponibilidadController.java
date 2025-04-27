package com.example.demo.controllers;
import java.util.List;
import com.example.demo.services.DisponibilidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DisponibilidadDTO;
@RestController
@RequestMapping(path = "/disponibilidad")
public class DisponibilidadController {
    @Autowired private DisponibilidadService dispService;

    @GetMapping
    public List<DisponibilidadDTO> consultarDisponibilidad(
            @RequestParam(required = false) Long servicioId,
            @RequestParam(required = false) String medicoId,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin) {
        return dispService.buscarDisponibilidad(servicioId, medicoId, fechaInicio, fechaFin);
    }

    @GetMapping("/serializable")
    public List<DisponibilidadDTO> consultarSerializable(
            @RequestParam(required = false) Long servicioId,
            @RequestParam(required = false) String medicoId,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin) throws InterruptedException {
        return dispService.buscarSerializable(servicioId, medicoId, fechaInicio, fechaFin);
    }

    @GetMapping("/readcommitted")
    public List<DisponibilidadDTO> consultarReadCommitted(
            @RequestParam(required = false) Long servicioId,
            @RequestParam(required = false) String medicoId,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin) throws InterruptedException {
        return dispService.buscarReadCommitted(servicioId, medicoId, fechaInicio, fechaFin);
    }
}
