package com.example.home;

public class RequestModelClass {
    Integer id;
    String bld;
    String typ;
    String name;
    String phne;
    String det;

    public RequestModelClass(String bld, String typ, String name, String phne, String det) {
        this.bld = bld;
        this.typ = typ;
        this.name = name;
        this.phne = phne;
        this.det = det;
    }


    public RequestModelClass(Integer id, String bld, String typ, String name, String phne, String det) {
        this.id = id;
        this.bld = bld;
        this.typ = typ;
        this.name = name;
        this.phne = phne;
        this.det = det;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBld() {
        return bld;
    }

    public void setBld(String bld) {
        this.bld = bld;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhne() {
        return phne;
    }

    public void setPhne(String phne) {
        this.phne = phne;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }
}
