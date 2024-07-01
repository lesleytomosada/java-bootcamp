package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void receive(Card card){
        cards.add(card);
    }

    public int getSize(){
        return cards.size();
    }

    public int getValue(){
        int total = 0;
        for (Card card: cards){
            total += card.getPointValue();
        }
        return total;
    }
}


