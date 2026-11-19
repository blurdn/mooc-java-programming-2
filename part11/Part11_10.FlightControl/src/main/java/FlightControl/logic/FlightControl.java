package FlightControl.logic;

import FlightControl.model.Airplane;

import java.util.HashSet;
import java.util.Set;

public class FlightControl {
    private final Set<Airplane> vehicles = new HashSet<>();

    public void addVehicle(Airplane vehicle) {
        vehicles.add(vehicle);
    }

    public void printVehicles() {
        vehicles.forEach(System.out::println);
    }
}
