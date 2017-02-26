package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class list_pasang_baru extends Activity {
    private ListView listView;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pasang_baru);
        listView = (ListView) findViewById(R.id.list_antri);

       // WebView myWebView = (WebView) findViewById(R.id.web);
       // myWebView.loadUrl("http://cobabflf.esy.es/get_cek_pasang_baru.php");

        getJSON();
    }
    public void back(View v){
        Intent hasilIntent = new Intent(list_pasang_baru.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
    }
   /*
    public void segarkan(View v){
        //test

        getJSON();
    }
    */
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(list_pasang_baru.this,"Mengambil Data","Loading...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest("http://cobabflf.esy.es/get_cek_pasang_baru.php");
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(config.TAG_JSON_ARRAY);
            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);

                String nama = jo.getString(config.TAG_NAMA_ANTRI);
                String status_pasang = jo.getString(config.TAG_STATUS_ANTRI);

                HashMap<String,String> employees = new HashMap<>();

                employees.put(config.TAG_NAMA_ANTRI,nama);
                employees.put(config.TAG_STATUS_ANTRI,status_pasang);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                list_pasang_baru.this, list, R.layout.filter_list,
                new String[]{config.TAG_NAMA_ANTRI,config.TAG_STATUS_ANTRI},
                new int[]{R.id.nama, R.id.status});
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent hasilIntent = new Intent(list_pasang_baru.this, pelanggan.class);
            startActivity(hasilIntent);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
