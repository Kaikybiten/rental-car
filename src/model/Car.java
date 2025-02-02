package model;

import enums.Availability;

public class Car extends Vehicle {
    private Integer doors;

    public Car(String model, Integer manufactureYear, String licensePlate, Double dayPrice, Availability availability, Integer doors) {
        this.doors = doors;
        super(model, manufactureYear, licensePlate, dayPrice, availability);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getModel(), getManufactureYear(), getLicensePlate());
    }

    @Override
    public String returnCSVLine() {
        StringBuilder csv;
        csv = new StringBuilder();

        csv.append(getModel()).append(",");
        csv.append(getManufactureYear()).append(",");
        csv.append(getLicensePlate()).append(",");
        csv.append(getDayPrice()).append(",");
        csv.append(getAvailability().toString().toUpperCase()).append(",");
        csv.append(doors);

        return csv.toString();
    }
}
