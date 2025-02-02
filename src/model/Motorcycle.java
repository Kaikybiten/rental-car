package model;

import enums.Availability;

public class Motorcycle extends Vehicle{

    public Motorcycle(String model, Integer manufactureYear, String licensePlate, Double dayPrice, Availability availability) {
        super(model, manufactureYear, licensePlate, dayPrice, availability);
    }
}
