package com.example.home;

public class HealthCardModelClass {

    Integer id;
    String date;
    String venue;
    String health;
    String title;
    String description;

    public HealthCardModelClass(Integer id, String date, String venue, String health, String title, String description) {
        this.id = id;
        this.date = date;
        this.venue = venue;
        this.health = health;
        this.title = title;
        this.description = description;

    }

    public HealthCardModelClass(String date, String venue, String health, String title, String description) {
        this.date = date;
        this.venue = venue;
        this.health = health;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
