package com.example.assignmentandroidnangcao.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;
import com.example.assignmentandroidnangcao.ui.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private static final String TAG = "SinhVienDao";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String TABLE_NAME = "SinhVien";
    public static final String COLUMN_1 = "IdSV";
    private static final String COLUMN_2 = "MASV";
    private static final String COLUMN_3 = "TENSV";


    public static final String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME +" ( "
            + COLUMN_1 +" INTEGER AUTOGENERATE PRIMARY KEY, "
            + COLUMN_2 + "  Nvarchar(50), "
            + COLUMN_3 + "  Nvarchar(50) )";

    public SinhVienDao(Context mContext) {
        dbHelper = new DatabaseHelper(mContext);
    }

    public boolean themSinhVien(SinhVienModel sinhVien){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, sinhVien.getMaSv());
        values.put(COLUMN_3, sinhVien.getTenSv());
try{
        if (db.insert(TABLE_NAME,null,values) <= 0){
            db.close();
            return false;
        }
}catch (Exception e){
    Log.e(TAG, e.toString());
    db.close();
    return false;
}
return true;
    }

public boolean suaSinhVien(SinhVienModel sinhVien){
    db = dbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COLUMN_2, sinhVien.getMaSv());
    values.put(COLUMN_3, sinhVien.getTenSv());

    String WhereClause = COLUMN_1 +"?=";
    String[]whereArgs={String.valueOf(sinhVien.getId())};
    try{
        if (db.update(TABLE_NAME,values,WhereClause,whereArgs) <= 0){
            db.close();
            return false;
        }
    }catch (Exception e){
        Log.e(TAG, e.toString());
        db.close();
        return false;
    }
    return true;
}
public boolean xoaSinhVien(SinhVienModel sinhVien){
    db = dbHelper.getWritableDatabase();
    String WhereClause = COLUMN_1 +"=?";
    String[]whereArgs={String.valueOf(sinhVien.getId())};
    return db.delete(TABLE_NAME,WhereClause,whereArgs) > 0;
}

public List<SinhVienModel> truyXatSinhVien(){
        List<SinhVienModel> sinhVienModels = new ArrayList<>();
       db = dbHelper.getWritableDatabase();
       String truyXuat = "SELECT * FROM " + TABLE_NAME;
    Cursor cursor = db.rawQuery(truyXuat,null);
    cursor.moveToFirst();
       while (!cursor.isAfterLast()){
           SinhVienModel sinhVienModel = new SinhVienModel();
            sinhVienModel.setId(cursor.getInt(0));
           sinhVienModel.setMaSv(cursor.getString(1));
           sinhVienModel.setTenSv(cursor.getString(2));
           sinhVienModels.add(sinhVienModel);
           cursor.moveToNext();
       }
cursor.close();
       db.close();
       return sinhVienModels;
    }
}
