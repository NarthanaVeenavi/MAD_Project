package com.example.home;

public class DonorAccountModelClass {
    private int id;
    private String dName;
    private String dAddress;
    private String dEmail;
    private String dPassword;
    private String dDob;
    private String dBlood;
    private String dNic;

    public DonorAccountModelClass(int id, String dName, String dAddress, String dEmail, String dDob, String dBlood, String dNic) {
        this.id = id;
        this.dName = dName;
        this.dAddress = dAddress;
        this.dEmail = dEmail;
        this.dDob = dDob;
        this.dBlood = dBlood;
        this.dNic = dNic;
    }

    public DonorAccountModelClass(int id, String dName, String dAddress, String dEmail, String dPassword, String dDob, String dBlood, String dNic) {
        this.id = id;
        this.dName = dName;
        this.dAddress = dAddress;
        this.dEmail = dEmail;
        this.dPassword = dPassword;
        this.dDob = dDob;
        this.dBlood = dBlood;
        this.dNic = dNic;
    }

    public DonorAccountModelClass(String dName, String dAddress, String dEmail, String dPassword, String dDob, String dBlood, String dNic) {
        this.dName = dName;
        this.dAddress = dAddress;
        this.dEmail = dEmail;
        this.dPassword = dPassword;
        this.dDob = dDob;
        this.dBlood = dBlood;
        this.dNic = dNic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public String getdPassword() {
        return dPassword;
    }

    public void setdPassword(String dPassword) {
        this.dPassword = dPassword;
    }

    public String getdDob() {
        return dDob;
    }

    public void setdDob(String dDob) {
        this.dDob = dDob;
    }

    public String getdBlood() {
        return dBlood;
    }

    public void setdBlood(String dBlood) {
        this.dBlood = dBlood;
    }

    public String getdNic() {
        return dNic;
    }

    public void setdNic(String dNic) {
        this.dNic = dNic;
    }
}
