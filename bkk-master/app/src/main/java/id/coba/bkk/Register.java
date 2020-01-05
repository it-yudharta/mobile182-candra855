package id.coba.bkk;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import id.coba.bkk.Controller.AppController;
import id.coba.bkk.ProfilMenu.DataPribadi;
import id.coba.bkk.server.Server;

public class Register extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText username,name,email,phone,graduation,birthday,password;
    private TextView tv_birthday;
    private Spinner sex,department_id;
    private Button simpan;

    private String TAG = "tag";

    private String TAG_SUCCESSS = "success";
    private String TAG_MESSAGE = "message";
    private static String url = Server.URL + "daftar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
//        getSupportActionBar().hide();

        final RequestQueue request = Volley.newRequestQueue(getApplicationContext());

        birthday = (EditText) findViewById(R.id.txt_date1);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Register.this,
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
                tv_birthday.setText(date);
            }
        };

        tv_birthday = (TextView) findViewById(R.id.txt_date1);
        username = (EditText) findViewById(R.id.txt_no_ktp1);
        name = (EditText) findViewById(R.id.txt_name1);
        email = (EditText) findViewById(R.id.txt_email1);
        phone = (EditText) findViewById(R.id.txt_telp1);
        password = (EditText) findViewById(R.id.txt_password1);
        sex = (Spinner) findViewById(R.id.txt_gender1);
        graduation = (EditText) findViewById(R.id.txt_lulus1);
        department_id = (Spinner) findViewById(R.id.txt_department1);
        simpan = (Button) findViewById(R.id.btn_daftar);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
            //               Map<String, String> map = new HashMap<>();
//                map.put(TAG,Daftar);
//                map.put(USERNAME,username.getText().toString());
//                map.put(PASSWORD,password.getText().toString());
//                request.sendPostRequest();
//            }
        });
    }



    private void simpan()
    {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject dataObj = new JSONObject(response);


                    int code = Integer.parseInt(dataObj.getString("code"));
                    if (code == 1)
                    {
                        daftarBerhasil();
                    }else if(code == 0)
                    {
                        daftarGAgal();
                    }

                    Toast.makeText(Register.this, dataObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    // adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override

            protected Map<String,String> getParams() throws AuthFailureError{

                Map<String,String> map = new HashMap<String, String>();
//                    params.put("id_siswaBaru", id_siswaBaru);
                map.put("username", username.getText().toString());
                map.put("password", password.getText().toString());
                map.put("name", name.getText().toString());
                map.put("department_id",  String.valueOf(department_id.getSelectedItem()));
                map.put("email", email.getText().toString());
                map.put("phone", phone.getText().toString());
                map.put("birthday", tv_birthday.getText().toString());
                map.put("sex",  String.valueOf(sex.getSelectedItem()));
                map.put("graduation", graduation.getText().toString());
                // params.put("tahun_nmasuk", thnmasuk.getText().toString());
                //}
                return map;
            }

        };

        AppController.getInstance().addToRequestQueue(stringRequest);
    }
    public void daftarBerhasil()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert
                .setMessage("Pendaftaran Berhasil")
                .setCancelable(false)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent login = new Intent(Register.this, Login.class);
                        finish();
                        startActivity(login);

                    }
                });

        AlertDialog berhasil = alert.create();
        berhasil.show();
    }
    public void daftarGAgal()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert
                .setMessage("Pendaftaran Gagal")
                .setCancelable(false)
                .setNegativeButton("Ulangi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        recreate();
                    }
                });

        AlertDialog berhasil = alert.create();
        berhasil.show();
    }
}