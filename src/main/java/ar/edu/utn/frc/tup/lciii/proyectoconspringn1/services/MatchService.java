package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Play;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    /**
     * Obtiene todas las partidas de un jugador especificado por su ID.
     *
     * @param playerId el ID del jugador
     * @return una lista de partidas del jugador
     */
    List<Match> getMatchesByPlayer(Long playerId);

    /**
     * Crea una nueva partida basada en la información proporcionada en el DTO de partida.
     *
     * @param matchDTO DTO con la información para crear la partida
     * @return la partida creada
     */
    Match createMatch(MatchDTO matchDTO);

    /**
     * Obtiene una partida por su ID.
     *
     * @param id el ID de la partida
     * @return la partida encontrada
     */
    Match getMatchById(Long id);

    /**
     * Procesa una jugada en la partida especificada por su ID.
     *
     * @param id el ID de la partida en la cual se realiza la jugada
     * @param playRequest solicitud de jugada que contiene la información de la jugada a procesar
     * @return el resultado de la jugada
     */
    Play play(Long id, PlayRequest playRequest);
}
