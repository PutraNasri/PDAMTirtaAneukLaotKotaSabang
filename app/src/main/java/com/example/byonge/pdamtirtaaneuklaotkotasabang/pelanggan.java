package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class pelanggan extends Activity {
    private ImageView berita;
    private ImageView pelanggan;
    private ImageView keluhan;
    private ImageView tentang;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);
        berita =(ImageView) findViewById(R.id.imageView1);
        pelanggan =(ImageView) findViewById(R.id.imageView2);
        keluhan =(ImageView) findViewById(R.id.imageView3);
        tentang =(ImageView) findViewById(R.id.imageView4);

        berita.setImageResource(R.drawable.news2);
        pelanggan.setImageResource(R.drawable.pel);
        keluhan.setImageResource(R.drawable.cs2);
        tentang.setImageResource(R.drawable.ii);

    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(pelanggan.this, Keluhan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void antri(View v){
        Intent hasilIntent = new Intent(pelanggan.this, list_pasang_baru.class);
        startActivity(hasilIntent);
        finish();
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(pelanggan.this, tentang.class);
        startActivity(hasilIntent);
        finish();
    }
    public void berita(View v){
        Intent hasilIntent = new Intent(pelanggan.this, MainActivity.class);
        startActivity(hasilIntent);
        finish();
    }
    public void pasang_baru(View v){
        Intent hasilIntent = new Intent(pelanggan.this, pasang_baru.class);
        startActivity(hasilIntent);
        finish();
    }


    public void jadwal(View v){
        ///////////////////////////jangan lupa jika sudah fik semua hilangkan code ini////////////////////////////////
        /*
        AlertDialog.Builder a_builder = new AlertDialog.Builder(pelanggan.this);
        a_builder.setMessage("HALAMAN INI MASIH DALAM PENGEMBANGAN")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent hasilIntent = new Intent(pelanggan.this, pelanggan.class);
                        startActivity(hasilIntent);
                        finish();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Info");
        alert.show();
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        */
        Intent hasilIntent = new Intent(pelanggan.this, jadwal.class);
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
    //TEST
}
