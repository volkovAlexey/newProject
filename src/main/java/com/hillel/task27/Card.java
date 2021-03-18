package com.hillel.task27;

import java.util.Objects;

public class Card {
    private Value value;
    private Suit suit;
    private boolean isTrump;

    public Card(Value value, Suit suit, Boolean isTrump) {
        this.value = value;
        this.suit = suit;
        this.isTrump = isTrump;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Boolean getTrump() {
        return isTrump;
    }

    public void setTrump(Boolean trump) {
        isTrump = trump;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return isTrump == card.isTrump && value == card.value && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit, isTrump);
    }

    @Override
    public String toString() {
        return value + "-" + suit + "-" + isTrump;
    }
}
