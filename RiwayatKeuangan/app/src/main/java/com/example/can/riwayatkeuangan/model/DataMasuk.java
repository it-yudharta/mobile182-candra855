package com.example.can.riwayatkeuangan.model;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.Serializable;

public class DataMasuk implements Serializable, BaseColumns {

    private String id;
    private String nama;
    private int jumlah;
    private String deskripsi;


    public DataMasuk(String id, String nama, int jumlah, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String toString() {

        return "+  " + this.nama +" \n "+ "   Rp. " + this.jumlah;
    }

}
