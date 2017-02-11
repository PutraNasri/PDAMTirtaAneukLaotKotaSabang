package com.example.byonge.pdamtirtaaneuklaotkotasabang;

/**
 * Created by addd on 2/28/2016.
 */
public class config {
    //String Alamat untuk CRUD//
    public static final String URL_ADD_KELUHAN="http://cobabflf.esy.es/addkeluhan.php";
    public static final String URL_ADD_KELUHAN_TEST="http://cobabflf.esy.es/addkeluhan_test_foto.php";
    public static final String URL_ADD_PASANG_BARU="http://cobabflf.esy.es/pasang_baru.php";
    public static final String URL_GET_BERITA="http://cobabflf.esy.es/getberita.php";
    public static final String URL_GET_DETAIL_BERITA = "http://cobabflf.esy.es/get_detail_berita.php?id=";
    public static final String URL_GET_JADWAL_COT_BAU="http://cobabflf.esy.es/get_pompa_cot_bau.php";
    public static final String URL_GET_JADWAL_TEK_TOK="http://cobabflf.esy.es/get_pompa_tek_tok.php";
    public static final String URL_GET_JADWAL_PRIA_LAOT="http://cobabflf.esy.es/get_pompa_pria_laot.php";
    public static final String URL_GET_JADWAL_COT_DAMAR_1="http://cobabflf.esy.es/get_pompa_cot_damar_1.php";
    public static final String URL_GET_JADWAL_COT_DAMAR_2="http://cobabflf.esy.es/get_pompa_cot_damar_2.php";
    public static final String URL_GET_JADWAL_ANEUK_LAOT="http://cobabflf.esy.es/get_pompa_aneuk_laot.php";
    public static final String URL_GET_JADWAL_KRUENG_RAYA="http://cobabflf.esy.es/get_pompa_krueng_raya.php";
    public static final String URL_GET_JADWAL_KRUENG_PANCU="http://cobabflf.esy.es/get_pompa_krueng_pancu.php";
    public static final String URL_GET_JADWAL_USMAN_PDI="http://cobabflf.esy.es/get_pompa_usman_pdi.php";
    public static final String URL_GET_JADWAL_KEBUN_MERICA="http://cobabflf.esy.es/get_pompa_kebun_merica.php";
    public static final String URL_GET_JADWAL_GAPANG="http://cobabflf.esy.es/get_pompa_cot_gapang";
    public static final String URL_GET_JADWAL_LAM_NIBONG="http://cobabflf.esy.es/get_pompa_lam_nibong.php";
    public static final String URL_GET_JADWAL_TEUPIN_CIRIK="http://cobabflf.esy.es/get_pompa_teupin_cirik.php";
    public static final String URL_GET_JADWAL_UJONG_SEKUNDUR="http://cobabflf.esy.es/get_pompa_ujong_sekundur.php";
    public static final String URL_GET_JADWAL_SABANG_HILL="http://cobabflf.esy.es/get_pompa_sabang_hill.php";
    public static final String URL_GET_CEK_ANTRI="http://cobabflf.esy.es/get_cek_pasang_baru.php";
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Kunci untuk melakukan pemanggilan data dari scrip
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_REKENING = "rekening";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KONTAK = "kontak";
    public static final String KEY_EMP_ISI = "isi";
    public static final String KEY_EMP_FOTO = "foto";


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
    public static final String TAG_NAMA_ANTRI = "nama";
    public static final String TAG_STATUS_ANTRI = "status_pasang";




    //employee id untuk di gunakan membuka halaman intent lain
    public static final String EMP_ID = "emp_id";
    public static final String EMP_ID_meuraxa = "emp_id";
    public static final String EMP_LOKASI = "emp_lokasi";



}
