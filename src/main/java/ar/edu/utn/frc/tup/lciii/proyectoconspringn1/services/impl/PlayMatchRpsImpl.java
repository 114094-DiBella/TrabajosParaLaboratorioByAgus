package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.impl;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchRpsEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayRpsEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.MatchRps;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.PlayRps;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.ShapeHand;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.PlayMatch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.PlayRpsJpaRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;


/**
 * Implementación del servicio PlayMatch específico para el juego RPS (Rock, Paper, Scissors).
 * Maneja la lógica de juego, evaluación de jugadas, cálculo de puntajes y estado del partido.
 */
@Service
public class PlayMatchRpsImpl implements PlayMatch<PlayRps, MatchRps> {
    @Autowired
    private PlayRpsJpaRepository playRpsJpaRepository;
    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private ModelMapper modelMapper;
    private Random random = new Random();


    /**
     * Método principal que ejecuta una jugada dentro de un partido de RPS.
     *
     * @param playRps la jugada realizada
     * @param matchRps el partido en curso
     * @return el objeto PlayRps actualizado con los resultados de la jugada
     */
    @Override
    public PlayRps play(PlayRps playRps, MatchRps matchRps) {

        playRps.setMatchRpsId(matchRps.getId()); // Asigna el ID del partido a la jugada

        // Si el jugador 2 no ha realizado su jugada, se selecciona una al azar
        if(Objects.isNull(playRps.getShapeHandPlayer2())){
            playRps.setShapeHandPlayer2(getRandomShapedHand());
        }
        evaluatePlay(playRps,matchRps);
        calculateMatchScore(playRps,matchRps);
        calculateMatchStatus(matchRps);
        matchRps.setUpdatedAt(LocalDateTime.now());

        // Guarda la jugada en la base de datos
        PlayRpsEntity playRpsEntity = modelMapper.map(playRps, PlayRpsEntity.class);
        playRpsJpaRepository.save(playRpsEntity);

        // Guarda el estado actualizado del partido en la base de datos
        MatchEntity matchEntity = modelMapper.map(matchRps, MatchRpsEntity.class);
        matchJpaRepository.save(matchEntity);

        return playRps;
    }


    /**
     * Calcula el estado del partido basado en el número de jugadas restantes.
     * Marca el partido como finalizado si no quedan jugadas por realizar.
     *
     * @param matchRps el partido de RPS
     */
    private void calculateMatchStatus(MatchRps matchRps) {
        matchRps.setRemainderPlays(matchRps.getRemainderPlays()-1);
        if(matchRps.getRemainderPlays()== 0){
            matchRps.setStatus(MatchStatus.FINISHED);
        }
        if(!isMatchTie(matchRps)){
            if(matchRps.getPlayer1Score() > matchRps.getPlayer2Score()){
                matchRps.setWinnerId(matchRps.getPlayer1().getId());
            }else {
                matchRps.setWinnerId(matchRps.getPlayer2().getId());
            }
        }
    }

    /**
     * Verifica si el partido está empatado.
     *
     * @param matchRps el partido de RPS
     * @return true si el partido está empatado, false de lo contrario
     */
    private boolean isMatchTie(MatchRps matchRps) {
        return matchRps.getPlayer1Score().equals(matchRps.getPlayer2Score());
    }

    /**
     * Calcula el puntaje del partido basado en el resultado de la jugada.
     * Incrementa el puntaje del jugador correspondiente si hay un ganador.
     *
     * @param playRps la jugada realizada
     * @param matchRps el partido de RPS
     */
    private void calculateMatchScore(PlayRps playRps, MatchRps matchRps) {
        if(Objects.nonNull(playRps.getWinnerId()))
        {
            if(playRps.getWinnerId().equals(matchRps.getPlayer1().getId())){
                matchRps.setPlayer1Score(matchRps.getPlayer1Score()+1);
            }else{
                matchRps.setPlayer2Score(matchRps.getPlayer2Score()+1);
            }
        }
        
    }

    /**
     * Evalúa la jugada realizada para determinar al ganador.
     * Establece el ID del ganador en la jugada si hay uno.
     *
     * @param playRps la jugada realizada
     * @param matchRps el partido de RPS
     */
    private void evaluatePlay(PlayRps playRps, MatchRps matchRps) {
       if(!isPlayTie(playRps)) {
           setWinner(playRps,matchRps);
       } 
        
    }


    /**
     * Determina al ganador de la jugada basado en las manos seleccionadas por los jugadores.
     * Establece el ID del ganador en la jugada.
     *
     * @param playRps la jugada realizada
     * @param matchRps el partido de RPS
     */
    private void setWinner(PlayRps playRps, MatchRps matchRps) {
        if(playRps.getShapeHandPlayer1().equals(ShapeHand.PAPER)){
            if(playRps.getShapeHandPlayer2().equals(ShapeHand.ROCK)){
                playRps.setWinnerId(matchRps.getPlayer1().getId());
            }
            else {
                playRps.setWinnerId(matchRps.getPlayer2().getId());
            }
        } else if (playRps.getShapeHandPlayer1().equals(ShapeHand.ROCK)) {
            if(playRps.getShapeHandPlayer2().equals(ShapeHand.SCISSOR)){
                playRps.setWinnerId(matchRps.getPlayer1().getId());
            }else {
                playRps.setWinnerId(matchRps.getPlayer2().getId());
            }
        }else{
            if(playRps.getShapeHandPlayer2().equals(ShapeHand.PAPER))
            {
                playRps.setWinnerId(matchRps.getPlayer1().getId());
            }else{
                playRps.setWinnerId(matchRps.getPlayer2().getId());
            }
        }

    }

    /**
     * Determina si la jugada actual está empatada.
     *
     * @param playRps la jugada realizada
     * @return true si la jugada está empatada, false de lo contrario
     */

    private boolean isPlayTie(PlayRps playRps) {
       return playRps.getShapeHandPlayer1().equals(playRps.getShapeHandPlayer2());
    }

    /**
     * Genera una mano aleatoria para el jugador 2.
     *
     * @return una de las manos disponibles en el juego RPS
     */
    private ShapeHand getRandomShapedHand() {
        Integer randomIndex = random.nextInt(3);
        return ShapeHand.values()[randomIndex];
    }
}
