package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

public class ThemLop extends AppCompatActivity {
EditText edt_maLop, edt_tenLop;
DatabaseHelper dbHelper;
LopDao lopDao;
Lop lop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);
        edt_maLop = findViewById(R.id.edt_maLop);
        edt_tenLop = findViewById(R.id.edt_tenLop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void ThemLop(View view) {
        String tenLop = edt_tenLop.getText().toString();
        String maLop = edt_maLop.getText().toString();
        if (maLop.isEmpty() || maLop.length() != 6) {
            edt_maLop.setError("Trống mã sinh viên hoặc ma sinh viên nhỏ hơn 6 kí tự");
        }
        if (tenLop.isEmpty() || tenLop.length() > 20 || tenLop.length() < 5) {
            edt_tenLop.setError("Trống tên sinh viên hoặc tên sinh viên vượt quá 20 kí tự");
        } else {
            dbHelper = new DatabaseHelper(this);
            lopDao = new LopDao(this);
            lop = new Lop(tenLop, maLop);
            lopDao.themLop(lop);
            Toast.makeText(this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();

            edt_maLop.setText("");
            edt_tenLop.setText("");
        }
    }
    public void huyThemLop(View view) {
        startActivity( new Intent(ThemLop.this,SinhVien.class));
    }


}
