package com.example.can.riwayatkeuangan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab_1, fab_2;
    private CardView card_1, card_2;
    private Animation fab_open, fab_close, rotate_fordward, rotate_backward, card_open, card_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab_1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab_2 = (FloatingActionButton) findViewById(R.id.fab_2);

        card_1 = (CardView) findViewById(R.id.card_1);
        card_2 = (CardView) findViewById(R.id.card_2);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_fordward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        card_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.card_open);
        card_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.card_close);

        fab.setOnClickListener(this);

        //  fab_1.setOnClickListener(this);

        fab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //    .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, IsiPengeluaran.class);
                startActivity(intent);
            }
        });

        fab_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //    .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, IsiPemasukan.class);
                startActivity(intent);
            }
        });
    }


    //   fab_2.setOnClickListener(this);



    //  @Override
    // public boolean onCreateOptionsMenu(Menu menu){
    // getMenuInflater().inflate(R.menu.main, menu);
    //      return true;
    //}

    // @Override
    //public boolean onOptionsItemSelected(MenuItem item){

    //     int id = item.getItemId();

    //   if (id == R.id.settings){
    //return true;
    //   }

    //   return super.onOptionsItemSelected(item);
    //}

    @Override
    public void  onClick (View v){
        int id = v.getId();
        switch (id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.fab_1:
                Log.d("Raj", "FAB 1");
                break;
            case R.id.fab_2:
                Log.d("Raj", "FAB 2");
                break;
        }
    }

    public void animateFAB(){
        if (isFabOpen){
            fab.startAnimation(rotate_backward);
            fab_1.startAnimation(fab_close);
            fab_2.startAnimation(fab_close);
            card_1.startAnimation(card_close);
            card_2.startAnimation(card_close);
            fab_1.setClickable(false);
            fab_2.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "Close");

        }else {
            fab.startAnimation(rotate_fordward);
            fab_1.startAnimation(fab_open);
            fab_2.startAnimation(fab_open);
            card_1.startAnimation(card_open);
            card_2.startAnimation(card_open);
            fab_1.setClickable(true);
            fab_2.setClickable(true);
            isFabOpen = true;
            Log.d("Raj", "Open");
        }
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

