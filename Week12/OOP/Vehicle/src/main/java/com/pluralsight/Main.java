package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Moped slowRide = new Moped();
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(5);
        slowRide.setNumberOfPassengers(2);
        slowRide.setHasPedals(false);
        System.out.println(slowRide.getColor());
        System.out.println(slowRide.getFuelCapacity());
        System.out.println(slowRide.getNumberOfPassengers());
        System.out.println(slowRide.isHasPedals());
        System.out.println(slowRide.getColor());
    }
}