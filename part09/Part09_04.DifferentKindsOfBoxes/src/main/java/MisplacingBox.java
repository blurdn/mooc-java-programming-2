import java.util.ArrayList;
import java.util.List;

public class MisplacingBox extends Box {

    @Override
    public void add(Item item) {
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
