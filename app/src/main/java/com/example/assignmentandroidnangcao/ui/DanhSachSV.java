package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignmentandroidnangcao.Adapter.LopAdapter;
import com.example.assignmentandroidnangcao.Adapter.SinhVienAdapter;
import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Dao.SinhVienDao;
import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.List;

public class DanhSachSV extends AppCompatActivity {
List<SinhVienModel> sinhViens;
DatabaseHelper dbHelper;
SinhVienDao sinhVienDao;
SinhVienAdapter sinhVienAdapter;
RecyclerView lv_dsSv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_s_v);
        dbHelper = new DatabaseHelper(this);

        lv_dsSv = findViewById(R.id.lv_dsSv);

        sinhVienDao = new SinhVienDao(this);
        sinhViens = sinhVienDao.truyXatSinhVien();

        sinhVienAdapter = new SinhVienAdapter(DanhSachSV.this,sinhViens);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        lv_dsSv.setAdapter(sinhVienAdapter);
        lv_dsSv.setLayoutManager(layoutManager);
    }
}
