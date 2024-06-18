package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Game;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.MatchRps;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.PlayRps;

import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Clase utilitaria para la creación de instancias de partidas (matches) basadas en el juego específico.
 * Actualmente solo se implementa el juego Rock-Paper-Scissors (RPS).
 */
public class MatchFactory {

    /**
     * Crea una nueva instancia de partida (match) basada en el juego especificado.
     *
     * @param player el jugador asociado a la partida
     * @param game el juego para el cual se crea la partida
     * @return una instancia de partida (match) basada en el juego
     */

    public static Match createMatch(Player player, Game game){
        switch (game.getCode()){
            case "RPS":
                return createMatchRps(player, game);
            default:
                return createMatchRps(player, game);
        }
    }
    /**
     * Obtiene el tipo de clase de la partida (match) basado en el código de juego.
     *
     * @param gameCode el código del juego
     * @return la clase correspondiente a la partida (match)
     */
    public static Class<? extends Match> getTypeOfMatch(String gameCode){
        switch (gameCode){
            case "RPS":
                return MatchRps.class;
            default:
                return MatchRps.class;
        }
    }
    // Métodos privados para la creación de partidas específicas
    private static Match createMatchRps(Player player, Game game){
        MatchRps match = (MatchRps) getBasicMatch(player,game);
        match.setNumberOfPlays(10);
        match.setRemainderPlays(10);
        match.setPlayer1Score(0);
        match.setPlayer2Score(0);
        match.setPlays(new ArrayList<PlayRps>());
        return match;
    }

    private static Object getBasicMatch(Player player, Game game) {
        Match match = getMatchInstance(game.getCode());
        match.setPlayer1(player);
        match.setGame(game);
        match.setCreatedAt(LocalDateTime.now());
        match.setUpdatedAt(LocalDateTime.now());
        match.setStatus(MatchStatus.STARTED);
        return match;
    }

    private static Match getMatchInstance(String code) {
        switch (code){
            case "RPS":
                return new MatchRps();
            default:
                return new MatchRps();
        }
    }
}
