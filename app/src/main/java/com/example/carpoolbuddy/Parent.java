package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Parent extends User{
    private ArrayList<String> childrenUIDs;

    public Parent(){
        super();
    }

    public Parent(String uID, String name, String email, String userType, double priceMuiltiplier, ArrayList<String> ownedVehicles, ArrayList<String> childrenUIDs) {
        super(uID, name, email, userType, priceMuiltiplier, ownedVehicles);
        this.childrenUIDs = childrenUIDs;
    }

    public ArrayList<String> getChildrenUIDs() {
        return childrenUIDs;
    }

    public void setChildrenUIDs(ArrayList<String> childrenUIDs) {
        this.childrenUIDs = childrenUIDs;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "uID='" + getuID() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMuiltiplier=" + getPriceMuiltiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                "childrenUIDs=" + childrenUIDs +
                '}';
    }
}
