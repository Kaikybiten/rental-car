package service;

import enums.Availability;
import enums.RentalType;
import exception.RentalException;
import model.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class AdministratorService {

    public <T extends User> T findByCpf(String cpf, List<T> userList){

        return userList.stream()
                .filter(x -> x.getCpf().getCPF().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Administrator login(String cpf, String password) throws Exception{

        Administrator adm = findByCpf(cpf, RentalManagement.administrators);

        if (adm == null){
            throw new Exception("erro");
        }
        if (!(adm.getPassword().equals(password))){
            throw new Exception("erro");
        }

        return adm;
    }

    public Rental createRental (String licensePlate, Integer vehicleIdType, Client client, String start, String end){

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(start, dateFormat);
        LocalDate endDate = LocalDate.parse(end, dateFormat);

        if (endDate.isBefore(startDate)){
            throw new RentalException("The rental end date must be later than the start date.");
        }

        int days = (int) ChronoUnit.DAYS.between(startDate, endDate);


        RentalType rentalType = verifyAvailability(days);

        var vehicle = switch (vehicleIdType){
            case 1 -> RentalManagement.cars.stream()
                        .filter(x -> x.getLicensePlate().equals(licensePlate))
                        .findFirst().orElse(null);
            case 2 -> RentalManagement.motorcycles.stream()
                        .filter(x -> x.getLicensePlate().equals(licensePlate))
                        .findFirst().orElse(null);
            case 3 -> RentalManagement.buses.stream()
                        .filter(x -> x.getLicensePlate().equals(licensePlate))
                        .findFirst().orElse(null);
            default -> throw new RentalException("Invalid license plate");
        };


        assert vehicle != null;
        if (vehicle.getAvailability() != Availability.AVAILABLE) {
            throw new RentalException("Vehicle not available at the moment. vehicle condition: " + vehicle.getAvailability());
        }
        vehicle.setAvailability(changeAvailabilityVehicle(startDate, endDate));

        Double dayPrice = switch (rentalType) {
            case RentalType.DAILY -> vehicle.getDayPrice();
            case RentalType.WEEKLY -> vehicle.getDayPrice() - (vehicle.getDayPrice() * 0.40);
            case RentalType.MONTHLY -> vehicle.getDayPrice() - (vehicle.getDayPrice() * 0.50);
        };

        Double totalPrice = dayPrice * days;

        return new Rental(vehicle, client, startDate, endDate, rentalType, dayPrice, totalPrice);
    }

    private RentalType verifyAvailability (Integer days){
        if (days >= 30){
            return RentalType.MONTHLY;
        }
        if (days >= 7) {
            return RentalType.WEEKLY;
        }
        return RentalType.DAILY;
    }

    public static void transcribeVehicles (int idType){
        switch (idType) {
            case 1:
                RentalManagement.cars.forEach(System.out::println);
                break;
            case 2:
                RentalManagement.motorcycles.forEach(System.out::println);
                break;
            case 3:
                RentalManagement.buses.forEach(System.out::println);
                break;
            default:
                throw new RentalException("Id vehicle invalid.");
        }
    }

    private Availability changeAvailabilityVehicle(LocalDate start, LocalDate end){
        if (LocalDate.now().isAfter(start) && LocalDate.now().isBefore(end)){
            return Availability.UNAVAILABLE;
        }
        return Availability.RESERVED;
    }

}
