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
    public void pria_laot(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "PRIA LAOT";
        String url = config.URL_GET_JADWAL_PRIA_LAOT.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void cot_damar_1(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "COT DAMAR 1";
        String url = config.URL_GET_JADWAL_COT_DAMAR_1.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void cot_damar_2(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "COT DAMAR 2";
        String url = config.URL_GET_JADWAL_COT_DAMAR_2.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void aneuk_laot(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "ANEUK LAOT";
        String url = config.URL_GET_JADWAL_ANEUK_LAOT.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void krueng_raya(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "KRUENG RAYA";
        String url = config.URL_GET_JADWAL_KRUENG_RAYA.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void krueng_pancu(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "KRUENG PANCU";
        String url = config.URL_GET_JADWAL_KRUENG_PANCU.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void usman_pdi(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "USMAN PDI";
        String url = config.URL_GET_JADWAL_USMAN_PDI.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void kebun_merica(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "KEBUN MERICA";
        String url = config.URL_GET_JADWAL_KEBUN_MERICA.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void gapang(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "GAPANG";
        String url = config.URL_GET_JADWAL_GAPANG.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void lam_nibong(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "LAM NIBONG";
        String url = config.URL_GET_JADWAL_LAM_NIBONG.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void teupin_cirik(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "TEUPIN CIRIK";
        String url = config.URL_GET_JADWAL_TEUPIN_CIRIK.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void ujong_sekundur(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "UJONG SEKUNDUR";
        String url = config.URL_GET_JADWAL_UJONG_SEKUNDUR.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    public void sabang_hill(View v){
        Intent hasilIntent = new Intent(jadwal.this, view_jadwal.class);
        String emp = "SABANG HILL";
        String url = config.URL_GET_JADWAL_SABANG_HILL.toString();
        hasilIntent.putExtra("NAMA",emp);
        hasilIntent.putExtra("URL",url);
        startActivity(hasilIntent);
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent hasilIntent = new Intent(jadwal.this, pelanggan.class);
            startActivity(hasilIntent);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
