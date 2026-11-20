package FlightControl.model;

public record Flight(Airplane airplane, String departureId, String destinationId) {
    @Override
    public String toString() {
        return airplane + " (" + departureId + "-" + destinationId + ")";
    }
}
