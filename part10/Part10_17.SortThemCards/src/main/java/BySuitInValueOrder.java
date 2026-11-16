import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    private static final Comparator<Card> BY_SUIT_THEN_VALUE = Comparator
            .comparing(Card::getSuit)
            .thenComparingInt(Card::getValue);

    @Override
    public int compare(Card card1, Card card2) {
        return BY_SUIT_THEN_VALUE.compare(card1, card2);
    }
}
