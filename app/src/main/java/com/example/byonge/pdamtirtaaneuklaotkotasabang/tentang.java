package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class tentang extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(tentang.this, Keluhan.class);
        startActivity(hasilIntent);
    }
    public void berita(View v){
        Intent hasilIntent = new Intent(tentang.this, MainActivity.class);
        startActivity(hasilIntent);
    }
}
