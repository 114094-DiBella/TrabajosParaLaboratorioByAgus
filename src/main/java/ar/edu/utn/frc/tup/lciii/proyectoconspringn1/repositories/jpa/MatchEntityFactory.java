package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchRpsEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;

/**
 * Clase de fábrica para obtener el tipo de entidad de partido (MatchEntity) basado en el tipo de juego.
 */
public class MatchEntityFactory {
    /**
     * Método estático que devuelve la clase de la entidad de partido correspondiente según el tipo de juego.
     *
     * @param match El objeto Match del cual se determinará el tipo de partido.
     * @return La clase correspondiente de la entidad de partido (MatchEntity).
     */
    public static Class<? extends MatchEntity> getTypeOfMatch(Match match){
        switch (match.getGame().getCode()){
            case "RPS":
                return MatchRpsEntity.class;
            default:
                return MatchRpsEntity.class;// Aquí podrías ajustar según tus necesidades específicas

        }
    }
}
