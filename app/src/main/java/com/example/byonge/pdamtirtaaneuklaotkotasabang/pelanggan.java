package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pelanggan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);
    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(pelanggan.this, Keluhan.class);
        startActivity(hasilIntent);
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(pelanggan.this, tentang.class);
        startActivity(hasilIntent);
    }
    public void berita(View v){
        Intent hasilIntent = new Intent(pelanggan.this, MainActivity.class);
        startActivity(hasilIntent);
    }
    public void pasang_baru(View v){
        Intent hasilIntent = new Intent(pelanggan.this, pasang_baru.class);
        startActivity(hasilIntent);
    }
    //TEST
}
