package com.example.can.riwayatkeuangan.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.can.riwayatkeuangan.model.DataKeluar;

import java.util.ArrayList;
import java.util.List;

public class DBKeluar extends SQLiteOpenHelper {

    public static final String DB_NAME = "keluar.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_KELUAR = "transactions";
    public static final String COL_ID = "_id";
    public static final String COL_NAMA = "name";
    public static final String COL_JUMLAH = "amount";
    public static final String COL_DESKRIPSI = "description";

    public DBKeluar(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_KELUAR = "CREATE TABLE "
                + TABLE_KELUAR + "("
                + COL_ID + "INTEGER PRIMARY KEY,"
                + COL_NAMA + "TEXT,"
                + COL_JUMLAH + "TEXT,"
                + COL_DESKRIPSI + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_KELUAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KELUAR);
        onCreate(db);
    }

    public void insertKeluar(String nama,  int jumlah, String deskripsi){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAMA, nama);
        values.put(COL_JUMLAH, jumlah);
        values.put(COL_DESKRIPSI, deskripsi);
        db.insert(TABLE_KELUAR, null, values);

    }
    public List<DataKeluar> getKeluar(){
        SQLiteDatabase db = getReadableDatabase();
        List<DataKeluar> keluarList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+TABLE_KELUAR+
                " order by "+DataKeluar._ID, null);
        DataKeluar newTrans;
        try{
            while (cursor.moveToNext()){
                newTrans = new DataKeluar
                        (Long.toString(cursor.getLong(0)),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3));
                keluarList.add(newTrans);
            }
        } finally {
            cursor.close();
        }
        return keluarList;
    }

    public void deleteKeluar(DataKeluar dataKeluar){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_KELUAR, DataKeluar._ID+" = ?",
                new String[]{dataKeluar.getId_keluar()});
    }
}

