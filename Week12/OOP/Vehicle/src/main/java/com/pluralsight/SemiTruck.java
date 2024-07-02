package com.pluralsight;

public class SemiTruck extends Vehicle {
    private boolean hasSleeperCab;
    private int numberOfAxles;

    public boolean isHasSleeperCab() {
        return hasSleeperCab;
    }

    public void setHasSleeperCab(boolean hasSleeperCab) {
        this.hasSleeperCab = hasSleeperCab;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public void drive() {

    }
}
