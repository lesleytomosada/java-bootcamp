package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(new House("Hawaii Vacation Home", "7/1/2024",500000,"123 Ala Moana Dr", 1, 1200, 5000));
        assets.add(new House("My House", "6/1/2024",300000,"1378 NW 18th Ave", 2, 1500, 5000));
        assets.add(new Vehicle("Rav 4", "4/25/2024", 7500,"Toyota Rav4", 4, 120000));
        assets.add(new Vehicle("Elantra", "9/1/2013", 15000,"Hyundai Elantra", 10, 90000));

        for (Asset asset : assets) {
            System.out.println(asset.getDescription());
            System.out.println(asset.getDateAcquired());
            System.out.println(asset.getOriginalCost());
            System.out.println(asset.getValue());

            if (asset instanceof House) {
                System.out.println("Address: " + ((House) asset).getAddress());
            }
            if (asset instanceof Vehicle) {
                System.out.println("Vehicle Make: " + ((Vehicle) asset).getMakeModel());
            }
        }
    }
}