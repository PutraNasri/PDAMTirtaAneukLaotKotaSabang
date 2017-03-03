package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    String txtisi ="";
    private LinearLayout llytLayout;

    public AdapterBerita(Context context, int resource, ArrayList<Berita> beritas) {
        super(context, resource, beritas);
        this.beritas=beritas;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.filter, parent, false);
        final Berita berita = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.fotooo);
        TextView txtjudul = (TextView) convertView.findViewById(R.id.judul);
        TextView txttanggal = (TextView) convertView.findViewById(R.id.tanggal);
        //TextView txtisi = (TextView) convertView.findViewById(R.id.textView36);
        llytLayout = (LinearLayout) convertView.findViewById(R.id.llyt_layout);


        txtjudul.setText(berita.getJudul());
        txttanggal.setText(berita.getTanggal());
        txtisi = berita.getIsi();

        foto = berita.getUrl_foto();
        Picasso.with(context)
                .load(foto)
                .resize(50, 50)
                .into(imageView);

        llytLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,isi_berita.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(config.TAG_JUDUL_BERITA,berita.getJudul());
                intent.putExtra(config.TAG_TANGGAL_BERITA, berita.getTanggal());
                intent.putExtra(config.TAG_ISI_BERITA, berita.getIsi());
                intent.putExtra(config.TAG_URL_FOTO_BERITA, berita.getUrl_foto());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
