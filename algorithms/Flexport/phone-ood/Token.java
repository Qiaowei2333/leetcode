import java.util.Map;

public class Token {
    public Color color;
}

public enum Color {
    Red, Green, Blue, White, Black, Golden
}

public class Card {
    public Suit suit;
}

public enum Suit {
    Heart, Spades, Club, Diamond
}

public class Player {
    //private List<Token> tokens;
    public List<Card> cards;
    public Map<Color, Integer> tokens;

    public Palyer() {
        this.cards = new LinkedList<>();
        for (Color c : Color.values()) {
            tokens.put(c, 0);
        }
    }

    public boolean canPurchase(Card c) {
        if (c.suit == Suit.Club) {
            return tokens.get(Color.Black) > 1;
        }
        else if (c.suit == Suit.Diamond) {
            return tokens.get(Color.White) > 1;
        }
        else {
            return false;
        }
    }

    public void makePurchase(Card c) {
        if (!canPurchase(c)) return;
        if (c.suit == Suit.Club) {
            tokens.put(Color.Black, tokens.get(Color.Black) - 2);
        }
        else if (c.suit == Suit.Diamond) {
            tokens.put(Color.White, tokens.get(Color.White) - 2);
        }
    }

    public void printCards() {
        for (Card c : cards) {
            System.out.println(c.suit.toString());
        }
    }

    public void printTokens() {
        for (Map.Entry<Color, Integer> e : tokens.entrySet()) {
            System.out.println(e.getKey(), e.getValue());
        }
    }
}

public class CardsGame {
    private Player player;
    private static CardsGame game = null;
    private static CardsGame getInstance() {
        if (game == null) {
            game = new CardsGame();
        }
        return game;
    }

    public void initializePalyer() {
        this.player = new Player();
        this.player.tokens = new HashMap<>();
        this.player.tokens.put(Color.Black, 3);
        this.player.tokens.put(Color.White, 3);
    }
}

