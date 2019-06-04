package com.aceappsdev.apps.saataathtrial.structure;

import java.util.*;

public class Deck {
    //properties
    private ArrayList<Card> pCards;

    // public constants
    public static final int FULL_DECK_WITHOUT_JOKERS = 0;
    public static final int FULL_DECK_WITH_JOKERS = 1;
    public static final int FULL_DECK_WITH_2_JOKERS = 1;
    public static final int SAAT_AATH = 2;

    public static final int RANDOM_SHUFFLE = 0;
    public static final int RIFFLE_SHUFFLE = 1;
    public static final int DISTRIBUTED_SHUFFLE = 2;

    //private constants



    private void constructr(){
        this.pCards = new ArrayList<Card>();

        //this.pCards[i] = new Card(0,0);  //Add Joker

        //int i = 0;						//Counter to add to a particular location

        for (int suit=1; suit<=4; suit++){
            for(int value=1; value<=13; value++){
                this.pCards.add(new Card(suit, value));
                //i++; 						//increase the counter
            }
        }
    }

    /*

     */
    private void constructr(int[] suits, int[] values){
        if (suits == null || values == null) {
            constructr();
            return;
        }

        this.pCards = new ArrayList();

        for (int suit=0; suit<=suits.length; suit++){
            for(int value=0; value<=values.length; value++){
                this.pCards.add(new Card(suits[suit], values[value]));
            }
        }
    }


    /*
    Default Constructor
    */
    public Deck(){

        constructr();
    }


    /*

     */
    public Deck(int gameType){
        switch(gameType){
            case FULL_DECK_WITH_2_JOKERS:
                constructr();
                this.pCards.add(new Card());
                this.pCards.add(new Card());
                break;
            case SAAT_AATH:
                int[] mSuits = {1, 2, 3, 4};
                int[] mValues = {1, 8, 9, 10, 11, 12, 13};
                constructr(mSuits, mValues);
                this.pCards.add(new Card(Card.HEART, 7));
                this.pCards.add(new Card(Card.SPADE, 7));
                break;
            case FULL_DECK_WITHOUT_JOKERS:
                break;
			default:
                constructr();
                break;
        }
    }

    /*

     */
    public Deck(int[] suits, int[] values){
        if (suits == null || values == null) {
            constructr();
            return;
        }

        this.pCards = new ArrayList();

        for (int suit=0; suit<=suits.length; suit++){
            for(int value=0; value<=values.length; value++){
                this.pCards.add(new Card(suits[suit], values[value]));
            }
        }
    }


    /*

     */
    public Deck (int[] suits, int[] values, int noOfJokers){
        int totalCards = (suits.length * values.length);
        int counter=0;
        Card mCard;

        //Check if there are more than 0 suits and values
        if (suits.length <= 0 || values.length <=0){
            this.pCards = null;
            return;
        }

        totalCards = (suits.length * values.length);

        // check if the last parameter is not null
        if((Integer)noOfJokers!=null){
            //check if the number of jokers are not negative
            if (noOfJokers>=0) totalCards += noOfJokers;
        }

        //initialize the array
        this.pCards = new ArrayList<>(totalCards);

        while(counter<noOfJokers){
            this.pCards.add(counter, new Card());
            counter++;
        }



        for(int suitCounter=0; suitCounter<=suits.length; suitCounter++){
            if(suits[suitCounter] >= 1 && suits[suitCounter]<=4) break;
            for(int valueCounter=0; valueCounter<values.length; valueCounter++){
                if(values[valueCounter] >= 1 && values[valueCounter]<=4) break;

                counter++;
            }
        }

    }

    public void shuffle(int shuffleType){
        switch(shuffleType){
            case RANDOM_SHUFFLE:
                randomShuffle();
                break;
            case RIFFLE_SHUFFLE:

                break;
            case DISTRIBUTED_SHUFFLE:
                break;
        }
    }

    public void randomShuffle(){
        ArrayList<Card> mCards = new ArrayList<>(pCards.size());
        ArrayList<Integer> usedElements = new ArrayList ();

        boolean used;
        for(int i = 0; i < pCards.size(); i++){
            int loc=0;

            used = true;
            while(used){
                loc = (int) (Math.random()* pCards.size());
                used = false;
                for(int j = 0; j < usedElements.size(); j++){
                    if(usedElements.get(j) == (Integer)loc){
                        used = true;
                    }
                }
            }

            usedElements.add(i, loc);
            mCards.add(i, pCards.get(loc));
        }
        pCards = mCards;
    }

    public void riffleShuffle(){
        ArrayList<Card> mCards = new ArrayList<>();
        int difference= pCards.size()/2;

        for(int i = 0; i < difference; i++){
            mCards.add(pCards.get(i));
            mCards.add(pCards.get(i+difference));
        }
        if(pCards.size() % 2 == 1){
            mCards.add(pCards.get(pCards.size()-1));
        }

        this.pCards = mCards;
    }

    public String toString(){
        String value = "";
        if (pCards == null){
            value = "no cards";
        }else {
            value = "List of cards";
            for(int i = 0; i< pCards.size(); i++){
                value = value + "\n" + pCards.get(i).toString();
            }
        }
        return value;
    }
}