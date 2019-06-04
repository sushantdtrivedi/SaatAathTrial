package com.aceappsdev.apps.saataathtrial.structure;

//Class Card


public class Card{

    //Properties
    private int pSuit;
    private int pValue;

    //Public constants
    public static final int JOKER = 0;

    public static final int HEART = 1;
    public static final int SPADE=2;
    public static final int CLUB=3;
    public static final int DIAMOND=4;

    public static final int ACE=1;
    public static final int JACK=11;
    public static final int QUEEN=12;
    public static final int KING=13;

    //private constants
    private static final String sJOKER = "Joker";
    private static final String sHEART = "Heart";
    private static final String sSPADE = "Spade";
    private static final String sCLUB = "Club";
    private static final String sDIAMOND = "Diamond";

    private static final String sACE = "Ace";
    private static final String sJACK = "Jack";
    private static final String sQUEEN = "Queen";
    private static final String sKING = "King";

    /*

     */
    public Card(){
        //Code f|| default card
        this.pSuit = JOKER;
        this.pValue = JOKER;
    }

    /*

     */
    public Card (int suit, int value){
        //Code f|| specified card
        this.pSuit = JOKER;
        this.pValue = JOKER;
        if(suit == JOKER || value == JOKER) {
        } else{
            if (suit >= 1 && suit <= 4 && value >= 1 && value <= 13) {
                this.pSuit = suit;
                this.pValue = value;
            }
        }
    }

    /*

     */
    public String cardValueString(){
        if(this.pValue < 0 || this.pValue > 13){
            this.pSuit=0;
            this.pValue=0;
            return sJOKER;
        }

        switch(this.pValue){
            case JOKER: // Joker
                this.pSuit = JOKER; // Ensure that the suit matches the Joker
                return sJOKER;
            case ACE: // Ace
                return sACE;
            case JACK: // Jack
                return sJACK;
            case QUEEN: // Queen
                return sQUEEN;
            case KING: // King
                return sKING;
			default:
                return Integer.toString(this.pValue);
        }
    }

    /*

     */
    public String cardSuitString(){
        if(this.pSuit < 0 || this.pSuit > 4){
            this.pSuit=0;
            this.pValue=0;
            return this.sJOKER;
        }

        switch(this.pSuit){
            case 0:
                this.pValue = 0;
                return sJOKER;
            case 1:
                return sHEART;
            case 2:
                return sSPADE;
            case 3:
                return sCLUB;
            case 4:
                return sDIAMOND;
        }
        return null;
    }


    /*

     */
    public int getValue(){
        if(this.pValue < 0 || this.pValue > 13){
            this.pSuit=0;
            this.pValue=0;
            return this.JOKER;
        }
        return this.pValue;
    }


    /*

     */
    public int getSuit (){
        if(this.pSuit < 0 || this.pSuit > 4){
            this.pSuit=0;
            this.pValue=0;
            return this.JOKER;
        }
        return this.pSuit;
    }


    /*

     */
    public String toString(){
        String result = ""; // initialize the local variable
        if(this.pValue > 13 || this.pValue<=0 || this.pSuit<=0 || this.pSuit>4){
            this.pSuit = JOKER;
            this.pValue = JOKER;
            return sJOKER; // if the value of the card is out of bounds, return null
        }

        return cardValueString() + " of " + cardSuitString();
    }
}