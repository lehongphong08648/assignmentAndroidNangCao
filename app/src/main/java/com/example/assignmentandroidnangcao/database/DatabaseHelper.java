package com.example.assignmentandroidnangcao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assignmentandroidnangcao.Dao.CaDao;
import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Dao.SinhVienDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "asbbbsignment12.db";
    private static final int VERSION = 2;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL((LopDao.CREATE_TABLE));
        db.execSQL(SinhVienDao.CREATE_TABLE);
        db.execSQL(CaDao.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
