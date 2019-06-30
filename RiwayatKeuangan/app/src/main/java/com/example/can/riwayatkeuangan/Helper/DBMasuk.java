package com.example.can.riwayatkeuangan.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.ArrayList;
import java.util.List;

public class DBMasuk extends SQLiteOpenHelper {

    public static final String DB_NAME = "masuk.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_MASUK = "transactions";
    public static final String COL_ID = "_id";
    public static final String COL_NAMA = "name";
    public static final String COL_JUMLAH = "amount";
    public static final String COL_DESKRIPSI = "description";

    public DBMasuk(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MASUK = "CREATE TABLE "
                + TABLE_MASUK + "("
                + COL_ID + "INTEGER PRIMARY KEY,"
                + COL_NAMA + "TEXT,"
                + COL_JUMLAH + "TEXT,"
                + COL_DESKRIPSI + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_MASUK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MASUK);
        onCreate(db);
    }

    public void insertMasuk(String nama,  int jumlah, String deskripsi){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAMA, nama);
        values.put(COL_JUMLAH, jumlah);
        values.put(COL_DESKRIPSI, deskripsi);
        db.insert(TABLE_MASUK, null, values);

    }
    public List<DataMasuk> getMasuk(){
        SQLiteDatabase db = getReadableDatabase();
        List<DataMasuk> masukList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+TABLE_MASUK+
                " order by "+DataMasuk._ID, null);
        DataMasuk newTrans;
        try{
            while (cursor.moveToNext()){
                newTrans = new DataMasuk
                        (Long.toString(cursor.getLong(0)),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3));
                masukList.add(newTrans);
            }
        } finally {
            cursor.close();
        }
        return masukList;
    }

    public void deleteMasuk(DataMasuk dataMasuk){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_MASUK, DataMasuk._ID+" = ?",
                new String[]{dataMasuk.getId_masuk()});
    }
}

