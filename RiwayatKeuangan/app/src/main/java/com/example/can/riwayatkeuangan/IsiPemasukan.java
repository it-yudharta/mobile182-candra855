package com.example.can.riwayatkeuangan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.can.riwayatkeuangan.Helper.DBMasuk;

public class IsiPemasukan extends AppCompatActivity {

    EditText edt_Nama;
    EditText edt_Jumlah;
    EditText edt_Deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_pemasukan);
        this.setTitle("Tambah Pemasukan");

        edt_Nama = (EditText) findViewById(R.id.edt_nama_masuk);
        edt_Jumlah = (EditText) findViewById(R.id.edt_jumlah_masuk);
        edt_Deskripsi = (EditText) findViewById(R.id.edt_deskripsi_masuk);
    }

    public void Tambah(View view) {
        String nama = edt_Nama.getText().toString();
        int jumlah = Integer.parseInt(edt_Jumlah.getText().toString());
        String deskripsi = edt_Deskripsi.getText().toString();

        if (edt_Nama.getText().toString().isEmpty()) {
            //jika input masih kosong
            Toast.makeText(this, "Masukkan nama !", Toast.LENGTH_SHORT).show();
        } else if (edt_Jumlah.getText().toString().isEmpty()) {
            //jika input masih kosong
            Toast.makeText(this, "Masukkan jumlah !", Toast.LENGTH_SHORT).show();
        } else if (edt_Jumlah.getText().toString().trim().equals("0")) {
            Toast.makeText(this, "Jumlah tidak valid !", Toast.LENGTH_SHORT).show();

        } else {

            DBMasuk dbMasuk = new DBMasuk(this);
            dbMasuk.insertMasuk(nama, jumlah, deskripsi);
            Toast.makeText(this, "Transaksi " + nama + " berhasil disimpan !", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}




