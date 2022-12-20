package com.example.introduce.thamkhao;

public class MachDien {
    private int id;
    private String img;
    private  String ten;
    private  String th;
    private   String ctiet;

    public MachDien(int id, String img, String ten, String th, String ctiet) {
        this.id = id;
        this.img = img;
        this.ten = ten;
        this.th = th;
        this.ctiet = ctiet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getCtiet() {
        return ctiet;
    }

    public void setCtiet(String ctiet) {
        this.ctiet = ctiet;
    }

}
