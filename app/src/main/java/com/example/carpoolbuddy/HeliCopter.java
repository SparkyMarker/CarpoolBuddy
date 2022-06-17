package com.example.carpoolbuddy;

import java.util.ArrayList;

public class HeliCopter extends Vehicle{
    private int maxAltitude;
    private int maxAirSpeed;

    public HeliCopter(){
        super();
    }


    public HeliCopter(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int basePrice, int maxAltitude, int maxAirSpeed) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.maxAltitude = maxAltitude;
        this.maxAirSpeed = maxAirSpeed;
    }



    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAirSpeed() {
        return maxAirSpeed;
    }

    public void setMaxAirSpeed(int maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    @Override
    public String toString() {
        return "HeliCopter{" +
                "owner='" + getOwner() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", vehicleID='" + getVehicleID() + '\'' +
                ", ridersUIDs=" + getRidersUIDs() +
                ", open=" + isOpen() +
                ", vehicleType='" + getVehicleType() + '\'' +
                ", basePrice=" + getBasePrice() +
                ", maxAltitude=" + maxAltitude +
                ", maxAirSpeed=" + maxAirSpeed +
                '}';
    }
}
