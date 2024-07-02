package com.pluralsight;

public class Moped extends Vehicle {
    private int engineSize;
    private boolean hasPedals;

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public boolean isHasPedals() {
        return hasPedals;
    }

    public void setHasPedals(boolean hasPedals) {
        this.hasPedals = hasPedals;
    }

    @Override
    public void drive() {

    }
}
