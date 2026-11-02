import java.util.Objects;

public class OneItemBox extends Box {
    private Item item;

    @Override
    public void add(Item item) {
        if (this.item == null) {
            this.item = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return Objects.equals(this.item, item);
    }
}
