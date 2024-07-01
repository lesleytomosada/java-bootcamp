package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(CardSuit.CLUBS, "7");
        System.out.println(card.getSuit());
    }
}