package com.example.can.riwayatkeuangan.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.can.riwayatkeuangan.model.DataKeluar;
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "keuangan.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_MASUK = "transactions";
    public static final String COL_ID_M = "_id";
    public static final String COL_NAMA_M = "name";
    public static final String COL_JUMLAH_M = "amount";
    public static final String COL_DESKRIPSI_M = "description";


    public static final String TABLE_KELUAR = "transactions";
    public static final String COL_ID_K = "_id";
    public static final String COL_NAMA_K = "name";
    public static final String COL_JUMLAH_K = "amount";
    public static final String COL_DESKRIPSI_K = "description";

    public DBHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MASUK = "CREATE TABLE "
                + TABLE_MASUK + "("
                + COL_ID_M + "INTEGER PRIMARY KEY,"
                + COL_NAMA_M + "TEXT,"
                + COL_JUMLAH_M + "TEXT,"
                + COL_DESKRIPSI_M + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_MASUK);

        String CREATE_TABLE_KELUAR = "CREATE TABLE "
                + TABLE_KELUAR + "("
                + COL_ID_K + "INTEGER PRIMARY KEY,"
                + COL_NAMA_K + "TEXT,"
                + COL_JUMLAH_K + "TEXT,"
                + COL_DESKRIPSI_K + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_KELUAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MASUK);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KELUAR);
        onCreate(db);
    }

    public void insertPemasukan(String nama,  int jumlah, String deskripsi){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAMA_M, nama);
        values.put(COL_JUMLAH_M, jumlah);
        values.put(COL_DESKRIPSI_M, deskripsi);
        db.insert(TABLE_MASUK, null, values);
    }

    public void insertPengeluaran(String nama,  int jumlah, String deskripsi){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAMA_K, nama);
        values.put(COL_JUMLAH_K, jumlah);
        values.put(COL_DESKRIPSI_K, deskripsi);
        db.insert(TABLE_KELUAR, null, values);
    }


    public List<DataMasuk> getListMasuk(){
        SQLiteDatabase db = getReadableDatabase();
        List<DataMasuk> listMasuk = new ArrayList<>();
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
                listMasuk.add(newTrans);
            }
        } finally {
            cursor.close();
        }
        return listMasuk;
    }

    public List<DataKeluar> getListKeluar(){
        SQLiteDatabase db = getReadableDatabase();
        List<DataKeluar> listKeluar = new ArrayList<>();
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
                listKeluar.add(newTrans);
            }
        } finally {
            cursor.close();
        }
        return listKeluar;
    }


    public void deletePemasukan(DataMasuk trMasuk){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_MASUK, DataMasuk._ID+" = ?",
                new String[]{trMasuk.getId()});
    }

    public void deletePengeluaran(DataKeluar trKeluar){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_KELUAR, DataKeluar._ID+" = ?",
                new String[]{trKeluar.getId()});
    }
}

