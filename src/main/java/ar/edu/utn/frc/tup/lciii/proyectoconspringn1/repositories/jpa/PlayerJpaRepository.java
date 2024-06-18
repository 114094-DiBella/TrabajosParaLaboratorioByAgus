package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/**
 * Interfaz de repositorio JPA para la entidad PlayerEntity.
 * Extiende JpaRepository que proporciona operaciones CRUD estándar para la entidad especificada.
 *
 * También define un método adicional para buscar un jugador por nombre de usuario o correo electrónico.
 */
@Repository  // Indica que esta interfaz es un componente de repositorio manejado por Spring
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity , Long>{
    /**
     * Busca un jugador por nombre de usuario o correo electrónico.
     *
     * @param userName nombre de usuario del jugador
     * @param email correo electrónico del jugador
     * @return un Optional que puede contener el jugador encontrado, o vacío si no se encuentra
     */

    Optional<PlayerEntity> findByUserNameOrEmail(String userName, String email);

    /**
     * Busca un jugador por nombre de usuario y contraseña.
     *
     * @param userName nombre de usuario del jugador
     * @param password contraseña del jugador
     * @return un Optional que puede contener el jugador encontrado, o vacío si no se encuentra
     */
    Optional<PlayerEntity> findByUserNameAndPassword(String userName, String password);

    /**
     * Busca un jugador por correo electrónico y contraseña.
     *
     * @param email    correo electrónico del jugador
     * @param password contraseña del jugador
     * @return un Optional que puede contener el jugador encontrado, o vacío si no se encuentra
     */
    Optional<PlayerEntity> findByEmailAndPassword(String email, String password);

    /**
     * Busca un jugador por nombre de usuario o correo electrónico y contraseña.
     *
     * @param identity nombre de usuario o correo electrónico del jugador
     * @param password contraseña del jugador
     * @return un Optional que puede contener el jugador encontrado, o vacío si no se encuentra
     */
    @Query("SELECT p FROM PlayerEntity p " +
            "WHERE (p.userName LIKE :identity OR p.email LIKE :identity) AND p.password LIKE :password")
    Optional<PlayerEntity> findByUserNameOrEmailAndPassword(@Param("identity") String identity, @Param("password") String password);
}