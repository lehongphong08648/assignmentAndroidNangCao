package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignmentandroidnangcao.Dao.CaDao;
import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Dao.SinhVienDao;
import com.example.assignmentandroidnangcao.Model.CaHoc;
import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ThemCaHoc extends AppCompatActivity {
AppCompatSpinner sp_lop_ca, sp_Sv_ca, sp_caHoc;

DatabaseHelper dbHelper;
LopDao lopDao;
SinhVienDao sinhVienDao;

List<Lop> lops;
List<SinhVienModel> sinhViens;
List<CaHoc> caHocs;
CaModel caModel;
CaDao caDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ca_hoc);
        dbHelper = new DatabaseHelper(this);
        lopDao = new LopDao(this);
        sinhVienDao = new SinhVienDao(this);
        caDao = new CaDao(this);
        sinhViens = new ArrayList<>();
        lops = new ArrayList<>();
        caHoc();

        sp_lop_ca = findViewById(R.id.sp_lop_ca);
        sp_Sv_ca = findViewById(R.id.sp_Sv_ca);
        sp_caHoc = findViewById(R.id.sp_ca);

        lops = lopDao.truyXatLop();
        ArrayAdapter<Lop> lopArrayAdapter = new ArrayAdapter<>(ThemCaHoc.this,android.R.layout.simple_spinner_item,lops);
        lopArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_lop_ca.setAdapter(lopArrayAdapter);

        sinhViens = sinhVienDao.truyXatSinhVien();
        ArrayAdapter<SinhVienModel> vienModelArrayAdapter = new ArrayAdapter<>(ThemCaHoc.this,android.R.layout.simple_spinner_item,sinhViens);
        lopArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Sv_ca.setAdapter(vienModelArrayAdapter);

        ArrayAdapter<CaHoc> caHocArrayAdapter = new ArrayAdapter<>(ThemCaHoc.this,android.R.layout.simple_spinner_item,caHocs);
        lopArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_caHoc.setAdapter(caHocArrayAdapter);

    }

    public void ThemCa(View view) {
        Lop lop = (Lop) sp_lop_ca.getSelectedItem();
        SinhVienModel sinhVienModel = (SinhVienModel) sp_Sv_ca.getSelectedItem();
        CaHoc caHoc = (CaHoc) sp_caHoc.getSelectedItem();

        int idLop = lop.getId();
        int idSv = sinhVienModel.getId();
        String ScaHoc = caHoc.getCa();

        List<CaModel> caModels1 = caDao.truyXuatCa();
        if (caModels1 != null) {
//            int caModels = caDao.kiemTraCaHoc(idSv,ScaHoc);
//            if (caModels == 1) {
//                caModel = new CaModel(idLop, idSv, ScaHoc);
//                caDao.ThemCa(caModel);
//                Toast.makeText(this, "Thêm ca thành công", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ThemCaHoc.this, SinhVien.class));
            caModel = new CaModel(idLop, idSv, ScaHoc);
            caDao.ThemCa(caModel);
            Toast.makeText(this, "Thêm ca thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ThemCaHoc.this, SinhVien.class));
//            }
        }else {
            caModel = new CaModel(idLop, idSv, ScaHoc);
            caDao.ThemCa(caModel);
            Toast.makeText(this, "Thêm ca thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ThemCaHoc.this, SinhVien.class));
        }
    }

    public void huyCa(View view) {
        startActivity( new Intent(ThemCaHoc.this,SinhVien.class));
    }
    public void caHoc(){
        caHocs = new ArrayList<>();
        CaHoc caHoc = new CaHoc("Ca1");CaHoc caHoc1 = new CaHoc("Ca2");CaHoc caHoc2 = new CaHoc("Ca3");CaHoc caHoc3 = new CaHoc("Ca4");CaHoc caHoc4 = new CaHoc("Ca5");CaHoc caHoc5 = new CaHoc("Ca6");
        caHocs.add(caHoc);caHocs.add(caHoc1);caHocs.add(caHoc2);caHocs.add(caHoc3);caHocs.add(caHoc4);caHocs.add(caHoc5);

    }
}
