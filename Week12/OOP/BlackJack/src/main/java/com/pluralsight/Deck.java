package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (CardSuit suit : CardSuit.values()){
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }

    public Card deal(){
        if (!cards.isEmpty()){
            return cards.remove(0);
        } else {
            return null;
        }
    }
}
