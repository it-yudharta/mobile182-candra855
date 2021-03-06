package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.can.riwayatkeuangan.Helper.DBMasuk;
import com.example.can.riwayatkeuangan.model.DataMasuk;

public class LihatPemasukan extends AppCompatActivity {
    private DataMasuk dataMasuk;
    private TextView txt_Nama;
    private TextView txt_Jumlah;
    private TextView txt_Deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pemasukan);
        this.setTitle("Detail Pemasukan");

        txt_Nama = (TextView) findViewById(R.id.txt_nama);
        txt_Jumlah = (TextView) findViewById(R.id.txt_jumlah);
        txt_Deskripsi = (TextView) findViewById(R.id.txt_deskripsi);

        Intent intent = getIntent();
        dataMasuk = (DataMasuk) intent.getSerializableExtra("trMasuk.detail");

        txt_Nama.setText(dataMasuk.getNama_masuk());
        txt_Jumlah.setText("Rp. " + Integer.toString(dataMasuk.getJumlah_masuk()));
        txt_Deskripsi.setText(dataMasuk.getDeskripsi_masuk());

    }

    public void delMasuk(View view){
        DBMasuk dbMasuk = new DBMasuk(this);
        dbMasuk.deleteMasuk(dataMasuk);
        Toast.makeText(this, "Transaksi berhasil dihapus !", Toast.LENGTH_SHORT).show();
        finish();
    }
}

