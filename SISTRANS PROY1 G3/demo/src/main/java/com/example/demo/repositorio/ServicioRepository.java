package com.example.demo.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    
    @Query(value= "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value= "SELECT * FROM servicios WHERE id = ?1", nativeQuery = true)
    Servicio darServicioPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO servicios (nombre, descripcion, tipo, idIps) VALUES (:nombre, :descripcion, :tipo, :idIps)", nativeQuery = true)
    void insertarServicio(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("tipo") String tipo, @Param("idIps") String idIps);

    @Modifying
    @Transactional
    @Query(value= "UPDATE servicios SET nombre = :nombre, descripcion = :descripcion, tipo = :tipo, idIps = :idIps WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") String id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("tipo") String tipo, @Param("idIps") String idIps);
    
}
