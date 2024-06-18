package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Clase que representa un partido específico del juego piedra-papel-tijera (RPS).
 * Extiende la clase Match para heredar funcionalidades generales de partidos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRps extends Match {

    private Integer numberOfPlays;
    private Integer remainderPlays;
    private Integer player1Score;
    private Integer player2Score;
    private List<PlayRps> plays;
    private Long winnerId;

}
