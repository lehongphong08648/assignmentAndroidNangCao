package com.example.assignmentandroidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.assignmentandroidnangcao.ui.BangTin;
import com.example.assignmentandroidnangcao.ui.DiaChi;
import com.example.assignmentandroidnangcao.ui.MangXaHoi;
import com.example.assignmentandroidnangcao.ui.SinhVien;

public class MainActivity extends AppCompatActivity {
LinearLayout sinhVien, bangTin, diaChi, mangXaHoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sinhVien = findViewById(R.id.sinhVien);
        bangTin = findViewById(R.id.bangTin);
        diaChi = findViewById(R.id.diaChi);
        mangXaHoi = findViewById(R.id.mangXaHoi);

        sinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SinhVien.class));
            }
        });

        bangTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BangTin.class));
            }
        });

        diaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DiaChi.class));
            }
        });

        mangXaHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MangXaHoi.class));
            }
        });
    }
}
