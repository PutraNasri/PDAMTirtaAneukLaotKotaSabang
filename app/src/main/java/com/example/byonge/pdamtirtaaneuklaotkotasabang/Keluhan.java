package com.example.byonge.pdamtirtaaneuklaotkotasabang;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
public class Keluhan extends Activity {
    private EditText editTextrekening;
    private EditText editTextalamat;
    private EditText editTextnama;
    private EditText editTextkontak;
    private EditText editTextisi;
    private ImageView berita;
    private ImageView pelanggan;
    private ImageView keluhan;
    private ImageView tentang;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;
    private ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);
        editTextrekening = (EditText) findViewById(R.id.textrekening);
        editTextalamat = (EditText) findViewById(R.id.textalamat);
        editTextnama = (EditText) findViewById(R.id.textnama);
        editTextkontak = (EditText) findViewById(R.id.textkontak);
        editTextisi = (EditText) findViewById(R.id.textisi);
        berita =(ImageView) findViewById(R.id.imageView1);
        pelanggan =(ImageView) findViewById(R.id.imageView2);
        keluhan =(ImageView) findViewById(R.id.imageView3);
        tentang =(ImageView) findViewById(R.id.imageView4);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        berita.setImageResource(R.drawable.news2);
        pelanggan.setImageResource(R.drawable.pell);
        keluhan.setImageResource(R.drawable.cs1);
        tentang.setImageResource(R.drawable.ii);
        ivImage.setImageResource(R.drawable.camera);

    }

    public void berita(View v){
        Intent hasilIntent = new Intent(Keluhan.this, MainActivity.class);
        startActivity(hasilIntent);
        finish();
    }
    public void tentang(View v){
        Intent hasilIntent = new Intent(Keluhan.this, tentang.class);
        startActivity(hasilIntent);
        finish();
    }
    public void pelanggan(View v){
        Intent hasilIntent = new Intent(Keluhan.this, pelanggan.class);
        startActivity(hasilIntent);
        finish();
    }
    public void send(View v){

        if(TextUtils.isEmpty(editTextrekening.getText().toString())) {
            editTextrekening.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextalamat.getText().toString())) {
            editTextalamat.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextnama.getText().toString())) {
            editTextnama.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextkontak.getText().toString())) {
            editTextkontak.setError("Tidak boleh kosong");
            return;
        }
        else if(TextUtils.isEmpty(editTextisi.getText().toString())) {
            editTextisi.setError("Tidak boleh kosong");
            return;
        }
        else {addEmployee();}
    }

    private void addEmployee() {
        //proses pengambilan string dari variabel
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = ((BitmapDrawable) ivImage.getDrawable()).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] fotoo = baos.toByteArray();

        final String rekening = editTextrekening.getText().toString().trim();
        final String alamat = editTextalamat.getText().toString().trim();
        final String nama = editTextnama.getText().toString().trim();
        final String kontak = editTextkontak.getText().toString().trim();
        final String isi = editTextisi.getText().toString().trim();
        final String foto = Base64.encodeToString(fotoo, Base64.DEFAULT);

        class AddEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Keluhan.this, "Mengirim Data Keluhan...", "HARAP TUNGGU...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Keluhan.this, s, Toast.LENGTH_LONG).show();
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Keluhan.this);
                a_builder.setMessage("Terima Kasih Telah Menggunakan Layanan Kami,Keluhan Anda Sudah Terkirim")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent hasilIntent = new Intent(Keluhan.this, MainActivity.class);
                                startActivity(hasilIntent);
                                finish();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Info");
                alert.show();
            }
            @Override
            protected String doInBackground(Void... v) {

                HashMap<String, String> params = new HashMap<>();
                params.put(config.KEY_EMP_REKENING, rekening);
                params.put(config.KEY_EMP_ALAMAT, alamat);
                params.put(config.KEY_EMP_NAMA, nama);
                params.put(config.KEY_EMP_KONTAK, kontak);
                params.put(config.KEY_EMP_ISI, isi);
                params.put(config.KEY_EMP_FOTO, foto);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(config.URL_ADD_KELUHAN, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();


    }
    public void setimage(View v){
        selectImage();
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Keluhan.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(Keluhan.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }
    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage.setImageBitmap(thumbnail);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ivImage.setImageBitmap(bm);
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
