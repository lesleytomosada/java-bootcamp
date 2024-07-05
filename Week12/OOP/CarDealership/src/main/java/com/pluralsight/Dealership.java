package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            double price = vehicle.getPrice();
            if (price < max && price > min){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            String vehicleMake = vehicle.getMake();
            String vehicleModel = vehicle.getModel();
            if (vehicleModel.equalsIgnoreCase(model) && vehicleMake.equalsIgnoreCase(make)){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            int year = vehicle.getYear();
            if (year > min && year < max){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            String vehicleColor = vehicle.getColor();
            if (vehicleColor.equalsIgnoreCase(color)){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            int mileage = vehicle.getOdometer();
            if (mileage < max && mileage > min){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> filteredData = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            String vehicleType = vehicle.getVehicleType();
            if (vehicleType.equalsIgnoreCase(type)){
                filteredData.add(vehicle);
            }
        }
        return filteredData;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

    }

}
