package FlightControl.model;

public record Airplane(String ID, int capacity) {
    @Override
    public String toString() {
        return ID + " (" + capacity + " capacity)";
    }
}
