package ar.edu.utn.frc.tup.lciii.blackjack.models.card;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Suit suit;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Rank rank;

}
