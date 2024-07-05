package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public UserInterface(){
        display();
    }

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
        Scanner scanner = new Scanner(System.in);
        int response = 99;
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
            handleResponse(response);
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

    private void displayVehicles(List<Vehicle> vehicles){
        for (Vehicle vehicle: vehicles){
            int vin = vehicle.getVin();
            int year = vehicle.getYear();
            String make = vehicle.getMake();
            String model = vehicle.getModel();
            String vehicleType = vehicle.getVehicleType();
            String color = vehicle.getColor();
            int odometer = vehicle.getOdometer();
            double price = vehicle.getPrice();
            System.out.printf("%d %d %s %s %s %s %d %f", vin, year, make, model, vehicleType, color, odometer, price);
        }
    }

    void processGetByPriceRequest() {

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
