package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Keluhan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);
    }
    public void berita(View v){
        Intent hasilIntent = new Intent(Keluhan.this, MainActivity.class);
        startActivity(hasilIntent);
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(Keluhan.this, tentang.class);
        startActivity(hasilIntent);
    }
}
