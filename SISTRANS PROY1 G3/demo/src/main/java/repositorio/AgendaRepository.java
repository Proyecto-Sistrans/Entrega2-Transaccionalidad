package repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Agenda;


public interface AgendaRepository extends JpaRepository<Agenda, String> {
    
    @Query(value= "SELECT * FROM agendas", nativeQuery = true)    
    Collection<Agenda> darAgendas();

    @Query(value= "SELECT * FROM agendas WHERE id = ?1", nativeQuery = true)
    Agenda darAgendaPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO agendas (fecha, duracion, estado) VALUES (:fecha, :duracion, :estado)", nativeQuery = true)
    void insertarAgenda(@Param("fecha") String fecha, @Param("duracion") int duracion, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value= "UPDATE agendas SET fecha = :fecha, duracion = :duracion, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarAgenda(@Param("id") String id, @Param("fecha") String fecha, @Param("duracion") int duracion, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value= "DELETE FROM agendas WHERE id = :id", nativeQuery = true)
    void eliminarAgenda(@Param("id") String id);
}
