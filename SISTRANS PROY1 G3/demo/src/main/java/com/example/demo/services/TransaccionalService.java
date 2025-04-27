package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.exceptions.BusinessException;

import com.example.demo.modelo.Agenda;
import com.example.demo.modelo.Orden;
import com.example.demo.repositorio.*;

@Service
public class TransaccionalService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    /**
     * RF9: Agendar un servicio de salud de manera transaccional.
     *
     * @param agendaId  el id del espacio en la agenda elegido por el usuario
     * @param ordenId   el número de la orden de servicio (puede ser null para servicios sin orden)
     * @param afiliadoId el identificador del afiliado que agenda la cita
     * @return la agenda actualizada con estado "agendada"
     * @throws BusinessException si el espacio ya no está disponible o la orden no existe
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Agenda agendarServicio(Long agendaId, Long ordenId, String afiliadoId) {
        // 1. Confirmar que la orden existe (si aplica)
        if (ordenId != null) {
            Optional<Orden> optOrden = ordenRepository.findById(ordenId.toString());
            if (!optOrden.isPresent()) {
                throw new BusinessException("La orden " + ordenId + " no existe");
            }
        }

        // 2. Obtener la agenda y confirmar disponibilidad
        Optional<Agenda> optAgenda = agendaRepository.findById(agendaId);
        if (!optAgenda.isPresent()) {
            throw new BusinessException("El espacio de agenda " + agendaId + " no existe");
        }

        Agenda agenda = optAgenda.get();
        if (!"disponible".equalsIgnoreCase(agenda.getEstado())) {
            throw new BusinessException("El espacio de agenda ya no está disponible");
        }

        // 3. Registrar el agendamiento
        agenda.setEstado(Agenda.EstadoCita.AGENDADA);
        agenda.setPacienteCita(afiliadoId);
        agenda.setOrdenCita(ordenId != null ? ordenId.toString() : null);

        // 4. Guardar cambios (commit al final de la transacción)
        return agendaRepository.save(agenda);
    }

    public boolean agendar(Long agendaId, Long ordenId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agendar'");
    }
}
