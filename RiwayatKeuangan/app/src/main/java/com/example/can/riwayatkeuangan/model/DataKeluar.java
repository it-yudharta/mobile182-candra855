package com.example.can.riwayatkeuangan.model;

import android.provider.BaseColumns;

import java.io.Serializable;

public class DataKeluar implements Serializable, BaseColumns {

    private String id_keluar;
    private String nama_keluar;
    private int jumlah_keluar;
    private String deskripsi_keluar;

    public DataKeluar(String id_keluar, String nama_keluar, int jumlah_keluar, String deskripsi_keluar) {
        this.id_keluar = id_keluar;
        this.nama_keluar = nama_keluar;
        this.jumlah_keluar = jumlah_keluar;
        this.deskripsi_keluar = deskripsi_keluar;
    }

    public String getId_keluar() { return id_keluar; }
    public void setId_keluar(String id_keluar) {
        this.id_keluar = id_keluar;
    }

    public String getNama_keluar() {
        return nama_keluar;
    }
    public void setNama_keluar(String nama_keluar) {
        this.nama_keluar = nama_keluar;
    }

    public int getJumlah_keluar() {
        return jumlah_keluar;
    }
    public void setJumlah_keluar(int jumlah_keluar) {
        this.jumlah_keluar = jumlah_keluar;
    }

    public String getDeskripsi_keluar() {
        return deskripsi_keluar;
    }
    public void setDeskripsi_keluar(String deskripsi_keluar) {
        this.deskripsi_keluar = deskripsi_keluar;
    }

    public String toString() {

        return "+  " + this.nama_keluar +" \n "+ "   Rp. " + this.jumlah_keluar;
    }

}

