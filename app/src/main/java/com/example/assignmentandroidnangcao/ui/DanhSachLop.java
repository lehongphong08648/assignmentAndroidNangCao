package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignmentandroidnangcao.Adapter.LopAdapter;
import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.List;

public class DanhSachLop extends AppCompatActivity {
RecyclerView lv_lop;
LopAdapter lopAdapter;
DatabaseHelper dbHelper;
LopDao lopDao;
List<Lop> lops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        dbHelper = new DatabaseHelper(this);
        lopDao = new LopDao(this);
        lops = lopDao.truyXatLop();

        lopAdapter = new LopAdapter(DanhSachLop.this,lops);

        lv_lop = findViewById(R.id.lv_lop);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        lv_lop.setAdapter(lopAdapter);
        lv_lop.setLayoutManager(layoutManager);

    }
}
