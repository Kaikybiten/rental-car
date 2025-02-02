package enums;

public enum RentalType {

    MONTHLY("Monthly"),
    DAILY("Daily"),
    WEEKLY("Weekly");

    private final String description;

    RentalType(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
