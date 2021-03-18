package com.hillel.task27;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deckOfCards;

    public Deck(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public List<Card> mix() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
