package com.example.home;

public class OrganizationModelClass {
    Integer id1;
    String orgname;
    String address;
    String phonenumber;
    String district;
    String city;
    String postalcode;
    String username;
    String password;

    public OrganizationModelClass(String orgname, String address, String phonenumber, String district, String city, String postalcode, String username, String password) {
        this.orgname = orgname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.district = district;
        this.city = city;
        this.postalcode = postalcode;
        this.username = username;
        this.password = password;
    }

    public OrganizationModelClass(Integer id1, String orgname, String address, String phonenumber, String district, String city, String postalcode, String username, String password) {
        this.id1 = id1;
        this.orgname = orgname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.district = district;
        this.city = city;
        this.postalcode = postalcode;
        this.username = username;
        this.password = password;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
