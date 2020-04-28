package com.example.assignmentandroidnangcao.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CaDao {

    private static final String TAG = "CaDao";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private static final String TABLE_NAME = "CACHOC";
    private static final String COLUMN_1 = "IdCa";
    private static final String COLUMN_2 = "IdLop";
    private static final String COLUMN_3 = "IdSv";
    private static final String COLUMN_4 = "CaHoc";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_1 + " INTEGER AUTOGENERATE PRIMARY KEY, "
            + COLUMN_2 + " INTEGER , "
            + COLUMN_3 + " INTEGER , "
            +COLUMN_4 + " Nvarchar(50) ) ";

    public CaDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }
    public boolean ThemCa(CaModel caModel) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, caModel.getIdLop());
        values.put(COLUMN_3, caModel.getIdSv());
        values.put(COLUMN_4, caModel.getCa());
        try {
            if (db.insert(TABLE_NAME, null, values) <= 0) {
                db.close();
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            db.close();
            return false;
        }
        return true;
    }

    public boolean suaCa(CaModel caModel) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_1, caModel.getIdCa());
        values.put(COLUMN_2, caModel.getIdLop());
        values.put(COLUMN_3, caModel.getIdSv());
        values.put(COLUMN_4, caModel.getCa());

        String WhereClause = COLUMN_1 + "?=";
        String[] whereArgs = {String.valueOf(caModel.getIdCa())};
        try {
            if (db.update(TABLE_NAME, values, WhereClause, whereArgs) <= 0) {
                db.close();
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            db.close();
            return false;
        }
        return true;
    }

    public boolean xoaCa(CaModel caModel) {
        db = dbHelper.getWritableDatabase();
        String WhereClause = COLUMN_1 + "=?";
        String[] whereArgs = {String.valueOf(caModel.getIdCa())};
        return db.delete(TABLE_NAME, WhereClause, whereArgs) > 0;
    }

    public List<CaModel> truyXuatCa() {
        List<CaModel> caModels = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        String truyXuat = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(truyXuat, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            CaModel caModel = new CaModel();
            caModel.setIdCa(cursor.getInt(0));
            caModel.setIdLop(cursor.getInt(1));
            caModel.setIdSv(cursor.getInt(2));
            caModel.setCa(cursor.getString(3));
            caModels.add(caModel);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return caModels;
    }

    public int kiemTraCaHoc(int idSv,String caHoc){
        List<CaModel> caModels = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME
                + " INNER JOIN SinhVien ON SinhVien.IdSV = CACHOC.IdSV " +
                " WHERE IdSV = " + idSv +" AND CaHoc = " +caHoc ;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            CaModel caModel = new CaModel();
            caModel.setIdCa(cursor.getInt(0));
            caModel.setIdLop(cursor.getInt(1));
            caModel.setIdSv(cursor.getInt(2));
            caModel.setCa(cursor.getString(3));
            caModels.add(caModel);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        if (caModels.size() <= 0){
            return 1;
        }
        return -1;
    }
}
