package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition,
            int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        setAddress(address);
        setCondition(condition);
        setSquareFoot(squareFoot);
        setLotSize(lotSize);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        if (condition > 0 && condition < 5) {
            this.condition = condition;
        } else {
            throw new IllegalArgumentException("Please enter a number between 1 and 4");
        }
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double value = 0;
        switch(condition){
            case 1 -> value = squareFoot * 180;
            case 2 -> value = squareFoot * 130;
            case 3 -> value = squareFoot * 90;
            case 4 -> value = squareFoot * 80;
        }
        value += (squareFoot * 0.25);
        return value;
    }
}
