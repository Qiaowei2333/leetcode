package PokerCard;
import java.util.*;

public class MyDeck {
    public List<MyCard> cards;
    private Random random;
    public MyDeck(boolean hasJokers) {
        random = new Random();
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (Suit s : Suit.values()) {
                if (!s.equals(Suit.BLACKJOKER) && !s.equals(Suit.REDJOKER))
                    cards.add(new MyCard(i, s));
            }
        }
        if (hasJokers) {
            cards.add(new MyCard(0, Suit.BLACKJOKER));
            cards.add(new MyCard(0, Suit.REDJOKER));
        }
    }

    public void shuffle() {
        int lastIdx = cards.size() - 1;
        while (lastIdx > 0) {
            int aRandomIdx = random.nextInt(lastIdx + 1);
            swap(cards, lastIdx, aRandomIdx);
            lastIdx--;
        }
    }

    private void swap(List<MyCard> cards, int i, int j) {
        MyCard org = cards.get(i);
        MyCard dest = cards.get(j);
        cards.set(i, dest);
        cards.set(j, org);
    }
}
