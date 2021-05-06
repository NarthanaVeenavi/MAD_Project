package com.example.home;

public class CampModelClass {
    Integer id;
    String name;
    String phone;
    String date;
    String time;
    String venue;
    String description;

    public CampModelClass(String name, String phone, String date, String time, String venue, String description)
    {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.description = description;
    }

    public CampModelClass(Integer id, String name, String phone, String date, String time, String venue, String description)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

