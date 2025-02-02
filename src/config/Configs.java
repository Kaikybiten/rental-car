package config;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Configs {

    private static final String ABSOLUTE_PATH = System.getProperty("user.dir");
    public static final Path CSV = Paths.get(ABSOLUTE_PATH, "src", "repository");

    public static final Path ADMINISTRATOR_CSV = CSV.resolve("administrator.csv");
    public static final Path CLIENTS_CSV = CSV.resolve("clients.csv");

    public static final Path BUS_CSV = CSV.resolve("bus.csv");
    public static final Path CARS_CSV = CSV.resolve("cars.csv");
    public static final  Path MOTORCYCLE_CSV = CSV.resolve("motorcycle.csv");
}
