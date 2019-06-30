package com.example.can.riwayatkeuangan.model;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.Serializable;

public class DataMasuk implements Serializable, BaseColumns {

    private String id_masuk;
    private String nama_masuk;
    private int jumlah_masuk;
    private String deskripsi_masuk;

    public DataMasuk(String id_masuk, String nama_masuk, int jumlah_masuk, String deskripsi_masuk) {
        this.id_masuk = id_masuk;
        this.nama_masuk = nama_masuk;
        this.jumlah_masuk = jumlah_masuk;
        this.deskripsi_masuk = deskripsi_masuk;
    }

    public String getId_masuk() {
        return id_masuk;
    }
    public void setId_masuk(String id_masuk) {
        this.id_masuk = id_masuk;
    }

    public String getNama_masuk() {
        return nama_masuk;
    }
    public void setNama_masuk(String nama_masuk) {
        this.nama_masuk = nama_masuk;
    }

    public int getJumlah_masuk() {
        return jumlah_masuk;
    }
    public void setJumlah_masuk(int jumlah_masuk) {
        this.jumlah_masuk = jumlah_masuk;
    }

    public String getDeskripsi_masuk() {
        return deskripsi_masuk;
    }
    public void setDeskripsi_masuk(String deskripsi_masuk) {
        this.deskripsi_masuk = deskripsi_masuk;
    }

    public String toString() {

        return "+  " + this.nama_masuk +" \n "+ "   Rp. " + this.jumlah_masuk;
    }

}
