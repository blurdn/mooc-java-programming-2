import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private final Map<String, Integer> productsPrices = new HashMap<>();
    private final Map<String, Integer> productsStock = new HashMap<>();


    public void addProduct(String product, int price, int stock) {
        productsPrices.put(product, price);
        productsStock.put(product, stock);
    }

    public int price(String product) {
        return productsPrices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return productsStock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int currStock = productsStock.getOrDefault(product, 0);

        if (currStock <= 0) {
            return false;
        }

        productsStock.put(product, currStock - 1);
        return true;
    }

    public Set<String> products() {
        return Collections.unmodifiableSet(productsPrices.keySet());
    }
}
