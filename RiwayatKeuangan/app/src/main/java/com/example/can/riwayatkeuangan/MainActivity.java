package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void Pemasukan(View view) {
        Intent intent = new Intent(MainActivity.this, Pemasukan.class);
        startActivity(intent);
    }

    public void Pengeluaran(View view) {
        Intent intent = new Intent(MainActivity.this, Pengeluaran.class);
        startActivity(intent);
    }
}
