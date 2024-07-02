package com.pluralsight;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year,
            int odometer) {
        super(description, dateAcquired, originalCost);
        setMakeModel(makeModel);
        setYear(year);
        setOdometer(odometer);
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year must be a positive number.");
        }
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double value = 0;
        double cost = this.getOriginalCost();
        switch(year){
            case 0,1,2,3 ->  value = cost * (1-(0.03*year));
            case 4,5,6 ->  value = cost * (1-(0.06*year));
            case 7,8,9,10 ->  value = cost * (1-(0.08*year));
            default -> value = 1000;
        }

        if (odometer > 100000 && !makeModel.toLowerCase().contains("honda") && !makeModel.toLowerCase().contains(
                "toyota")){
            value *= 0.75;
        }

        return value;
    }
}
