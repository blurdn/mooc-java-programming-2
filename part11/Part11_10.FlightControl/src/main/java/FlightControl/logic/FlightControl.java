package FlightControl.logic;

import FlightControl.model.Airplane;
import FlightControl.model.Flight;

import java.util.*;

public class FlightControl {
    private final Map<String, Airplane> airplanes = new HashMap<>();
//    private final Map<String, Airport> airports = new HashMap<>();
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

//    public void addAirport(Airport airport) {
//        airports.putIfAbsent(airport.id(), airport);
//    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void printFlights() {
        flights.forEach(System.out::println);
        System.out.println();
    }


}
