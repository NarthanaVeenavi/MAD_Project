package com.example.home;

import java.io.Serializable;

public class BloodBankDetailsModelClass {

    Integer id;
    String bloodBankName;
    String address;
    String phone_number;
    String district;
    String city;
    String postalCode;
    String username;
    String rePassword;

    public BloodBankDetailsModelClass(String bloodBankName, String address, String phone_number, String district, String city, String postalCode) {
        this.bloodBankName = bloodBankName;
        this.address = address;
        this.phone_number = phone_number;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
    }

    public BloodBankDetailsModelClass(String bloodBankName, String address, String phone_number, String district, String city, String postalCode, String username, String rePassword) {
        this.bloodBankName = bloodBankName;
        this.address = address;
        this.phone_number = phone_number;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.username = username;
        this.rePassword = rePassword;
    }

    public BloodBankDetailsModelClass(Integer id, String bloodBankName, String address, String phone_number, String district, String city, String postalCode, String username, String password, String rePassword) {
        this.id = id;
        this.bloodBankName = bloodBankName;
        this.address = address;
        this.phone_number = phone_number;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.username = username;
        this.rePassword = rePassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
