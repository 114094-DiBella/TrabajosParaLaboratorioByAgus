package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchRpsEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Play;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Clase que representa una jugada en un partido de piedra-papel-tijera (RPS).
 * Implementa la interfaz Play, lo que la hace parte de la estructura de jugadas en un partido RPS.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayRps implements Play {

    private Long id;

    private Long matchRpsId;

    private ShapeHand shapeHandPlayer1;

    private ShapeHand shapeHandPlayer2;

    private Long winnerId;


}
