package id.coba.bkk.MainMenu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import id.coba.bkk.Adapter.HomeAdapter;
import id.coba.bkk.HomeMenu.Detail;
import id.coba.bkk.ProfilMenu.DataPribadi;
import id.coba.bkk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private String[] informasi = {"Desain Grafis", "Wireless Technical Support Officer", "Marketing atau Pemasaran", "Operasi Produksi", "Staff Operasi"};
    private String[] industri = {"PT. Penggali Kubur", "PT. Penggali Kubur", "PT. Penggali Kubur", "PT. Penggali Kubur", "PT. Penggali Kubur"};
    private String[] deadline = {"24 Januari 2019", "24 Januari 2019", "30 Januari 2020", "24 Frebruari 2019", "30 Januari 2020"};
    private Integer[] gambar = {R.drawable.ic_business_black, R.drawable.ic_business_black, R.drawable.ic_business_black, R.drawable.ic_business_black, R.drawable.ic_business_black};
    private ListView lvlowongan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, null);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        lvlowongan = (ListView) view.findViewById(R.id.lvlowongan);

        HomeAdapter customAdapter = new HomeAdapter(getActivity(), informasi, industri, deadline, gambar);
        lvlowongan.setAdapter(customAdapter);

        lvlowongan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                Intent sendData = new Intent(getActivity(), Detail.class);
                startActivity(sendData);
            }
        });

        return view;
    }

}
