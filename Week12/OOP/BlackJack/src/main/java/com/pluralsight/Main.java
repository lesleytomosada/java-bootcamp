package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("What is your name? ");
        String player = scanner.nextLine();

        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();

        for (int i = 0; i<2; i++){
            Card dealerCard = deck.deal();
            dealerHand.receive(dealerCard);
            Card playerCard = deck.deal();
            playerHand.receive(playerCard);
        }
        int dealerValue = dealerHand.getValue();
        int playerValue = playerHand.getValue();
        String winner = (dealerValue > playerValue && dealerValue <= 21)  ? "Dealer" : player;

        System.out.printf("""
                Dealer: %d
                %s: %d
                
                %s wins!
                """, dealerValue, player, playerValue, winner);
    }
}