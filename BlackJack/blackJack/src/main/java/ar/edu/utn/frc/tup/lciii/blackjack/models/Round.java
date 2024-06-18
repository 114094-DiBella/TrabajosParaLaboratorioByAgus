package ar.edu.utn.frc.tup.lciii.blackjack.models;

import ar.edu.utn.frc.tup.lciii.blackjack.models.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private int roundNumber;
    private List<Card> handPlayer;
    private List<Card> handDealer;
    private int playerScore;
    private int dealerScore;
}
