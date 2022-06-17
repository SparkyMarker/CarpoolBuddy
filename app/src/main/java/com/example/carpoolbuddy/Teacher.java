package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Teacher extends User{
    private String inSchoolTitle;

    public Teacher(){
        super();
    }

    public Teacher(String uID, String name, String email, String userType, double priceMuiltiplier, ArrayList<String> ownedVehicles, String inSchoolTitle) {
        super(uID, name, email, userType, priceMuiltiplier, ownedVehicles);
        this.inSchoolTitle = inSchoolTitle;
    }

    public String getInSchoolTitle() {
        return inSchoolTitle;
    }

    public void setInSchoolTitle(String inSchoolTitle) {
        this.inSchoolTitle = inSchoolTitle;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uID='" + getuID() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMuiltiplier=" + getPriceMuiltiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                "inSchoolTitle='" + inSchoolTitle + '\'' +
                '}';
    }
}
