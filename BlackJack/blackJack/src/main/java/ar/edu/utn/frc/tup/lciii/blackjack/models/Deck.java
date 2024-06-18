package ar.edu.utn.frc.tup.lciii.blackjack.models;

import ar.edu.utn.frc.tup.lciii.blackjack.models.card.Card;
import ar.edu.utn.frc.tup.lciii.blackjack.models.card.Rank;
import ar.edu.utn.frc.tup.lciii.blackjack.models.card.Suit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deck {
    private Queue<Card> cards;
    private Card poll;

    private void initializeDeck() {
        List<Card> cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardList);
        this.cards = new LinkedList<>(cardList);
    }

    public Card poll() {
        return cards.poll();
    }

    public void shuffle() {
        List<Card> cardList = new ArrayList<>(cards);
        Collections.shuffle(cardList);
        this.cards = new LinkedList<>(cardList);
    }
}
