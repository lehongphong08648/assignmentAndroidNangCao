package com.example.assignmentandroidnangcao.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class LopDao {

    private static final String TAG = "SinhVienDao";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private static final String TABLE_NAME = "LOP";
    private static final String COLUMN_1 = "IdLOP";
    private static final String COLUMN_2 = "MALOP";
    private static final String COLUMN_3 = "TENLOP";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_1 + " INTEGER AUTOGENERATE PRIMARY KEY, "
            + COLUMN_2 + " Nvarchar(50), "
            + COLUMN_3 + " Nvarchar(50))";

    public LopDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean themLop(Lop lop) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, lop.getMaLop());
        values.put(COLUMN_3, lop.getTenLop());
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

    public boolean suaSinhVien(Lop lop) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_1, lop.getId());
        values.put(COLUMN_2, lop.getMaLop());
        values.put(COLUMN_3, lop.getTenLop());

        String WhereClause = COLUMN_1 + "=?";
        String[] whereArgs = {String.valueOf(lop.getId())};
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

    public boolean xoaSinhVien(Lop lop) {
        db = dbHelper.getWritableDatabase();
        String WhereClause = COLUMN_1 + "=?";
        String[] whereArgs = {String.valueOf(lop.getId())};
        return db.delete(TABLE_NAME, WhereClause, whereArgs) > 0;
    }

    public List<Lop> truyXatLop() {
        List<Lop> lops = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        String truyXuat = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(truyXuat, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Lop lop = new Lop();
            lop.setId(cursor.getInt(0));
            lop.setMaLop(String.valueOf(cursor.getString(1)));
            lop.setTenLop(String.valueOf(cursor.getString(2)));
            lops.add(lop);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return lops;
    }

}
