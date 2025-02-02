package service;

import config.Configs;
import enums.Availability;
import exception.CsvException;
import inteface.CsvDatas;
import model.*;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RentalManagement {

    public static List<Administrator> administrators = new ArrayList<>();
    public static List<Client> clients = new ArrayList<>();

    public static List<Car> cars = new ArrayList<>();
    public static List<Motorcycle> motorcycles = new ArrayList<>();
    public static List<Bus> buses = new ArrayList<>();

    public static List<Rental> rentals = new ArrayList<>();

    public static void loadAll(){

        loadData(Configs.ADMINISTRATOR_CSV, administrators, fields -> {
            CPF cpf = new CPF(fields[1]);
            return new Administrator(fields[0], cpf, fields[2]);
        });

        loadData(Configs.CLIENTS_CSV, clients, fields -> {
            CPF cpf = new CPF(fields[1]);
            return new Client(fields[0], cpf);
        });

        loadData(Configs.MOTORCYCLE_CSV, motorcycles, fields -> new Motorcycle(
                fields[0],
                Integer.parseInt(fields[1]),
                fields[2],
                Double.parseDouble(fields[3]),
                Availability.valueOf(fields[4])));

        loadData(Configs.BUS_CSV, buses, fields -> new Bus(
                fields[0],
                Integer.parseInt(fields[1]),
                fields[2],
                Double.parseDouble(fields[3]),
                Availability.valueOf(fields[4]),
                Integer.parseInt(fields[5])));

        loadData(Configs.CARS_CSV, cars, fields -> new Car(
                fields[0],
                Integer.parseInt(fields[1]),
                fields[2],
                Double.parseDouble(fields[3]),
                Availability.valueOf(fields[4]),
                Integer.parseInt(fields[5])));
    }

    public static void unloadAll(){
        unloadData(Configs.ADMINISTRATOR_CSV, administrators);
        unloadData(Configs.CLIENTS_CSV, clients);
        unloadData(Configs.CARS_CSV, cars);
        unloadData(Configs.MOTORCYCLE_CSV, motorcycles);
        unloadData(Configs.BUS_CSV, buses);
    }

    private static <T> void loadData(Path path,
                                     List<T> list,
                                     Function<String[], T> function){

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");

                T object = function.apply(fields);
                list.add(object);

                line = br.readLine();
            }

        }
        catch (IOException e) {
            throw new CsvException(e.getMessage());
        }
    }

    private static <T extends CsvDatas> void unloadData (Path path,
                                                         List<T> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()))){

            for (T describe : list){
                bw.write(describe.returnCSVLine());
                bw.newLine();
            }

        }
        catch (IOException e){
            throw new CsvException(e.getMessage());
        }
    }

}
