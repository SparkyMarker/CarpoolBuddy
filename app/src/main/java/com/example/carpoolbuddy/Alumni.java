package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Alumni extends User{
    private int graduateYear;
    public Alumni(){
        super();
    }

    public Alumni(String uID, String name, String email, String userType, double priceMuiltiplier, ArrayList<String> ownedVehicles, int graduateYear) {
        super(uID, name, email, userType, priceMuiltiplier, ownedVehicles);
        this.graduateYear = graduateYear;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "uID='" + getuID() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMuiltiplier=" + getPriceMuiltiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                "graduateYear=" + graduateYear +
                '}';
    }
}
