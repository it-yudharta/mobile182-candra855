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

import com.example.can.riwayatkeuangan.Helper.DBHelper;
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.ArrayList;

public class Pemasukan extends AppCompatActivity {

    private ArrayList<DataMasuk> ListMasuk = new ArrayList<>();
    ArrayAdapter adapter;
    ListView listViewM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewM = findViewById(R.id.list_masuk);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListMasuk);
        listViewM.setAdapter(adapter);

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

        listViewM.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), LihatPemasukan.class);
                intent.putExtra("transaction.detail", ListMasuk.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbHelper = new DBHelper(this);
        ListMasuk = (ArrayList<DataMasuk>) dbHelper.getListMasuk();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListMasuk);
        listViewM.setAdapter(adapter);
    }
}
