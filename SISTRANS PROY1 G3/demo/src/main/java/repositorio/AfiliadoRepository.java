package repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Afiliado;

public interface AfiliadoRepository extends JpaRepository<Afiliado, String> {
    
    @Query(value= "SELECT * FROM afiliados", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value= "SELECT * FROM afiliados WHERE id = ?1", nativeQuery = true)
    Afiliado darAfiliadoPorId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO afiliados (nombre, tipoDocumento, fechaNacimiento, direccion, telefono) VALUES (:nombre, :tipoDocumento, :fechaNacimiento, :direccion, :telefono)", nativeQuery = true)
    void insertarAfiliado(@Param("nombre") String nombre, @Param("tipoDocumento") String tipoDocumento, @Param("fechaNacimiento") String fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value= "UPDATE afiliados SET nombre = :nombre, tipoDocumento = :tipoDocumento, fechaNacimiento = :fechaNacimiento, direccion = :direccion, telefono = :telefono WHERE id = :id", nativeQuery = true)
    void actualizarAfiliado(@Param("id") String id, @Param("nombre") String nombre, @Param("tipoDocumento") String tipoDocumento, @Param("fechaNacimiento") String fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") String telefono);


    @Modifying
    @Transactional
    @Query(value= "DELETE FROM afiliados WHERE id = :id", nativeQuery = true)
    void eliminarAfiliado(@Param("id") String id);
}
