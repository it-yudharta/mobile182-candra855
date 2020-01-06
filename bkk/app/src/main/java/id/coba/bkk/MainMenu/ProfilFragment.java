package id.coba.bkk.MainMenu;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import id.coba.bkk.Adapter.ProfilAdapter;
import id.coba.bkk.Login;
import id.coba.bkk.ProfilMenu.Pekerjaan;
import id.coba.bkk.ProfilMenu.Pendidikan;
import id.coba.bkk.ProfilMenu.GantiPassword;
import id.coba.bkk.ProfilMenu.Nilai;
import id.coba.bkk.ProfilMenu.Tentang;
import id.coba.bkk.ProfilMenu.DataPribadi;
import id.coba.bkk.R;

import static id.coba.bkk.Login.my_shared_preferences;
import static id.coba.bkk.Login.session_status;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    SharedPreferences sharedpreferences;
    NavigationView navigationView;
    Boolean session = false;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    Intent intent;
    ListView listView;
    private String[] menu_profil = {
            "Data Pribadi",
            "Pendidikan",
            "Riwayat Pekerjaan",
//            "Nilai",
            "Ganti Password",
            "Tentang Aplikasi",
            "Keluar"};
    private Integer[] logo_menu_profil = {
            R.drawable.ic_account_circle_black,
            R.drawable.ic_school_black,
            R.drawable.ic_work_black,
//            R.drawable.ic_assessment_black,
            R.drawable.ic_key_black,
            R.drawable.ic_info_outline_black,
            R.drawable.ic_exit_to_app};

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profil, container, false);
        View view = inflater.inflate(R.layout.fragment_profil, null);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        sharedpreferences = this.getActivity().getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);

        listView = (ListView) view.findViewById(R.id.list_menu_profil);

        ProfilAdapter ProfilMenu = new ProfilAdapter(getActivity(), menu_profil, logo_menu_profil);
        listView.setAdapter(ProfilMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    intent = new Intent(getActivity(), DataPribadi.class);
                    startActivity(intent);
                } else if (position == 1) {
                     intent = new Intent(getActivity(), Pendidikan.class);
                     startActivity(intent);
                } else if (position == 2) {
                    intent = new Intent(getActivity(), Pekerjaan.class);
                    startActivity(intent);
                } else if (position == 3) {
                    intent = new Intent(getActivity(), GantiPassword.class);
                    startActivity(intent);
                } else if (position == 4) {
                    intent = new Intent(getActivity(), Tentang.class);
                    startActivity(intent);
                }else if (position == 5) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_status, false);
                    editor.putString(TAG_ID, null);
                    editor.putString(TAG_USERNAME, null);
                    editor.commit();
                    intent  = new Intent(getActivity(), Login.class);
                    getActivity().finish();
                    startActivity(intent);
            }

            }
        });
        return view;


    }
}

