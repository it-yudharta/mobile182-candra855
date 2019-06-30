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
import com.example.can.riwayatkeuangan.model.DataMasuk;

import java.util.List;

public class CostumListMasuk extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataMasuk>masukItems;

    public CostumListMasuk(Activity activity, List<DataMasuk> masukItems){
        this.activity = activity;
        this.masukItems = masukItems;
    }
    @Override
    public int getCount() {
        return masukItems.size();
    }

    @Override
    public Object getItem(int location) {
        return masukItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_masuk, null);

        TextView nama = (TextView) convertView.findViewById(R.id.txt_nama);
        TextView jumlah = (TextView) convertView.findViewById(R.id.txt_jumlah);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.masuk_logo);

        DataMasuk dm = masukItems.get(position);

        nama.setText("" + dm.getNama_masuk());
        jumlah.setText("Rp. " + dm.getJumlah_masuk());

        return convertView;
    }
}
