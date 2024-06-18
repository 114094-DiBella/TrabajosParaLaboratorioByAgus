package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity, Long> {

    /**
     * Obtiene todos los partidos asociados a un jugador por su ID.
     *
     * @param playerId1 ID del jugador
     * @return Una lista opcional de MatchEntity asociados al jugador
     */

   // @Query("SELECT m FROM MatchEntity m WHERE m.player.id = :playerId")
    Optional<List<MatchEntity>> findAllByPlayer1IdOrPlayer2Id(Long playerId1,Long playerId2);
    /**
     * Obtiene un partido por su ID.
     *
     * @param id ID del partido
     * @return El partido encontrado, o null si no existe
     */

    MatchEntity getMatchById(Long id);
}
