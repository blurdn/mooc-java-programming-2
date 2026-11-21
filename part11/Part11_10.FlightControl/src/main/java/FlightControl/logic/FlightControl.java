package FlightControl.logic;

import FlightControl.model.Airplane;
import FlightControl.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightControl {
    private final Map<String, Airplane> airplanes = new HashMap<>();
    private final List<Flight> flights = new ArrayList<>();

    public void addAirplane(Airplane airplane) {
        airplanes.putIfAbsent(airplane.id(), airplane);
    }

    public Airplane getAirplane(String id) {
        return airplanes.get(id);
    }

    public void printAirplanes() {
        airplanes.values().forEach(System.out::println);
        System.out.println();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void printFlights() {
        flights.forEach(System.out::println);
        System.out.println();
    }

}
