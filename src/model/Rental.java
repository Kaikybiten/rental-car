package model;

import enums.RentalType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rental {
    private Vehicle vehicle;
    private Client client;
    private RentalType rentalType;
    private LocalDate start, end;
    private Double totalPrice, dayPrice;

    public Rental (Vehicle vehicle,
                   Client client,
                   LocalDate start,
                   LocalDate end,
                   RentalType rentalType,
                   Double dayPrice,
                   Double totalPrice) {

        this.vehicle = vehicle;
        this.end = end;
        this.start = start;
        this.rentalType = rentalType;
        this.client = client;
        this.totalPrice = totalPrice;
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String startStr = dateFormat.format(this.start);
        String endStr = dateFormat.format(this.end);

        sb.append(System.lineSeparator());

        sb.append(startStr).append(" - ").append(endStr).append(System.lineSeparator());

        sb.append("Client: ").append(client.getName()).append(System.lineSeparator());

        sb.append("Vehicle: ").append(vehicle).append(System.lineSeparator());

        sb.append("Total price: R$").append(String.format("%.2f", totalPrice));

        return sb.toString();
    }
}
