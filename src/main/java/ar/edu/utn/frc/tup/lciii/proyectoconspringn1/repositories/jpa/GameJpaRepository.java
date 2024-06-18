package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repositorio de Spring Data JPA para la entidad GameEntity.
 * Proporciona métodos predefinidos para realizar operaciones CRUD y otras consultas sobre la tabla de juegos en la base de datos.
 */
@Repository
public interface GameJpaRepository extends JpaRepository<GameEntity, Long> {
    // No es necesario definir métodos CRUD aquí, JpaRepository proporciona métodos como save(), findById(), findAll(), etc.
    // También permite definir consultas personalizadas usando convenciones de nombres o consultas JPQL.

    // No se necesita implementación explícita, Spring Data JPA generará automáticamente la implementación en tiempo de ejecución.

}
