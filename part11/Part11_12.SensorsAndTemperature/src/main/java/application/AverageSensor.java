package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private final List<Sensor> sensors = new ArrayList<>();
    private final List<Integer> readings = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public List<Integer> readings() {
        return List.copyOf(readings);
    }

    @Override
    public boolean isOn() {
        return !sensors.isEmpty() && sensors.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn()) {
            throw new IllegalStateException();
        }

        int reading = (int) sensors.stream()
                .mapToInt(Sensor::read)
                .average()
                .orElse(0);

        readings.add(reading);

        return reading;
    }
}
