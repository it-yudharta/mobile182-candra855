package id.coba.bkk.ProfilMenu;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import id.coba.bkk.R;

public class DataPribadi extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText no_ktp,name,email,telp,lulus,date;
    private TextView tv_date;
    private Spinner gender,department;
    private Button register;

    private String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_pribadi);

        date = (EditText) findViewById(R.id.txt_date);
        tv_date = (TextView) findViewById(R.id.txt_date);
        no_ktp = (EditText) findViewById(R.id.txt_no_ktp);
        name = (EditText) findViewById(R.id.txt_name);
        email = (EditText) findViewById(R.id.txt_email);
        telp = (EditText) findViewById(R.id.txt_telp);
        gender = (Spinner) findViewById(R.id.txt_gender);
        department = (Spinner) findViewById(R.id.txt_department);
        register = (Button) findViewById(R.id.btn_register);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DataPribadi.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + year + "/" + month + "/" + day);
                String date = day + "/" + month + "/" + year;
                tv_date.setText(date);
            }
        };
    }

}




