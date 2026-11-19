package FlightControl.logic;

import FlightControl.model.Airplane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlightControl {
    private final Map<String, Airplane> vehicles = new HashMap<>();

    public void addVehicle(String id, Airplane airplane) {
        vehicles.putIfAbsent(id, airplane);
    }

    public void printVehicles() {
        vehicles.values().forEach(System.out::println);
    }
}
