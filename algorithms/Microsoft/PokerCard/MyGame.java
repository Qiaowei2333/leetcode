package PokerCard;
// https://leetcode.com/discuss/interview-question/system-design/194663/design-a-class-that-represents-a-deck-of-cards
// newbiecoder1's post is good solution

public class MyGame {
    // public void play() {

    // }

        
    public static void main(String[] args) {
        MyDeck deck = new MyDeck(true);
        deck.shuffle();
        System.out.println(deck.cards);
    }
}
