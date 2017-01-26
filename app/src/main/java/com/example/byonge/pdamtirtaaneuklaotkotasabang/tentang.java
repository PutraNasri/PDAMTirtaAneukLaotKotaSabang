package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

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
    public void pelanggan(View v){
        Intent hasilIntent = new Intent(tentang.this, pelanggan.class);
        startActivity(hasilIntent);
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler() {
            public void postDelayed(Runnable runnable, int i) {
            }

            @Override
            public void publish(LogRecord record) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {
                finish();
                System.exit(0);
            }
        }.postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
