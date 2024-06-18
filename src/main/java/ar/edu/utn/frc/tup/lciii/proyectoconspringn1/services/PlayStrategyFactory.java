package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.MatchRps;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.PlayRps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factoría que proporciona estrategias de juego basadas en el código del juego.
 * Utiliza inyección de dependencias para obtener las estrategias de juego específicas.
 */
@Component
public class PlayStrategyFactory {
    @Autowired
    private PlayMatch<PlayRps, MatchRps> playMatchRps;

    /**
     * Obtiene la estrategia de juego específica para un juego dado.
     *
     * @param gameCode código del juego para el cual se quiere obtener la estrategia de juego
     * @return la estrategia de juego correspondiente
     */
    public PlayMatch getPlayStrategy(String gameCode) {
        switch (gameCode){
            case "RPS":
                    return playMatchRps;
            default:
                return playMatchRps;
        }
    }
}
