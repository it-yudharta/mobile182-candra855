package id.coba.bkk.ProfilMenu;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import id.coba.bkk.R;

public class Pekerjaan extends AppCompatActivity {

    FloatingActionButton fab;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_perusahaan, txt_tahun_masuk, txt_tahun_keluar;
    TextView txt_hasil;
    String perusahaan, tahun_masuk, tahun_keluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pekerjaan);

        txt_hasil   = (TextView) findViewById(R.id.txt_hasil);
        fab         = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_hasil.setText(null);
                DialogForm();
            }
        });
    }

    // untuk mengosongi edittext
    private void kosong(){
        txt_perusahaan.setText(null);
        txt_tahun_masuk.setText(null);
        txt_tahun_keluar.setText(null);
    }

    // untuk menampilkan dialog
    private void DialogForm() {
        dialog = new AlertDialog.Builder(Pekerjaan.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_pekerjaan, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_description_black);
        dialog.setTitle("Riwayat Pekerjaan");

        txt_perusahaan    = (EditText) dialogView.findViewById(R.id.txt_perusahaan);
        txt_tahun_masuk  = (EditText) dialogView.findViewById(R.id.txt_tahun_masuk);
        txt_tahun_keluar = (EditText) dialogView.findViewById(R.id.txt_tahun_keluar);

        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                perusahaan    = txt_perusahaan.getText().toString();
                tahun_masuk  = txt_tahun_masuk.getText().toString();
                tahun_keluar = txt_tahun_keluar.getText().toString();

                txt_hasil.setText("Perusahaan : " + perusahaan + "\n" + "Tahun Masuk : " + tahun_masuk + "\n" + "Tahun Keluar : " + tahun_keluar);
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}