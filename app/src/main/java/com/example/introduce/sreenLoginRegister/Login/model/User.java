package com.example.introduce.sreenLoginRegister.Login.model;

public class User {
    private String hoten, taikhoan, email, sdt, matkhau;
    private int id;

    public User(String hoten, String taikhoan, String email, String sdt, String matkhau, int id) {
        this.hoten = hoten;
        this.taikhoan = taikhoan;
        this.email = email;
        this.sdt = sdt;
        this.matkhau = matkhau;
        this.id = id;
    }

    public User(String hoten, String taikhoan, String email, String sdt, String matkhau) {
        this.hoten = hoten;
        this.taikhoan = taikhoan;
        this.email = email;
        this.sdt = sdt;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {

    }

    public String getHoten() {
        return hoten;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
