package FlightControl.ui.modules;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Module {
    private final Map<String, Runnable> actions = new LinkedHashMap<>();
    private final Scanner scanner;

    public Module(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(Scanner scanner) {
        while(true) {
            printActionChoice();

            String input = scanner.nextLine();
            if (input.equals("x")) return;

            int actionIndex;
            try {
                actionIndex = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                incorrectInputResponse();
                continue;
            }

            executeAction(actionIndex);
        }
    }

    public void addAction(String actionName, Runnable action) {
        actions.put(actionName, action);
    }

    private void printActionChoice() {
        int i = 1;

        System.out.println("Choose an action:");

        for (var entry : actions.entrySet()) {
            System.out.println("[" + i + "] " + entry.getKey());
            i++;
        }

        System.out.println("[x] " + getQuitActionName());

        System.out.print("> ");
    }

    abstract String getQuitActionName();

    private void executeAction(int actionIndex) {
        if (actionIndex > actions.size()) {
            incorrectInputResponse();
            return;
        }

        Runnable task = actions.values()
                .stream()
                .skip(actionIndex - 1)
                .findFirst()
                .orElse(() -> {incorrectInputResponse(); return;});

        task.run();
    }

    private void incorrectInputResponse() {
        System.out.println("Incorrect input!");
    }
}
