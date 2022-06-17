package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Bycicle extends Vehicle{
    private String bycicleType;
    private int weight;
    private int weightCapacity;

    public Bycicle(){
        super();
    }

    public Bycicle(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int basePrice, String bycicleType, int weight, int weightCapacity) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.bycicleType = bycicleType;
        this.weight = weight;
        this.weightCapacity = weightCapacity;
    }



    public String getBycicleType() {
        return bycicleType;
    }

    public void setBycicleType(String bycicleType) {
        this.bycicleType = bycicleType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        return "Bycicle{" +
                "owner='" + getOwner() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", vehicleID='" + getVehicleID() + '\'' +
                ", ridersUIDs=" + getRidersUIDs() +
                ", open=" + isOpen() +
                ", vehicleType='" + getVehicleType() + '\'' +
                ", basePrice=" + getBasePrice() +
                "bycicleType='" + bycicleType + '\'' +
                ", weight=" + weight +
                ", weightCapacity=" + weightCapacity +
                '}';
    }
}
