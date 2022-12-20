package com.example.introduce.screenCamera;

public class Resistor {
    private int id;
    private byte[] img;
    private String vach1;
    private String vach2;
    private String vach3;
    private String vach4;
    private String gtri;
    private int id_user;

    public Resistor(int id, byte[] img, String vach1, String vach2, String vach3, String vach4, String gtri, int id_user) {
        this.id = id;
        this.img = img;
        this.vach1 = vach1;
        this.vach2 = vach2;
        this.vach3 = vach3;
        this.vach4 = vach4;
        this.gtri = gtri;
        this.id_user = id_user;
    }

    public Resistor(byte[] img, String vach1, String vach2, String vach3, String vach4, String gtri, int id_user) {
        this.img = img;
        this.vach1 = vach1;
        this.vach2 = vach2;
        this.vach3 = vach3;
        this.vach4 = vach4;
        this.gtri = gtri;
        this.id_user = id_user;
    }

    public Resistor() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getVach1() {
        return vach1;
    }

    public void setVach1(String vach1) {
        this.vach1 = vach1;
    }

    public String getVach2() {
        return vach2;
    }

    public void setVach2(String vach2) {
        this.vach2 = vach2;
    }

    public String getVach3() {
        return vach3;
    }

    public void setVach3(String vach3) {
        this.vach3 = vach3;
    }

    public String getVach4() {
        return vach4;
    }

    public void setVach4(String vach4) {
        this.vach4 = vach4;
    }

    public String getGtri() {
        return gtri;
    }

    public void setGtri(String gtri) {
        this.gtri = gtri;
    }
}
