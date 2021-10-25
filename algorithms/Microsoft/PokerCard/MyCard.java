package PokerCard;

public class MyCard {
    private Suit suit;
    private int value;

    public MyCard(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit.toString();
    }

    public void setSuit(Suit s) {
        this.suit = s;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int v) {
        this.value = v;
    }
}
