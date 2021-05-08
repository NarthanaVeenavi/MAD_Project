package com.example.home;

public class BloodTestsModelClass {

    Integer id;
    String hos_name;
    String date;
    String time;
    String phone;
    String blood_tests;

    public BloodTestsModelClass(Integer id, String hos_name, String date, String time, String phone, String blood_tests) {
        this.id = id;
        this.hos_name = hos_name;
        this.date = date;
        this.time = time;
        this.phone = phone;
        this.blood_tests = blood_tests;
    }

    public BloodTestsModelClass(String hos_name, String date, String time, String phone, String blood_tests) {
        this.hos_name = hos_name;
        this.date = date;
        this.time = time;
        this.phone = phone;
        this.blood_tests = blood_tests;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHos_name() {
        return hos_name;
    }

    public void setHos_name(String hos_name) {
        this.hos_name = hos_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood_tests() {
        return blood_tests;
    }

    public void setBlood_tests(String blood_tests) {
        this.blood_tests = blood_tests;
    }
}
