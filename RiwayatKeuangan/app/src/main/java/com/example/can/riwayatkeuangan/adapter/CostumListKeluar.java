package com.example.can.riwayatkeuangan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.can.riwayatkeuangan.R;
import com.example.can.riwayatkeuangan.model.DataKeluar;
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.List;

public class CostumListKeluar extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataKeluar>keluarItems;

    public CostumListKeluar(Activity activity, List<DataKeluar> keluarItems){
        this.activity = activity;
        this.keluarItems = keluarItems;
    }
    @Override
    public int getCount() {
        return keluarItems.size();
    }

    @Override
    public Object getItem(int location) {
        return keluarItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_keluar, null);

        TextView nama = (TextView) convertView.findViewById(R.id.txt_nama);
        TextView jumlah = (TextView) convertView.findViewById(R.id.txt_jumlah);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.keluar_logo);

        DataKeluar dk = keluarItems.get(position);

        nama.setText("" + dk.getNama_keluar());
        jumlah.setText("Rp. " + dk.getJumlah_keluar());

        return convertView;
    }
}
