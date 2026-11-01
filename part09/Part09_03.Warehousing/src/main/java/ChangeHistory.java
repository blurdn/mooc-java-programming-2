import java.util.ArrayList;
import java.util.List;

public class ChangeHistory {
    private final List<Double> history = new ArrayList<>();

    public void add(double value) {
        history.add(value);
    }

    public void clear() {
        history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double maxValue = history.get(0);
        for (double value : history) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double minValue = history.get(0);
        for (double value : history) {
            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double value : history) {
            sum += value;
        }

        return sum / history.size();
    }

    @Override
    public String toString() {
        return history.toString();
    }
}
