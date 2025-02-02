package model;

import enums.Availability;
import inteface.CsvDatas;

public class Vehicle implements CsvDatas {
    private final String model;
    private final String licensePlate;
    private final Integer manufactureYear;
    private Availability availability;
    private final Double dayPrice;

    public Vehicle (String model, Integer manufactureYear, String licensePlate, Double dayPrice, Availability availability){
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.licensePlate = licensePlate;
        this.dayPrice = dayPrice;
        this.availability = availability;
    }



    @Override
    public String returnCSVLine() {
        StringBuilder csv;
        csv = new StringBuilder();

        csv.append(model).append(",");
        csv.append(manufactureYear).append(",");
        csv.append(licensePlate).append(",");
        csv.append(dayPrice).append(",");
        csv.append(availability.toString().toUpperCase());

        return csv.toString();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public Double getDayPrice() {
        return dayPrice;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
