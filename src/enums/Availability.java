package enums;

public enum Availability {

    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable"),
    MAINTENANCE("Maintenance"),
    RESERVED("Reserved");

    private final String description;

    Availability(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}