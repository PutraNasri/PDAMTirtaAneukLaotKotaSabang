package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(MainActivity.this, Keluhan.class);
        startActivity(hasilIntent);
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(MainActivity.this, tentang.class);
        startActivity(hasilIntent);
    }
}
