package ar.edu.utn.frc.tup.lciii.blackjack.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.YamlProcessor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private Long id;
    private Player player1;
    private Player player2;
    private List<Round> rounds;
    private Deck deck;

}
