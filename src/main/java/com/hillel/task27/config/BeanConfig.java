package com.hillel.task27.config;

import com.hillel.task27.Card;
import com.hillel.task27.Deck;
import com.hillel.task27.Suit;
import com.hillel.task27.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    public Deck deck(List<Card> cards) {
        return new Deck(cards);
    }

    @Bean
    public List<Card> cards() {
        return Arrays.asList(new Card(Value.TEN, Suit.HEARTS, false),
                new Card(Value.TEN, Suit.DIAMONDS, true),
                new Card(Value.TEN, Suit.CLUBS, false),
                new Card(Value.TEN, Suit.SPADES, false),
                new Card(Value.JACK, Suit.HEARTS, false),
                new Card(Value.JACK, Suit.DIAMONDS, true),
                new Card(Value.JACK, Suit.CLUBS, false),
                new Card(Value.JACK, Suit.SPADES, false),
                new Card(Value.ACE, Suit.HEARTS, false),
                new Card(Value.ACE, Suit.DIAMONDS, true),
                new Card(Value.ACE, Suit.CLUBS, false),
                new Card(Value.ACE, Suit.SPADES, false));
    }
}
