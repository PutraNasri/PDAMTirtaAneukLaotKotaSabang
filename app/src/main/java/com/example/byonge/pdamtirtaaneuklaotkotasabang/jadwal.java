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
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
