package com.hillel.task27;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        Deck deck = xmlContext.getBean("deck", Deck.class);

        List<Card> cardList = deck.mix();
        System.out.println(cardList);



    }
}
