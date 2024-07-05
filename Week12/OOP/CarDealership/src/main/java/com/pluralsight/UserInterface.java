package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    Scanner scanner = new Scanner(System.in);

    void display() {
        init();
    }

    private void init(){
        initDealership();
        displayMenu();
    }

    private void initDealership(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }


    private void displayMenu(){
        int response;
        do {
            System.out.print("""
                    Please choose an option:
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit
                    """);
            response = scanner.nextInt();
            scanner.nextLine();
            if (response < 1 || response > 9) {
                response = 99;
            } else {
                handleResponse(response);
            }
        } while (response != 99);
    }

    private void handleResponse(int response) {
        switch(response){
            case 1 -> processGetByPriceRequest();
            case 2 -> processGetByMakeModelRequest();
            case 3 -> processGetByYearRequest();
            case 4 -> processGetByColorRequest();
            case 5 -> processGetByMileageRequest();
            case 6 -> processGetByVehicleTypeRequest();
            case 7 -> processGetAllVehiclesRequest();
            case 8 -> processAddVehicleRequest();
            case 9 -> processRemoveVehicleRequest();
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles != null && !vehicles.isEmpty()) {
            // Define column widths. Adjust these values based on your data for better alignment.
            int vinWidth = 10;
            int yearWidth = 6;
            int makeWidth = 10;
            int modelWidth = 10;
            int typeWidth = 10;
            int colorWidth = 10;
            int odometerWidth = 10;
            int priceWidth = 10;

            // Print header
            System.out.printf("%-" + vinWidth + "s %-" + yearWidth + "s %-" + makeWidth + "s %-" + modelWidth + "s %-" +
                            typeWidth + "s %-" + colorWidth + "s %-" + odometerWidth + "s %-" + priceWidth + "s\n", "VIN",
                    "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");

            // Print each vehicle's details
            for (Vehicle vehicle : vehicles) {
                System.out.printf(
                        "%-" + vinWidth + "d %-" + yearWidth + "d %-" + makeWidth + "s %-" + modelWidth + "s %-" +
                                typeWidth + "s %-" + colorWidth + "s %-" + odometerWidth + "d $%-" + (priceWidth - 1) +
                                ".2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
            }
            System.out.println();
        } else {
            System.out.println("No vehicles found matching those search terms");
        }
    }

    void processGetByPriceRequest() {
        double minPrice;
        double maxPrice;

        do {
            System.out.print("Min Price: ");
            minPrice = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Max Price: ");
            maxPrice = scanner.nextDouble();
            scanner.nextLine();

            if (maxPrice < minPrice) {
                System.out.println("Please enter a max year after the min year");
            }
        } while (maxPrice < minPrice);

        List<Vehicle> priceFiltered = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(priceFiltered);
    }

    void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        List<Vehicle> makeModelFiltered = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(makeModelFiltered);
    }

    void processGetByYearRequest() {
        int min;
        int max;
        do {
            System.out.print("Min Year: ");
            min = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Max Year: ");
            max = scanner.nextInt();
            scanner.nextLine();
            if (max < min) {
                System.out.println("Please enter a max year after the min year");
            }
        } while (max < min);

        List<Vehicle> yearFiltered = dealership.getVehiclesByYear(min, max);
        displayVehicles(yearFiltered);
    }

    void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();

        List<Vehicle> colorFiltered = dealership.getVehiclesByColor(color);
        displayVehicles(colorFiltered);
    }

    void processGetByMileageRequest() {
        int min;
        int max;
        do {
            System.out.print("Min Mileage: ");
            min = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Max Mileage: ");
            max = scanner.nextInt();
            scanner.nextLine();
            if (max < min) {
                System.out.println("Please enter a max mileage below the min mileage");
            }
        } while (max < min);

        List<Vehicle> mileageFiltered = dealership.getVehiclesByMileage(min, max);
        displayVehicles(mileageFiltered);

    }

    void processGetByVehicleTypeRequest() {
        int choice;
        do {
            System.out.println("""
                    Choose a Vehicle Type:
                     1 - Car
                     2 - Truck
                     3 - SUV
                     4 - Van
                    """);
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 | choice > 4) {
                System.out.println("Please choose one of the options above");
            }
        } while (choice < 1 | choice > 4);

        String type = "";

        switch(choice){
            case 1 -> type = "Car";
            case 2 -> type = "Truck";
            case 3 -> type = "SUV";
            case 4 -> type = "Van";
        }

        List<Vehicle> typeFiltered = dealership.getVehiclesByType(type);
        displayVehicles(typeFiltered);
    }

    void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());

    }

    void processAddVehicleRequest() {

    }

    void processRemoveVehicleRequest() {

    }


}
