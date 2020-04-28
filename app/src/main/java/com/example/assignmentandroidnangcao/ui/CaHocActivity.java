package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignmentandroidnangcao.Adapter.CaAdapter;
import com.example.assignmentandroidnangcao.Dao.CaDao;
import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CaHocActivity extends AppCompatActivity {
List<CaModel> caModels;
CaDao caDao;
RecyclerView lv_ca;
DatabaseHelper dbHelper;
CaAdapter caAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_hoc);
        dbHelper = new DatabaseHelper(this);
        caDao = new CaDao(this);

        lv_ca = findViewById(R.id.lvCa);
        caModels = new ArrayList<>();
        caModels = caDao.truyXuatCa();

        caAdapter = new CaAdapter(this,caModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        lv_ca.setAdapter(caAdapter);
        lv_ca.setLayoutManager(layoutManager);
    }
}
