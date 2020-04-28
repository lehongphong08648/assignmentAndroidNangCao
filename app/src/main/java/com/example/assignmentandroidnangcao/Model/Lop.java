package com.example.assignmentandroidnangcao.Model;

import androidx.annotation.NonNull;

public class Lop {
    int id;
    String tenLop;
    String maLop;

    public Lop(String tenLop, String maLop) {
        this.tenLop = tenLop;
        this.maLop = maLop;
    }

    public Lop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @NonNull
    @Override
    public String toString() {
        return maLop + " | " + tenLop;
    }
}
