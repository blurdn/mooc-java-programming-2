import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private final List<Movable> members = new ArrayList<>();

    public void addToHerd(Movable movable) {
        if (movable == this) return;

        if (movable != null) {
            members.add(movable);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable member : members) {
            member.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Movable member : members) {
            sb.append(member).append("\n");
        }

        return sb.toString();
    }
}
