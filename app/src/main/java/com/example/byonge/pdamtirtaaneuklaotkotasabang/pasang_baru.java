package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pasang_baru extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasang_baru);
    }
    public void back(View v){
        Intent hasilIntent = new Intent(pasang_baru.this, pelanggan.class);
        startActivity(hasilIntent);
    }
}
//assasa