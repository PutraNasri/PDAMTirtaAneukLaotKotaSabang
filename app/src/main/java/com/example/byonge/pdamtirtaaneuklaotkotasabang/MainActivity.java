package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends Activity {
    ArrayList<Berita>arrayList;
    ListView lv;

    private ImageView berita;
    private ImageView pelanggan;
    private ImageView keluhan;
    private ImageView tentang;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.listView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute(config.URL_GET_BERITA_TEST);
            }
        });

        berita =(ImageView) findViewById(R.id.imageView1);
        pelanggan =(ImageView) findViewById(R.id.imageView2);
        keluhan =(ImageView) findViewById(R.id.imageView3);
        tentang =(ImageView) findViewById(R.id.imageView4);
        berita.setImageResource(R.drawable.news1);
        pelanggan.setImageResource(R.drawable.pell);
        keluhan.setImageResource(R.drawable.cs2);
        tentang.setImageResource(R.drawable.ii);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1507631584345851~4109903120");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void keluhan(View v){
        Intent hasilIntent = new Intent(MainActivity.this, Keluhan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(MainActivity.this, tentang.class);
        startActivity(hasilIntent);
        finish();
    }
    public void pelanggan(View v){
        Intent hasilIntent = new Intent(MainActivity.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
    }
    /*
    public void segarkan(View v){
    getJSON();
    }
    */

    class ReadJSON extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("result");

                for (int i = 0; 1 < jsonArray.length(); i++) {
                    JSONObject beritaObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Berita(
                            beritaObject.getString("url_foto"),
                            beritaObject.getString("judul"),
                            beritaObject.getString("tanggal")));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            AdapterBerita adapter = new AdapterBerita(
                    getApplicationContext(), R.layout.filter,arrayList);
            lv.setAdapter(adapter);
        }
    }

    private String readURL(String theUrl){
        StringBuilder content=new StringBuilder();
        try{
            URL url= new URL(theUrl);
            URLConnection urlConnection=url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line=bufferedReader.readLine())!= null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return content.toString();
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

            }
        }.postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
