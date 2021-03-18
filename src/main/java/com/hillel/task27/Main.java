package com.hillel.task27;

import com.hillel.task27.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        Deck deckXml = xmlContext.getBean("deck", Deck.class);

        List<Card> cardListWithXml = deckXml.mix();
        System.out.println(cardListWithXml);

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Deck deckAnnotation = annotationContext.getBean(Deck.class);

        List<Card> cardListWithAnnotation = deckAnnotation.mix();
        System.out.println(cardListWithAnnotation);
    }
}
