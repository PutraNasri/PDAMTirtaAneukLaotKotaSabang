package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class jadwal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
    }
    public void back(View v){
        Intent hasilIntent = new Intent(jadwal.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void cot_bau(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "COT BAU";
        String url = config.URL_GET_JADWAL_COT_BAU.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void tek_tok(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "TEK TOK";
        String url = config.URL_GET_JADWAL_TEK_TOK.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
