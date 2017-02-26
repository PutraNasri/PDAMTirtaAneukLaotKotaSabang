package com.example.byonge.pdamtirtaaneuklaotkotasabang.bean;

import java.io.Serializable;

/**
 * Created by putra on 2/26/17.
 */

public class Berita implements Serializable {

    public Berita() {
    }

    public Berita(String judul, String tanggal, String isi, String foto) {

        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
        this.foto = foto;
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

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    private String judul;
    private String tanggal;
    private String isi;
    private String foto;
}
