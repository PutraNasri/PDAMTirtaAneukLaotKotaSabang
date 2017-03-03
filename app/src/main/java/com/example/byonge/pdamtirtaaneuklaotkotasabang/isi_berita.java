
package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class isi_berita extends Activity {
    private TextView editTextid;
    private TextView editTextjudul;
    private TextView editTextisi;
    private TextView editTexttanggal;
//sudah ok
    private ImageView image;

    private AdView mAdView;
    private String judul;
    private String tanggal;
    private String isi;
    private String foto;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_berita);
        pd = new ProgressDialog(this);
        Intent intent = getIntent();
        judul = intent.getStringExtra(config.TAG_JUDUL_BERITA);
        tanggal = intent.getStringExtra(config.TAG_TANGGAL_BERITA);
        isi = intent.getStringExtra(config.TAG_ISI_BERITA);
        foto = intent.getStringExtra(config.TAG_URL_FOTO_BERITA);

///
        editTextjudul = (TextView)findViewById(R.id.judul_b);
        editTexttanggal = (TextView)findViewById(R.id.tanggal_b);
        editTextisi = (TextView)findViewById(R.id.isi);
        image =(ImageView) findViewById(R.id.editimage);

        editTextjudul.setText(judul);
        editTexttanggal.setText(tanggal);
        editTextisi.setText(isi);




        MobileAds.initialize(getApplicationContext(),"ca-app-pub-1507631584345851~4109903120");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        new DownloadImageTask(image).execute(foto);
    }
    class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pd.show();
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            pd.dismiss();
            bmImage.setImageBitmap(result);
        }
    }
    }




