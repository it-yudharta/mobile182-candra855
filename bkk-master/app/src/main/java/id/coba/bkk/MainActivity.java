package id.coba.bkk;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import id.coba.bkk.MainMenu.AppFragment;
import id.coba.bkk.MainMenu.HomeFragment;
import id.coba.bkk.MainMenu.ProfilFragment;

import static id.coba.bkk.Login.my_shared_preferences;

public class MainActivity extends AppCompatActivity {

    TextView txt_id, txt_username;
    String id, username;

    SharedPreferences sharedpreferences;
    NavigationView navigationView;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bursa Kerja Khusus SMK");

      //  txt_id = (TextView) findViewById(R.id.txt_id);
        //txt_username = (TextView) findViewById(R.id.txt_username);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
       // txt_id.setText("ID : " + id);
       // txt_username.setText("USERNAME : " + username);

        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);

        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new HomeFragment());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.application:
                        fragment = new AppFragment();
                        break;

                    case R.id.account:
                        fragment = new ProfilFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}