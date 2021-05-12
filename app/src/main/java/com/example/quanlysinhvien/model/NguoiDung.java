package com.example.quanlysinhvien.model;

public class NguoiDung {
    private String hoten;
    private String lop;
    private String noisinh;
    private String phone;

    public NguoiDung() {
    }

    public NguoiDung(String hoten, String lop, String noisinh, String phone) {
        this.hoten = hoten;
        this.lop = lop;
        this.noisinh = noisinh;
        this.phone = phone;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "hoTen='" + hoten + '\'' +
                ", lop='" + lop + '\'' +
                ", noisinh='" + noisinh + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
