package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Play;
import org.springframework.stereotype.Service;
/**
 * Interfaz que define el contrato para realizar una jugada en un partido específico.
 *
 * @param <P> Tipo de la jugada (clase que extiende Play)
 * @param <M> Tipo del partido (clase que extiende Match)
 */
@Service
public interface PlayMatch <P extends Play, M extends Match> {
    /**
     * Realiza una jugada en un partido específico.
     *
     * @param play la jugada a realizar
     * @param match el partido en el que se realiza la jugada
     * @return la jugada realizada
     */
    P play (P play, M match);
}
