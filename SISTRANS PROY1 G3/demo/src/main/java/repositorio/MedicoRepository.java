package repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {
    
    @Query(value= "SELECT * FROM medico", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value= "SELECT * FROM medico WHERE id = ?1", nativeQuery = true)
    Medico darMedicoPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO medico (nombre, especialidad, registroMedico, idIps) VALUES (:nombre, :especialidad, :registroMedico, :idIps)", nativeQuery = true)
    void insertarMedico(@Param("nombre") String nombre, @Param("especialidad") String especialidad, @Param("registroMedico") String registroMedico, @Param("idIps") String idIps);

    @Modifying
    @Transactional
    @Query(value= "UPDATE medico SET nombre = :nombre, especialidad = :especialidad, registroMedico = :registroMedico, idIps = :idIps WHERE id = :id", nativeQuery = true)
    void actualizarMedico(@Param("id") String id, @Param("nombre") String nombre, @Param("especialidad") String especialidad, @Param("registroMedico") String registroMedico, @Param("idIps") String idIps);
    
}
