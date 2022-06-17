package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Student extends User{
    private String graduatingYear;
    private ArrayList<String> parentUIDs;
    public Student(){
        super();
    }

    public Student(String uID, String name, String email, String userType, double priceMuiltiplier, ArrayList<String> ownedVehicles, String graduatingYear, ArrayList<String> parentUIDs) {
        super(uID, name, email, userType, priceMuiltiplier, ownedVehicles);
        this.graduatingYear = graduatingYear;
        this.parentUIDs = parentUIDs;
    }

    public String getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(String graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    public ArrayList<String> getParentUIDs() {
        return parentUIDs;
    }

    public void setParentUIDs(ArrayList<String> parentUIDs) {
        this.parentUIDs = parentUIDs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uID='" + getuID() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMuiltiplier=" + getPriceMuiltiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                "graduatingYear='" + graduatingYear + '\'' +
                ", parentUIDs=" + parentUIDs +
                '}';
    }
}
