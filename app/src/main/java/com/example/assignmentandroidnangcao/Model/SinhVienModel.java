package com.example.assignmentandroidnangcao.Model;

import androidx.annotation.NonNull;

public class SinhVienModel {
    int id;
    String maSv;
    String tenSv;

    public SinhVienModel() {
    }

    public SinhVienModel(String maSv, String tenSv) {
        this.maSv = maSv;
        this.tenSv = tenSv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    @NonNull
    @Override
    public String toString() {
        return maSv + " | " + tenSv;
    }
}
