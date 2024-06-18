package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    /**
     * Obtiene un juego por su ID.
     *
     * @param game el ID del juego a buscar
     * @return el juego encontrado como objeto Game
     */
    Game getGame(Long game);
}
