package com.example.byonge.pdamtirtaaneuklaotkotasabang;

/**
 * Created by addd on 2/28/2016.
 */
public class config {
    //String Alamat untuk CRUD
    public static final String URL_ADD_KELUHAN="http://cobabflf.esy.es/addkeluhan.php";
    public static final String URL_ADD_PASANG_BARU="http://cobabflf.esy.es/pasang_baru.php";
    public static final String URL_GET_BERITA="http://cobabflf.esy.es/getberita.php";
    public static final String URL_GET_DETAIL_BERITA = "http://cobabflf.esy.es/get_detail_berita.php?id=";
    public static final String URL_GET_ALL_LOCATION="http://kinketkuena.esy.es/getAlllocation.php";
    public static final String URL_GET_JADWAL="http://cobabflf.esy.es/get_pompa_cot_bau.php";


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Kunci untuk melakukan pemanggilan data dari scrip
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_REKENING = "rekening";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KONTAK = "kontak";
    public static final String KEY_EMP_ISI = "isi";


    public static final String KEY_EMP_NAMA_BARU = "nama";
    public static final String KEY_EMP_IDENTITAS_BARU = "identitas";
    public static final String KEY_EMP_PEKERJAAN_BARU = "pekerjaan";
    public static final String KEY_EMP_BANGUNAN_BARU = "bangunan";
    public static final String KEY_EMP_ALAMAT_BARU = "alamat";
    public static final String KEY_EMP_KONTAK_BARU = "kontak";
    public static final String KEY_EMP_ALAMAT_PASANG_BARU = "alamat_pasang";
    //JSON Tags
//////////////////////

    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_REKENING = "rekening";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KONTAK = "kontak";
    public static final String TAG_FOTO_BERITA = "foto";
    public static final String TAG_ISI_BERITA = "isi";
    public static final String TAG_JUDUL_BERITA = "judul";
    public static final String TAG_TANGGAL_BERITA = "tanggal";
    public static final String TAG_NO_JADWAL = "no_pompa";
    public static final String TAG_JAM_JADWAL = "jam";
    public static final String TAG_LEN_JADWAL = "len";
    public static final String TAG_KET_JADWAL = "ket";




    //employee id untuk di gunakan membuka halaman intent lain
    public static final String EMP_ID = "emp_id";
    public static final String EMP_ID_meuraxa = "emp_id";
    public static final String EMP_LOKASI = "emp_lokasi";



}
