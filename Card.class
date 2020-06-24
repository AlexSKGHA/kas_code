package kascode;

public class Card {

    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;

    public static final int SIX = 0;
    public static final int SEVEN = 1;
    public static final int EIGHT = 2;
    public static final int NINE = 3;
    public static final int TEN = 4;
    public static final int JACK = 5;
    public static final int QUEEN = 6;
    public static final int KING = 7;
    public static final int ACE = 8;

    int suit;
    int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public static String getStringSuit(int suit) {
        switch (suit) {
            case CLUBS: return "CLUBS";
            case DIAMONDS: return "DIAMONDS";
            case HEARTS: return "HEARTS";
            case SPADES: return  "SPADES";
            default:
                return null;
        }
    }

    public static String getStringRank(int rank) {
        switch (rank) {
            case SIX: return "SIX";
            case SEVEN: return "SEVEN";
            case EIGHT: return "EIGHT";
            case NINE: return "NINE";
            case TEN: return "TEN";
            case JACK: return "JACK";
            case QUEEN: return "QUEEN";
            case KING: return "KING";
            case ACE: return "ACE";
            default:
                return null;
        }
    }
}
