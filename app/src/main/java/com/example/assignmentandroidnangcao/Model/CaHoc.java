package com.example.assignmentandroidnangcao.Model;

import androidx.annotation.NonNull;

public class CaHoc {
    String ca;

    public CaHoc(String ca) {
        this.ca = ca;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    @NonNull
    @Override
    public String toString() {
        return ca;
    }
}
