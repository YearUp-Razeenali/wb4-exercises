package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<Card>();
    }

    public void Deal(Card card){
        cards.add(card);
    }

    public int getSize(){
        return cards.size();
    }

    public int getValue() throws Exception {
        int handValue = 0;
        for(Card card:cards){
            card.flip();
            handValue += card.getPointValue();
            card.flip();
        }
        return handValue;
    }

    public void displayHand() throws Exception {
        for(Card card:this.cards){
            card.displayCard();
        }
        System.out.println("The total is: " + this.getValue());
    }

}
