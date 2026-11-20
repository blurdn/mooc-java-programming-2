package FlightControl.model;

public record Airplane(String id, int capacity) {
    @Override
    public String toString() {
        return id + " (" + capacity + " capacity)";
    }
}
