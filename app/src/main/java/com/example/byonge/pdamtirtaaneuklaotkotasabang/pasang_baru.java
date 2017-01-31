package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class pasang_baru extends Activity {
    private EditText editTextnama;
    private EditText editTextidentitas;
    private EditText editTextpekerjaan;
    private EditText editTextbangunan;
    private EditText editTextalamat;
    private EditText editTextkontak;
    private EditText editTextalamatpasang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasang_baru);
        editTextnama = (EditText) findViewById(R.id.editnama);
        editTextidentitas = (EditText) findViewById(R.id.editidentitas);
        editTextpekerjaan = (EditText) findViewById(R.id.editpekerjaan);
        editTextbangunan = (EditText) findViewById(R.id.editbangunan);
        editTextalamat = (EditText) findViewById(R.id.editalamat);
        editTextkontak = (EditText) findViewById(R.id.editkontak);
        editTextalamatpasang = (EditText) findViewById(R.id.editalamatpasang);
    }
    public void back(View v){
        Intent hasilIntent = new Intent(pasang_baru.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void sendp(View v){

        if(TextUtils.isEmpty(editTextnama.getText().toString())) {
            editTextnama.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextidentitas.getText().toString())) {
            editTextidentitas.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextpekerjaan.getText().toString())) {
            editTextpekerjaan.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextbangunan.getText().toString())) {
            editTextbangunan.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextalamat.getText().toString())) {
            editTextalamat.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextkontak.getText().toString())) {
            editTextkontak.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextalamatpasang.getText().toString())) {
            editTextalamatpasang.setError("Tidak boleh kosong");
            return;
        }

    else {
            addEmployee();}
        }
    private void addEmployee() {
        //proses pengambilan string dari variabel
        final String nama = editTextnama.getText().toString().trim();
        final String identitas = editTextidentitas.getText().toString().trim();
        final String pekerjaan = editTextpekerjaan.getText().toString().trim();
        final String bangunan = editTextbangunan.getText().toString().trim();
        final String alamat = editTextalamat.getText().toString().trim();
        final String kontak = editTextkontak.getText().toString().trim();
        final String alamat_pasang = editTextalamatpasang.getText().toString().trim();
        class AddEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(pasang_baru.this, "Mengirim Data ...", "HARAP TUNGGU...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(pasang_baru.this, s, Toast.LENGTH_LONG).show();
                AlertDialog.Builder a_builder = new AlertDialog.Builder(pasang_baru.this);
                a_builder.setMessage("Terima Kasih Telah Menggunakan Layanan Kami,Pengajuan Pasang Baru anda segera di proses")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent hasilIntent = new Intent(pasang_baru.this, MainActivity.class);
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
                params.put(config.KEY_EMP_NAMA_BARU, nama);
                params.put(config.KEY_EMP_IDENTITAS_BARU, identitas);
                params.put(config.KEY_EMP_PEKERJAAN_BARU, pekerjaan);
                params.put(config.KEY_EMP_BANGUNAN_BARU, bangunan);
                params.put(config.KEY_EMP_ALAMAT_BARU, alamat);
                params.put(config.KEY_EMP_KONTAK_BARU, kontak);
                params.put(config.KEY_EMP_ALAMAT_PASANG_BARU, alamat_pasang);
                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(config.URL_ADD_PASANG_BARU, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
