import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Box implements Packable {
    private final double capacity;
    private final List<Packable> contents;

    public Box(double capacity) {
        this.capacity = capacity;
        contents = new ArrayList<>();
    }

    public void add(Packable item) {
        if (weight() + item.weight() > capacity) {
            return;
        }

        contents.add(item);
    }

    @Override
    public double weight() {
        double weight = 0;

        for (Packable item : contents) {
            weight += item.weight();
        }

        return weight;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Box: %d items, total weight %.1f kg", contents.size(), weight());
    }
}
