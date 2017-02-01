package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class tentang extends Activity {
    private ImageView berita;
    private ImageView pelanggan;
    private ImageView keluhan;
    private ImageView tentang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        berita =(ImageView) findViewById(R.id.imageView1);
        pelanggan =(ImageView) findViewById(R.id.imageView2);
        keluhan =(ImageView) findViewById(R.id.imageView3);
        tentang =(ImageView) findViewById(R.id.imageView4);

        berita.setImageResource(R.drawable.news2);
        pelanggan.setImageResource(R.drawable.pell);
        keluhan.setImageResource(R.drawable.cs2);
        tentang.setImageResource(R.drawable.i);
    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(tentang.this, Keluhan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void berita(View v){
        Intent hasilIntent = new Intent(tentang.this, MainActivity.class);
        startActivity(hasilIntent);
        finish();
    }
    public void pelanggan(View v){
        Intent hasilIntent = new Intent(tentang.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
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
