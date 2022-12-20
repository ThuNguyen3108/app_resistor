package com.example.introduce.thamkhao;

public class LinhKien {
    private  int id;
    private String img;
    private  String ten;
    private  String gtri;
    private  String th;
    private   String ctiet;

    public LinhKien(int id, String img, String ten, String gtri, String th, String ctiet) {
        this.id = id;
        this.img = img;
        this.ten = ten;
        this.gtri = gtri;
        this.th = th;
        this.ctiet = ctiet;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGtri() {
        return gtri;
    }

    public void setGtri(String gtri) {
        this.gtri = gtri;
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
