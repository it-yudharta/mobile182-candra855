package id.coba.bkk.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.coba.bkk.R;

public class HomeAdapter extends BaseAdapter {
    private String[] informasi;
    private String[] industri;
    private String[] deadline;
    private Integer[] gambar;
    private Activity activity;

    public HomeAdapter(Activity fragmentHome, String[] informasi, String[] industri, String[] deadline, Integer[] gamabar) {
        this.informasi = informasi;
        this.industri = industri;
        this.deadline = deadline;
        this.gambar = gamabar;
        activity = fragmentHome;
    }

    @Override
    public int getCount() {
        return informasi.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.costumlist_home, null);

        TextView txt_informasi = (TextView) v.findViewById(R.id.txt_informasi);
        TextView txt_industri = (TextView) v.findViewById(R.id._txt_industri);
        TextView txt_deadline = (TextView) v.findViewById(R.id.txt_deadline);
        ImageView gambar_lowongan = (ImageView) v.findViewById(R.id.imglist);

        // tampilkan data pada komponen
        txt_informasi.setText(informasi[i]);
        txt_industri.setText(industri[i]);
        txt_deadline.setText("sampai " + deadline[i]);
        gambar_lowongan.setImageResource(gambar[i]);

        return v;
    }
}

