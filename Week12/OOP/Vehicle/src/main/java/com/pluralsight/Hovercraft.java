package com.pluralsight;

public class Hovercraft extends Vehicle {
    private boolean hasEnclosedCabin;
    private float maxHoverHeight;

    public boolean isHasEnclosedCabin() {
        return hasEnclosedCabin;
    }

    public void setHasEnclosedCabin(boolean hasEnclosedCabin) {
        this.hasEnclosedCabin = hasEnclosedCabin;
    }

    public float getMaxHoverHeight() {
        return maxHoverHeight;
    }

    public void setMaxHoverHeight(float maxHoverHeight) {
        this.maxHoverHeight = maxHoverHeight;
    }

    @Override
    public void drive() {
        
    }
}
