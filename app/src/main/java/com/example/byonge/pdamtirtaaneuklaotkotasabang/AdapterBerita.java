package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.byonge.pdamtirtaaneuklaotkotasabang.R;
import com.example.byonge.pdamtirtaaneuklaotkotasabang.Berita;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by putra on 2/26/17.
 */

public class AdapterBerita extends ArrayAdapter<Berita>{

    ArrayList<Berita>beritas;
    Context context;
    int resource;
    String foto = "";

    public AdapterBerita(Context context, int resource, ArrayList<Berita> beritas) {
        super(context, resource, beritas);
        this.beritas=beritas;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.filter, parent, false);
        Berita berita = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.fotooo);
        TextView txtjudul = (TextView) convertView.findViewById(R.id.judul);
        TextView txttanggal = (TextView) convertView.findViewById(R.id.tanggal);


        txtjudul.setText(berita.getJudul());
        txttanggal.setText(berita.getTanggal());
        foto = berita.getUrl_foto();
        Picasso.with(context)
                .load(foto)
                .resize(50, 50)
                .into(imageView);

        return convertView;
    }
}
