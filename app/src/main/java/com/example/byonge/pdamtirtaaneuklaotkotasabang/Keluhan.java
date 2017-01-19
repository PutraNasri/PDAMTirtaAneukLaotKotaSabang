package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Keluhan extends Activity {
    private EditText editTextrekening;
    private EditText editTextalamat;
    private EditText editTextnama;
    private EditText editTextkontak;
    private EditText editTextisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);
        editTextrekening = (EditText) findViewById(R.id.textrekening);
        editTextalamat = (EditText) findViewById(R.id.textalamat);
        editTextnama = (EditText) findViewById(R.id.textnama);
        editTextkontak = (EditText) findViewById(R.id.textkontak);
        editTextisi = (EditText) findViewById(R.id.textisi);
    }

    public void berita(View v){
        Intent hasilIntent = new Intent(Keluhan.this, MainActivity.class);
        startActivity(hasilIntent);
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(Keluhan.this, tentang.class);
        startActivity(hasilIntent);
    }
    public void send(View v){
        addEmployee();
    }

    private void addEmployee() {
        //proses pengambilan string dari variabel
        final String rekening = editTextrekening.getText().toString().trim();
        final String alamat = editTextalamat.getText().toString().trim();
        final String nama = editTextnama.getText().toString().trim();
        final String kontak = editTextkontak.getText().toString().trim();
        final String isi = editTextisi.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Keluhan.this, "Mengirim Data Keluhan...", "HARAP TUNGGU...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Keluhan.this, s, Toast.LENGTH_LONG).show();
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Keluhan.this);
                a_builder.setMessage("Terima Kasih Telah Menggunakan Layanan Kami,Keluhan Anda Sudah Terkirim")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent hasilIntent = new Intent(Keluhan.this, MainActivity.class);
                                startActivity(hasilIntent);
                                finish();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Info");
                alert.show();
            }
            @Override
            protected String doInBackground(Void... v) {

                HashMap<String, String> params = new HashMap<>();
                params.put(config.KEY_EMP_REKENING, rekening);
                params.put(config.KEY_EMP_ALAMAT, alamat);
                params.put(config.KEY_EMP_NAMA, nama);
                params.put(config.KEY_EMP_KONTAK, kontak);
                params.put(config.KEY_EMP_ISI, isi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(config.URL_ADD_KELUHAN, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();


    }




}
