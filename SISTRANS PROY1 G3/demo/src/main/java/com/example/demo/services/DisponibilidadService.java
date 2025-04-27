package com.example.demo.services;

import com.example.demo.dto.DisponibilidadDTO;
import com.example.demo.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DisponibilidadService {

    @PersistenceContext
    private EntityManager em;

    /**
     * RFC1 – Consulta de disponibilidad de un servicio en las próximas 4 semanas.
     * @param servicioId  id del servicio
     * @return lista de horarios disponibles con IPS y médico
     */
    public List<DisponibilidadDTO> listarDisponibilidadProximas4Semanas(Long servicioId) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime dentroDe4Semanas = ahora.plusWeeks(4);

        String sql =
            "SELECT s.nombre   AS servicio,  " +
            "       a.fecha    AS fechaHora, " +
            "       i.nombre   AS ips,       " +
            "       m.nombre   AS medico     " +
            "  FROM Agendas a                  " +
            "  JOIN Servicios s ON a.servicio_cita = s.id         " +
            "  JOIN Contratados_En ce ON ce.registro_medico = a.medico_cita " +
            "  JOIN IPS i ON ce.nit = i.nit                     " +
            "  JOIN Medicos m ON a.medico_cita = m.registro_medico          " +
            " WHERE a.servicio_cita = :servicioId               " +
            "   AND a.estado = 'disponible'                     " +
            "   AND a.fecha BETWEEN :inicio AND :fin            " +
            " ORDER BY a.fecha";

        Query q = em.createNativeQuery(sql, "DisponibilidadResult");
        q.setParameter("servicioId", servicioId);
        q.setParameter("inicio", ahora);
        q.setParameter("fin", dentroDe4Semanas);

        return q.getResultList();
    }

    /**
     * RFC5 – Consulta SERIALIZABLE de disponibilidad (30s de espera).
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<DisponibilidadDTO> consultarDisponibilidadSerializable(
            Long servicioId,
            String medicoId,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    ) {
        try {
            // fuerza 30 segundos de duración para probar concurrencia
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BusinessException("Error en temporizador de consulta", e);
        }

        String sql =
            "SELECT s.nombre   AS servicio,  " +
            "       a.fecha    AS fechaHora, " +
            "       m.nombre   AS medico     " +
            "  FROM Agendas a                  " +
            "  JOIN Servicios s ON a.servicio_cita = s.id         " +
            "  JOIN Medicos m ON a.medico_cita = m.registro_medico " +
            " WHERE a.servicio_cita = :servicioId               " +
            "   AND a.estado = 'disponible'                     " +
            "   AND a.fecha BETWEEN :inicio AND :fin            " +
            "   AND (:medicoId IS NULL OR a.medico_cita = :medicoId) " +
            " ORDER BY a.fecha";

        Query q = em.createNativeQuery(sql, "DisponibilidadResult");
        q.setParameter("servicioId", servicioId);
        q.setParameter("inicio", fechaInicio);
        q.setParameter("fin", fechaFin);
        q.setParameter("medicoId", medicoId);

        return q.getResultList();
    }

    /**
     * RFC6 – Consulta READ COMMITTED de disponibilidad (30s de espera).
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<DisponibilidadDTO> consultarDisponibilidadReadCommitted(
            Long servicioId,
            String medicoId,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    ) {
        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BusinessException("Error en temporizador de consulta", e);
        }

        // reutiliza la misma consulta SQL que en SERIALIZABLE
        return consultarDisponibilidadSerializable(servicioId, medicoId, fechaInicio, fechaFin);
    }

    public List<DisponibilidadDTO> buscarReadCommitted(Long servicioId, String medicoId, String fechaInicio,
            String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarReadCommitted'");
    }

    public List<DisponibilidadDTO> buscarSerializable(Long servicioId, String medicoId, String fechaInicio,
            String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarSerializable'");
    }

    public List<DisponibilidadDTO> buscarDisponibilidad(Long servicioId, String medicoId, String fechaInicio,
            String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarDisponibilidad'");
    }
}
