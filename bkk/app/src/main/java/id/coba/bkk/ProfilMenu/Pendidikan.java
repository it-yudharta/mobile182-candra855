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

public class Pendidikan extends AppCompatActivity {

    FloatingActionButton fab;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_pendidikan, txt_nama_lembaga, txt_tahun_masuk, txt_tahun_lulus;
    TextView txt_hasil;
    String pendidikan, nama_lembaga, tahun_masuk, tahun_lulus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendidikan);

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
        txt_pendidikan.setText(null);
        txt_nama_lembaga.setText(null);
        txt_tahun_masuk.setText(null);
        txt_tahun_lulus.setText(null);
    }

    // untuk menampilkan dialog
    private void DialogForm() {
        dialog = new AlertDialog.Builder(Pendidikan.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_pendidikan, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_description_black);
        dialog.setTitle("Pendidikan");

        txt_pendidikan    = (EditText) dialogView.findViewById(R.id.txt_pendidikan);
        txt_nama_lembaga    = (EditText) dialogView.findViewById(R.id.txt_lembaga);
        txt_tahun_masuk  = (EditText) dialogView.findViewById(R.id.txt_tahun_masuk);
        txt_tahun_lulus = (EditText) dialogView.findViewById(R.id.txt_tahun_lulus);

        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                pendidikan    = txt_pendidikan.getText().toString();
                nama_lembaga    = txt_nama_lembaga.getText().toString();
                tahun_masuk  = txt_tahun_masuk.getText().toString();
                tahun_lulus = txt_tahun_lulus.getText().toString();

                txt_hasil.setText("Pendidikan : " + pendidikan + "\n" + "Nama Lembaga : " + nama_lembaga + "\n" + "Tahun Masuk : " + tahun_masuk + "\n" + "Tahun Lulus : " + tahun_lulus);
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