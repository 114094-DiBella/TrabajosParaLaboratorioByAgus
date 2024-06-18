package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.match;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) utilizado para la creación de un partido.
 * Contiene los IDs del juego y del jugador asociados con el partido.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {


    @NotNull
    private Long gameId;
    @NotNull
    private Long playerId;


}
