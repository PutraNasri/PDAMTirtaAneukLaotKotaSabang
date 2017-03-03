package com.example.byonge.pdamtirtaaneuklaotkotasabang;

import java.io.Serializable;

/**
 * Created by putra on 2/26/17.
 */

public class Berita {

    private String judul;
    private String tanggal;
    private String isi;
    private String url_foto;



    public Berita(String url_foto, String judul, String tanggal, String isi) {
        this.url_foto=url_foto;
        this.judul=judul;
        this.tanggal=tanggal;
        this.isi=isi;

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
