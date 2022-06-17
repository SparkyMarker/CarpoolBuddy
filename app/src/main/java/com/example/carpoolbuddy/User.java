package com.example.carpoolbuddy;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String uID;
    private String name;
    private String email;
    private String userType;
    private double priceMuiltiplier;
    private ArrayList<String> ownedVehicles;

    public User(){

    }

    public User(String uID, String name, String email, String userType, double priceMuiltiplier, ArrayList<String> ownedVehicles) {
        this.uID = uID;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.priceMuiltiplier = priceMuiltiplier;
        this.ownedVehicles = ownedVehicles;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getPriceMuiltiplier() {
        return priceMuiltiplier;
    }

    public void setPriceMuiltiplier(double priceMuiltiplier) {
        this.priceMuiltiplier = priceMuiltiplier;
    }

    public ArrayList<String> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(ArrayList<String> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID='" + uID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", priceMuiltiplier=" + priceMuiltiplier +
                ", ownedVehicles=" + ownedVehicles +
                '}';
    }
}
