package id.coba.bkk.MainMenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import id.coba.bkk.Adapter.AppAdapter;
import id.coba.bkk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment extends Fragment {


    public AppFragment() {
        // Required empty public constructor
    }


    private String[] lowongan = {"Desain Grafis", "Wireless Technical Support Officer", "Marketing atau Pemasaran"};
    private String[] tanggal = {"24 Desember 2019", "24 Desember 2019", "30 Januari 2020"};
    private String[] status = {"Ditolak", "Diterima", "Menunggu"};
    private ListView lvstatus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_app, container, false);
        View view = inflater.inflate(R.layout.fragment_app, null);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        lvstatus = (ListView) view.findViewById(R.id.app_status);

        AppAdapter customAdapter = new AppAdapter(getActivity(), lowongan, tanggal, status);
        lvstatus.setAdapter(customAdapter);

        return view;
    }

}