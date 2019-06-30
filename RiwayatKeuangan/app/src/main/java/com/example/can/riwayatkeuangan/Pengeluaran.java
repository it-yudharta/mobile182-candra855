package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.can.riwayatkeuangan.Helper.DBKeluar;
import com.example.can.riwayatkeuangan.Helper.DBMasuk;
import com.example.can.riwayatkeuangan.adapter.CostumListKeluar;
import com.example.can.riwayatkeuangan.adapter.CostumListMasuk;
import com.example.can.riwayatkeuangan.model.DataKeluar;
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.ArrayList;
import java.util.List;

public class Pengeluaran extends AppCompatActivity {

    private List<DataKeluar> listKeluar = new ArrayList<DataKeluar>();
    private CostumListKeluar adapter;
    private ListView listView;
    private DBMasuk db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DBMasuk(this);

        listView = findViewById(R.id.list_keluar);

        adapter = new CostumListKeluar(this, listKeluar);
        listView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();

                Intent intent = new Intent(Pengeluaran.this, IsiPengeluaran.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),
                        LihatPengeluaran.class);
                intent.putExtra("trKeluar.detail", listKeluar.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBKeluar dbKeluar = new DBKeluar(this);
        listKeluar = dbKeluar.getKeluar();
        adapter = new CostumListKeluar(this, listKeluar);
        listView.setAdapter(adapter);
    }
}
