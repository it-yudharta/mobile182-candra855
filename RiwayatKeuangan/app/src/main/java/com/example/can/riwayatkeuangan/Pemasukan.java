package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.can.riwayatkeuangan.Helper.DBMasuk;
import com.example.can.riwayatkeuangan.adapter.CostumListMasuk;
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.ArrayList;
import java.util.List;

public class Pemasukan extends AppCompatActivity {

    private List<DataMasuk> listMasuk = new ArrayList<DataMasuk>();
    private CostumListMasuk adapter;
    private ListView listView;
    private DBMasuk db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DBMasuk(this);

        listView = findViewById(R.id.list_masuk);

        adapter = new CostumListMasuk(this, listMasuk);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //    .setAction("Action", null).show();

                Intent intent = new Intent(Pemasukan.this, IsiPemasukan.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),
                        LihatPemasukan.class);
                intent.putExtra("trMasuk.detail", listMasuk.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBMasuk dbMasuk = new DBMasuk(this);
        listMasuk = dbMasuk.getMasuk();
        adapter = new CostumListMasuk(this, listMasuk);
        listView.setAdapter(adapter);
    }
}
