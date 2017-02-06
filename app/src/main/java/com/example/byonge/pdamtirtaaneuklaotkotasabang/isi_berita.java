package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class isi_berita extends Activity {
    private TextView editTextid;
    private TextView editTextjudul;
    private TextView editTextisi;
    private TextView editTexttanggal;
//sudah ok
    private ImageView image;
    private String id;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_berita);
        Intent intent = getIntent();
        id = intent.getStringExtra(config.EMP_ID);

        editTextjudul = (TextView)findViewById(R.id.judul_b);
        editTexttanggal = (TextView)findViewById(R.id.tanggal_b);
        editTextisi = (TextView)findViewById(R.id.isi);
        image =(ImageView) findViewById(R.id.editimage);
        getEmployee();
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(isi_berita.this,"Menampilkan Data...","Loading...",false,false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }
            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(config.URL_GET_DETAIL_BERITA, id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }
    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String id = c.getString(config.TAG_ID);
            String judul = c.getString(config.TAG_JUDUL_BERITA);
            String tanggal = c.getString(config.TAG_TANGGAL_BERITA);
            String isi = c.getString(config.TAG_ISI_BERITA);
            String foto = c.getString(config.TAG_FOTO_BERITA);


            ///////////////proses mengubah binner blob ke file bitmap//////////////
            byte[] bytarray = Base64.decode(foto, Base64.DEFAULT);
            Bitmap bmimage = BitmapFactory.decodeByteArray(bytarray, 0, bytarray.length);
            ////////////////////proses-tampilkan-data//////////////////////////////


            image.setImageBitmap(bmimage);
            editTextjudul.setText(judul);
            editTexttanggal.setText(tanggal);
            editTextisi.setText(isi);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
