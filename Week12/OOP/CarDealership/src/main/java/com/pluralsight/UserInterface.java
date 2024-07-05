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
                    6 - Find vehicles by type (car, truck, SUV, van)
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
        System.out.printf("%-" + vinWidth + "s %-" + yearWidth + "s %-" + makeWidth + "s %-" + modelWidth + "s %-" + typeWidth + "s %-" + colorWidth + "s %-" + odometerWidth + "s %-" + priceWidth + "s\n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");

        // Print each vehicle's details
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-" + vinWidth + "d %-" + yearWidth + "d %-" + makeWidth + "s %-" + modelWidth + "s %-" + typeWidth + "s %-" + colorWidth + "s %-" + odometerWidth + "d $%-" + (priceWidth-1) + ".2f\n",
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
    }

    void processGetByPriceRequest() {
        System.out.print("Min Price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Max Price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        List<Vehicle> priceFiltered = dealership.getVehiclesByPrice(maxPrice, minPrice);
        displayVehicles(priceFiltered);
    }

    void processGetByMakeModelRequest() {

    }

    void processGetByYearRequest() {

    }

    void processGetByColorRequest() {

    }

    void processGetByMileageRequest() {

    }

    void processGetByVehicleTypeRequest() {

    }

    void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());

    }

    void processAddVehicleRequest() {

    }

    void processRemoveVehicleRequest() {

    }


}
