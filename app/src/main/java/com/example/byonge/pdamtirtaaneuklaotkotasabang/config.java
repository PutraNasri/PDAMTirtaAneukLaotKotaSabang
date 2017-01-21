package com.example.byonge.pdamtirtaaneuklaotkotasabang;

/**
 * Created by addd on 2/28/2016.
 */
public class config {
    //String Alamat untuk CRUD
    public static final String URL_ADD_KELUHAN="http://cobabflf.esy.es/addkeluhan.php";
    public static final String URL_GET_BERITA="http://cobabflf.esy.es/getberita.php";
    public static final String URL_GET_DETAIL_BERITA = "http://cobabflf.esy.es/get_detail_berita.php?id=";
    public static final String URL_GET_ALL_LOCATION="http://kinketkuena.esy.es/getAlllocation.php";

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //syahkuala
    public static final String URL_GET_ALL = "http://kinketkuena.esy.es/getAllEmp.php";
    public static final String URL_GET_EMP = "http://kinketkuena.esy.es/getEmp.php?id=";
    //kutaraja
    public static final String URL_GET_ALL_KUTARAJA="http://kinketkuena.esy.es/getAllKutaraja.php";
    public static final String URL_GET_KUTARAJA="http://kinketkuena.esy.es/getKutaraja.php?id=";
    //ulekareng
    public static final String URL_GET_ALL_ULEKARENG="http://kinketkuena.esy.es/getAllUlekareng.php";
    public static final String URL_GET_ULEKARENG="http://kinketkuena.esy.es/getUlekareng.php?id=";
    //bandaraya
    public static final String URL_GET_ALL_BANDARAYA="http://kinketkuena.esy.es/getAllBandaraya.php";
    public static final String URL_GET_BANDARAYA="http://kinketkuena.esy.es/getBandaraya.php?id=";
    //jayabaru
    public static final String URL_GET_ALL_JAYABARU="http://kinketkuena.esy.es/getAllJayabaru.php";
    public static final String URL_GET_JAYABARU="http://kinketkuena.esy.es/getJayabaru.php?id=";
    //kutaalam
    public static final String URL_GET_ALL_KUTAALAM="http://kinketkuena.esy.es/getAllKutaalam.php";
    public static final String URL_GET_KUTAALAM="http://kinketkuena.esy.es/getKutaalam.php?id=";
    //luengbata
    public static final String URL_GET_ALL_LUENGBATA="http://kinketkuena.esy.es/getAllLuengbata.php";
    public static final String URL_GET_LUENGBATA="http://kinketkuena.esy.es/getLuengbata.php?id=";
    //meuraxa
    public static final String URL_GET_ALL_MEURAXA="http://kinketkuena.esy.es/getAllMeuraxa.php";
    public static final String URL_GET_MEURAXA="http://kinketkuena.esy.es/getMeuraxa.php?id=";

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   // public static final String URL_UPDATE_EMP = "http://192.168.94.1/Android/CRUD/updateEmp.php";
    //public static final String URL_DELETE_EMP = "http://192.168.94.1/Android/CRUD/deleteEmp.php?id=";

    //Kunci untuk melakukan pemanggilan data dari scrip
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_REKENING = "rekening";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KONTAK = "kontak";
    public static final String KEY_EMP_ISI = "isi";



    public static final String KEY_EMP_NAME = "namakost";
    public static final String KEY_EMP_DESG = "namapemilik";
    public static final String KEY_EMP_SAL = "nohp";
    public static final String KEY_EMP_NIK = "nik";
    //JSON Tags


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




    //employee id untuk di gunakan membuka halaman intent lain
    public static final String EMP_ID = "emp_id";
    public static final String EMP_ID_meuraxa = "emp_id";
    public static final String EMP_LOKASI = "emp_lokasi";



}
