package com.pluralsight;

import static java.lang.Integer.parseInt;

public class Card {
    private CardSuit suit;
    private String value;
    private boolean isFaceUp;

    public Card(CardSuit suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public int getPointValue(){
        int pointValue;
        if (value.equals("A")){
            pointValue = 11;
        } else if (value.equals("J") || value.equals("Q") || value.equals("K"))
        {
            pointValue = 10;
        } else {
            pointValue = parseInt(value);
        }
        return pointValue;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}
