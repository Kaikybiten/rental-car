package model;


import enums.Availability;
import exception.VehicleException;

public class Bus extends Vehicle{
    private Integer capability;

    public Bus (String model, Integer manufactureYear, String licensePlate, Double dayPrice, Availability availability, Integer capability){
        if (capability <= 0) {
            throw new VehicleException("The capability must be greater than 0 (zero).");
        }
        this.capability = capability;
        super(model, manufactureYear, licensePlate, dayPrice, availability);
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
        csv.append(capability);

        return csv.toString();
    }
}
