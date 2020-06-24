package kascode;

public class Deck {

    Card[] deck = new Card[36];

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int ii = 0; ii < 9; ii++) {
                deck[(9*i)+ii] = new Card(i, ii);
            }
        }
    }
    public Card[] getDeck() {
        return deck;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        String[] numberSequence = StringParser.
                getBalancedEnumeration(1, deck.getDeck().length + 1);
        Card card;

        for (int i = 0; i < numberSequence.length; i++) {
            card = deck.getDeck()[i];
            System.out.println(numberSequence[i] + "| " +
                    Card.getStringSuit(card.getSuit()) +
                    " " + Card.getStringRank(card.getRank()));
        }
    }
}
