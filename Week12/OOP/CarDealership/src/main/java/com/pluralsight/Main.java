package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        DealershipFileManager manager = new DealershipFileManager();
        Dealership dealership = manager.getDealership();
        System.out.println(dealership.getAllVehicles());
    }
}