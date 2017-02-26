package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class view_jadwal extends Activity {
    private ListView listView;
    private TextView texk;
    private String JSON_STRING;
    String nama;
    String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jadwal);
        listView = (ListView) findViewById(R.id.list_jadwal);
        texk = (TextView) findViewById(R.id.textView14);
        Intent intent = getIntent();
        nama = intent.getStringExtra("NAMA");
        url = intent.getStringExtra("URL");
        texk.setText(nama);
        getJSON();
    }
    public void back(View v){
        Intent hasilIntent = new Intent(view_jadwal.this,  jadwal.class);
        startActivity(hasilIntent);
        finish();
    }
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(view_jadwal.this,"Mengambil Data","Loading...",false,false);
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
                String s = rh.sendGetRequest(url);
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

                String no_pompa = jo.getString(config.TAG_NO_JADWAL);
                String jam = jo.getString(config.TAG_JAM_JADWAL);
                String len = jo.getString(config.TAG_LEN_JADWAL);
                String ket = jo.getString(config.TAG_KET_JADWAL);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(config.TAG_NO_JADWAL,no_pompa);
                employees.put(config.TAG_JAM_JADWAL,jam);
                employees.put(config.TAG_LEN_JADWAL,len);
                employees.put(config.TAG_KET_JADWAL,ket);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                view_jadwal.this, list, R.layout.jadwal_filter,
                new String[]{config.TAG_NO_JADWAL,config.TAG_JAM_JADWAL,config.TAG_LEN_JADWAL,config.TAG_KET_JADWAL},
                new int[]{R.id.no, R.id.jam, R.id.len, R.id.pipa});
        listView.setAdapter(adapter);
    }
}
