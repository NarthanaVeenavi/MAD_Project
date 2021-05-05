package com.example.home;

public class EmergencyNoticesModelClass {

    Integer id;
    String hos_name;
    String Phone_num;
    String description;

    public EmergencyNoticesModelClass(String hos_name, String phone_num, String description) {
        this.hos_name = hos_name;
        Phone_num = phone_num;
        this.description = description;
    }

    public EmergencyNoticesModelClass(Integer id, String hos_name, String phone_num, String description) {
        this.id = id;
        this.hos_name = hos_name;
        Phone_num = phone_num;
        this.description = description;
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

    public String getPhone_num() {
        return Phone_num;
    }

    public void setPhone_num(String phone_num) {
        Phone_num = phone_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
