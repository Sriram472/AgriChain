package com.cts.agrichain.agrichainfrpm.farmer.dto;

import java.time.LocalDate;

public class FarmerRequestDTO {

    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private String contactInfo;
    private String landDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getLandDetails() {
        return landDetails;
    }

    public void setLandDetails(String landDetails) {
        this.landDetails = landDetails;
    }
}