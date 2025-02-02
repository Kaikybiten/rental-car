package controler;

import model.Administrator;
import model.Client;
import service.AdministratorService;
import service.RentalManagement;

public class AdministratorController {

    private AdministratorService service;
    private Administrator administrator;

    public AdministratorController (AdministratorService service, Administrator administrator) {
        this.service = service;
        this.administrator = administrator;
    }

    public void initRental (String cpf, String licensePlate, Integer vehicleTypeId, String start, String end) {

        Client client = service.findByCpf(cpf, RentalManagement.clients);

        RentalManagement.rentals.add(service.createRental(licensePlate, vehicleTypeId, client, start, end));
    }

}
