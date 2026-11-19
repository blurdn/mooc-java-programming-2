package FlightControl.ui;

import FlightControl.logic.FlightControl;
import FlightControl.model.Airplane;
import FlightControl.ui.modules.AirportAssetControlModule;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        var assetControlModule = new AirportAssetControlModule(scanner);

        var flightControl = new FlightControl();

//        assetControlModule.addAction("Add an airplane", flightControl.add);
    }

    //TODO: Replace ui modules with simple switch condition because of the overengineering

}
