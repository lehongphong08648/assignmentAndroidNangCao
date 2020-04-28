package com.example.assignmentandroidnangcao.Model;

public class CaModel {
    int idCa;
    int idLop;
    int idSv;
    String ca;

    public CaModel(int idLop, int idSv, String ca) {
        this.idLop = idLop;
        this.idSv = idSv;
        this.ca = ca;
    }

    public CaModel() {
    }

    public int getIdCa() {
        return idCa;
    }

    public void setIdCa(int idCa) {
        this.idCa = idCa;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }
}
