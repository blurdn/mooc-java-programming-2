package FlightControl.ui.modules;

import java.util.Scanner;

public class AirportAssetControlModule extends Module {
    public AirportAssetControlModule(Scanner scanner) {
        super(scanner);
    }

    @Override
    String getQuitActionName() {
        return "Exit Airport Asset Control";
    }
}
