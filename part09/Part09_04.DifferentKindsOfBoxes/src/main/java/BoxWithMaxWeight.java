import java.util.ArrayList;
import java.util.List;

public class BoxWithMaxWeight extends Box {
    private final int capacity;
    private int currentWeight;
    private final List<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (currentWeight + item.getWeight() > capacity) {
            return;
        }

        items.add(item);
        currentWeight += item.getWeight();
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
