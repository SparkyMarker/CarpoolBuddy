package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Segway extends Vehicle{
    private int range;
    private int weightCapacity;
    public Segway(){
    super();
    }

    public Segway(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int basePrice, int range, int weightCapacity) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.range = range;
        this.weightCapacity = weightCapacity;
    }



    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        return "Segway{" +
                "owner='" + getOwner() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", vehicleID='" + getVehicleID() + '\'' +
                ", ridersUIDs=" + getRidersUIDs() +
                ", open=" + isOpen() +
                ", vehicleType='" + getVehicleType() + '\'' +
                ", basePrice=" + getBasePrice() +
                "range=" + range +
                ", weightCapacity=" + weightCapacity +
                '}';
    }
}
