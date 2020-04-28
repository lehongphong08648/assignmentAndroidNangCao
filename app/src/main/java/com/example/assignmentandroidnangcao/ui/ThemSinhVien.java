package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Dao.SinhVienDao;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ThemSinhVien extends AppCompatActivity {
EditText edt_maSv, edt_tenSv;

    DatabaseHelper dbHelper;
    SinhVienDao sinhVienDao;
    LopDao lopDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);

        dbHelper = new DatabaseHelper(this);
        lopDao = new LopDao(this);

        edt_maSv = findViewById(R.id.edt_maSv);
        edt_tenSv = findViewById(R.id.edt_tenSv);



    }

    public void huyThemSv(View view) {

        startActivity( new Intent(ThemSinhVien.this,SinhVien.class));
    }

    public void ThemSv(View view) {
        String maSv = edt_maSv.getText().toString();
        String tenSv = edt_tenSv.getText().toString();

        if (maSv.isEmpty()){
            edt_maSv.setError("Trống mã sinh viên");
        }if (tenSv.isEmpty()){
            edt_tenSv.setError("Trống tên sinh viên");
        }else {
            SinhVienModel sinhVienModel = new SinhVienModel(maSv, tenSv);
            sinhVienDao = new SinhVienDao(this);
            sinhVienDao.themSinhVien(sinhVienModel);
            Toast.makeText(this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
            edt_tenSv.setText("");
            edt_maSv.setText("");
        }
    }
}
