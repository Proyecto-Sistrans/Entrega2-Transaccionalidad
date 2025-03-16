package repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.modelo.IPS;


public interface IPSRepository extends JpaRepository<IPS, String> {
    
    @Query(value= "SELECT * FROM ips", nativeQuery = true)
    Collection<IPS> darIPSs();

    @Query(value= "SELECT * FROM ips WHERE id = ?1", nativeQuery = true)
    IPS darIPSPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO ips (nombre, localizacion, tipo) VALUES (:nombre, :localizacion, :tipo)", nativeQuery = true)
    void insertarIPS(@Param("nombre") String nombre, @Param("localizacion") String localizacion, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value= "UPDATE ips SET nombre = :nombre, localizacion = :localizacion, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarIPS(@Param("id") String id, @Param("nombre") String nombre, @Param("localizacion") String localizacion, @Param("tipo") String tipo);
    
}
