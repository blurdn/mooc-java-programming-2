import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Item> items = new HashMap<>();

    public void add(String product, int price) {
        items.computeIfAbsent(product, name -> new Item(name, 0, price))
                .increaseQuantity();
    }

    public int price() {
        int totalPrice = 0;

        for (Item item : items.values()) {
            totalPrice += item.price();
        }

        return totalPrice;
    }

    public void print() {
        for(Item item : items.values()) {
            System.out.println(item);
        }
    }
}
