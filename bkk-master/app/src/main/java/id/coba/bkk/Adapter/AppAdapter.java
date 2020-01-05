package id.coba.bkk.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import id.coba.bkk.R;

public class AppAdapter extends BaseAdapter {
    private String[] lowongan;
    private String[] tanggal;
    private String[] status;
    private Activity activity;

    public AppAdapter(Activity fragmentApp, String[] lowongan, String[] tanggal, String[] status) {
        this.lowongan = lowongan;
        this.tanggal = tanggal;
        this.status = status;
        activity = fragmentApp;
    }

    @Override
    public int getCount() {
        return lowongan.length;
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
        View v = inflater.inflate(R.layout.costumlist_app, null);

        TextView txt_lowongan = (TextView) v.findViewById(R.id.txt_lowongan);
        TextView txt_tanggal = (TextView) v.findViewById(R.id.txt_tanggal);
        TextView txt_status = (TextView) v.findViewById(R.id.txt_status);

        // tampilkan data pada komponen
          txt_lowongan.setText(lowongan[i]);
        txt_tanggal.setText(tanggal[i]);
        txt_status.setText(status[i]);

        return v;
    }
}




