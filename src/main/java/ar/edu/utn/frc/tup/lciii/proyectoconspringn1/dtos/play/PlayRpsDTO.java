package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.ShapeHand;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * DTO (Data Transfer Object) para representar una jugada en el juego Piedra-Papel-Tijera (RPS).
 * Implementa la interfaz PlayRequest para la serialización/deserialización polimórfica.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayRpsDTO implements PlayRequest {

    @NotNull
    @JsonProperty("shape_hand_player_1")
    private ShapeHand shapeHandPlayer1;


    @JsonProperty("shape_hand_player_2")
    private ShapeHand shapeHandPlayer2;
}
