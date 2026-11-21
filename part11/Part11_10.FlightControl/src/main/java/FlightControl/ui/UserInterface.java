package FlightControl.ui;

import FlightControl.logic.FlightControl;
import FlightControl.model.Airplane;
import FlightControl.model.Flight;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final FlightControl flightControl = new FlightControl();

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        assetControl();
        flightControl();
    }

    private void assetControl() {
        System.out.println("Airport Asset Control\n");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> addAirplane();
                case "2" -> addFlight();
                case "x" -> { return; }
                case null, default -> System.out.println("Wrong input!");
            }

            System.out.println();
        }
    }

    private void flightControl() {
        System.out.println("Flight Control\n");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> flightControl.printAirplanes();
                case "2" -> flightControl.printFlights();
                case "3" -> printAirplaneDetails();
                case "x" -> { return; }
                case null, default -> System.out.println("Wrong input!");
            }

            System.out.println();
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String airplaneId = scanner.nextLine();

        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        flightControl.addAirplane(new Airplane(airplaneId, capacity));
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = flightControl.getAirplane(scanner.nextLine());

        System.out.print("Give the departure airport id: ");
        String departureId = scanner.nextLine();

        System.out.print("Give the target airport id: ");
        String targetId = scanner.nextLine();

        flightControl.addFlight(new Flight(airplane, departureId, targetId));
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = flightControl.getAirplane(scanner.nextLine());

        System.out.println(airplane);
        System.out.println();
    }

}
