import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Hand implements Comparable<Hand> {
    private final List<Card> hand = new ArrayList<>();

    public void add(Card card) {
        hand.add(Objects.requireNonNull(card, "Card cannot be null"));
    }

    public void print() {
        hand.forEach(System.out::println);
    }

    public void sort() {
        hand.sort(Comparator.naturalOrder());
    }

    public int getValue() {
        return hand.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public void sortBySuit() {
        hand.sort(new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand otherHand) {
        return Integer.compare(this.getValue(), otherHand.getValue());
    }
}
