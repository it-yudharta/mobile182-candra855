package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.can.riwayatkeuangan.Helper.DBKeluar;
import com.example.can.riwayatkeuangan.Helper.DBMasuk;
import com.example.can.riwayatkeuangan.model.DataKeluar;
import com.example.can.riwayatkeuangan.model.DataMasuk;

public class LihatPengeluaran extends AppCompatActivity {
    private DataKeluar dataKeluar;
    private TextView txt_Nama;
    private TextView txt_Jumlah;
    private TextView txt_Deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pengeluaran);
        this.setTitle("Detail Pengeluaran");

        txt_Nama = (TextView) findViewById(R.id.txt_nama);
        txt_Jumlah = (TextView) findViewById(R.id.txt_jumlah);
        txt_Deskripsi = (TextView) findViewById(R.id.txt_deskripsi);

        Intent intent = getIntent();
        dataKeluar = (DataKeluar) intent.getSerializableExtra("trKeluar.detail");

        txt_Nama.setText(dataKeluar.getNama_keluar());
        txt_Jumlah.setText("Rp. " + Integer.toString(dataKeluar.getJumlah_keluar()));
        txt_Deskripsi.setText(dataKeluar.getDeskripsi_keluar());

    }

    public void delKeluar(View view){
        DBKeluar dbKeluar = new DBKeluar(this);
        dbKeluar.deleteKeluar(dataKeluar);
        Toast.makeText(this, "Transaksi berhasil dihapus !", Toast.LENGTH_SHORT).show();
        finish();
    }
}