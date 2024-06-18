package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayRpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfaz de repositorio JPA para la entidad PlayRpsEntity.
 * Extiende JpaRepository que proporciona operaciones CRUD estándar para la entidad especificada.
 */
@Repository
public interface PlayRpsJpaRepository extends JpaRepository<PlayRpsEntity, Long> {

}
