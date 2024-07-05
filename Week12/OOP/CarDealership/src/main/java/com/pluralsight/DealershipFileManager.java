package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class DealershipFileManager {
    public Dealership getDealership(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/com/pluralsight/inventory.csv");
            Scanner scanner = new Scanner(fis);
            ArrayList<String> lines = new ArrayList<>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
            return getDealership(lines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Dealership getDealership(ArrayList<String> lines) {
        String[] dealershipInfo = lines.get(0).split("\\|");
        String dealershipName = dealershipInfo[0];
        String dealershipAddress = dealershipInfo[1];
        String dealershipPhone = dealershipInfo[2];
        Dealership dealership = new Dealership(dealershipName,dealershipAddress,dealershipPhone);

        for (int i=1; i< lines.size(); i++){
            Vehicle vehicle = getVehicle(lines, i);
            dealership.addVehicle(vehicle);
        }
        return dealership;
    }

    private static Vehicle getVehicle(ArrayList<String> lines, int i) {
        String[] vehicleInfo = lines.get(i).split("\\|");
        int vin =  parseInt(vehicleInfo[0]);
        int year =  parseInt(vehicleInfo[1]);
        String make = vehicleInfo[2];
        String model = vehicleInfo[3];
        String vehicleType = vehicleInfo[4];
        String color = vehicleInfo[5];
        int odometer =  parseInt(vehicleInfo[6]);
        double price = parseDouble(vehicleInfo[7]);
//        System.out.println(vin + ", " + year + ", " + make + ", " + model + ", " + vehicleType + ", " + color + ", " + odometer + ", " + price);
        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }

    public void saveDealership(Dealership dealership){

    }
}
