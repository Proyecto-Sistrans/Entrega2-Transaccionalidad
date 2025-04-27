package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import com.example.demo.dto.DisponibilidadDTO;
import com.example.demo.modelo.Agenda;
import com.example.demo.repositorio.AgendaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
class AgendaServiceImpl implements AgendaService {
    @Autowired private AgendaRepository repo;

    @Override public List<Agenda> findAll() { return repo.findAll(); }
    public Agenda findById(String id) { 
        return repo.findById(Long.parseLong(id)).orElse(null); 
    }
    @Override @Transactional public Agenda save(Agenda a) { return repo.save(a); }
    @Transactional public void deleteById(String id) { 
        repo.deleteById(Long.parseLong(id)); 
    }

    // RF9
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void agendarTransaccional(String agendaId, String ordenId) {
        Agenda esp = findById(agendaId);
        if (!"disponible".equals(esp.getEstado())) {
            throw new IllegalStateException("Espacio no disponible");
        }
        esp.setEstado(Agenda.EstadoCita.AGENDADA);
        esp.setOrdenCita(ordenId);
        repo.save(esp);
    }

    // RFC5
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public List<DisponibilidadDTO> consultarDisponibilidadSerializable(
        String servicioId, String medicoRegistro,
        LocalDateTime desde, LocalDateTime hasta) {
      try { Thread.sleep(30000L); } catch (InterruptedException e) {}
      return repo.findDisponibilidad(servicioId, medicoRegistro, desde, hasta);
    }

    // RFC6
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<DisponibilidadDTO> consultarDisponibilidadReadCommitted(
        String servicioId, String medicoRegistro,
        LocalDateTime desde, LocalDateTime hasta) {
      try { Thread.sleep(30000L); } catch (InterruptedException e) {}
      return repo.findDisponibilidad(servicioId, medicoRegistro, desde, hasta);
    }
    @Override
    public Agenda findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    @Override
    public List<Agenda> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }
    @Override
    public Agenda create(Agenda a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Agenda update(Agenda a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
