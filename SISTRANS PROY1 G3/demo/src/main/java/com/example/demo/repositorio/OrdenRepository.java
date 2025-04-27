package com.example.demo.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Orden;

public interface OrdenRepository extends JpaRepository<Orden, String> {
    
    @Query(value= "SELECT * FROM orden", nativeQuery = true)
    Collection<Orden> darOrdens();

    @Query(value= "SELECT * FROM orden WHERE id = ?1", nativeQuery = true)
    Orden darOrdenPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO orden (id, fecha, idServicio, idAfiliado, idMedico, idOrden, idRecepcionista) VALUES (:id, :fecha, :idServicio, :idAfiliado, :idMedico, :idOrden, :idRecepcionista)", nativeQuery = true)
    void insertarOrden(@Param("id") String id, @Param("fecha") String fecha, @Param("idServicio") String idServicio, @Param("idAfiliado") String idAfiliado, @Param("idMedico") String idMedico, @Param("idOrden") String idOrden, @Param("idRecepcionista") String idRecepcionista);

    @Modifying
    @Transactional
    @Query(value= "UPDATE orden SET id = :id, fecha = :fecha, idServicio = :idServicio, idAfiliado = :idAfiliado, idMedico = :idMedico, idOrden = :idOrden, idRecepcionista = :idRecepcionista WHERE id = :id", nativeQuery = true)
    void actualizarOrden(@Param("id") String id, @Param("fecha") String fecha, @Param("idServicio") String idServicio, @Param("idAfiliado") String idAfiliado, @Param("idMedico") String idMedico, @Param("idOrden") String idOrden, @Param("idRecepcionista") String idRecepcionista);
    
}
