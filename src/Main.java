import controler.AdministratorController;
import model.Administrator;
import model.Client;
import model.Vehicle;
import service.AdministratorService;
import service.RentalManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        RentalManagement.loadAll();

        System.out.print("Administrator CPF: ");
        String cpfAdm = input.nextLine();
        System.out.print("Administrator Password: ");
        String passwordAdm = input.nextLine();

        AdministratorService administratorService = new AdministratorService();
        AdministratorController administratorController = new AdministratorController(
                administratorService,
                administratorService.login(cpfAdm, passwordAdm));

        System.out.print("\nClient CPF: ");
        String cpfClient = input.nextLine();

        System.out.println("\nChoose the vehicle type: ");
        System.out.println("\n1 - Car.\n2 - Motorcycle.\n3 - Bus");
        int vehicleTypeId = input.nextInt();
        input.nextLine();

        AdministratorService.transcribeVehicles(vehicleTypeId);
        System.out.print("\nEnter the license plate of the vehicle that will be rented: ");
        String licensePlate = input.nextLine();

        System.out.print("\nEnter the rental start date (DD/MM/YYYY): ");
        String startDate = input.nextLine();

        System.out.print("Enter the rental end date (DD/MM/YYYY): ");
        String endDate = input.nextLine();

        administratorController.initRental(cpfClient, licensePlate, vehicleTypeId, startDate, endDate);

        RentalManagement.rentals.forEach(System.out::println);

        RentalManagement.unloadAll();
        input.close();
    }
}