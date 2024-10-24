package com.pluralsight;

public class Main {
    public static void main(String[] args) throws Exception {

        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Welcome to BlackJack");
        String player1Name = Console.PromptForString("Player 1, enter your name: ");

        System.out.println("Dealing cards... 2 cards to each player!");

        //dealing card from the deck to dealer's hand
        Hand dealerHand = new Hand();
        dealerHand.Deal(deck.deal());
        dealerHand.Deal(deck.deal());

        //dealing card from the deck to player's hand
        Hand player1Hand = new Hand();
        player1Hand.Deal(deck.deal());
        player1Hand.Deal(deck.deal());

        //display dealer's card
        System.out.println("The dealers hand is:");
        dealerHand.displayHand();

        //display player's card
        System.out.println(player1Name + "'s hand is:");
        player1Hand.displayHand();

        if(dealerHand.getValue() == player1Hand.getValue()){
            System.out.println("It's a TIE!");
        }
        else if(dealerHand.getValue() > player1Hand.getValue()){
            System.out.println("Dealer wins!");
        }
        else{
            System.out.println(player1Name + " wins!");
        }

    }
}