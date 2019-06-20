package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.can.riwayatkeuangan.Helper.DBHelper;
import com.example.can.riwayatkeuangan.model.DataMasuk;

public class LihatPemasukan extends AppCompatActivity {
    private DataMasuk trMasuk;
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
        trMasuk = (DataMasuk) intent.getSerializableExtra("transaction.detail");

        txt_Nama.setText(trMasuk.getNama());
        txt_Jumlah.setText(Integer.toString(trMasuk.getJumlah()));
        txt_Deskripsi.setText(trMasuk.getDeskripsi());

    }

    public void hapusMasuk(View view){
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.deletePemasukan(trMasuk);
        Toast.makeText(this, "Transaksi dihapus !", Toast.LENGTH_SHORT).show();
        finish();
    }
}

