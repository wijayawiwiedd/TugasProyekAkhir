package com.example.wijaya.piyele.Model;

/**
 * Created by Wijaya on 07-Jan-18.
 */

public class DataNilai {

    String nama;
    String nis;
    String pelajaran;
    String nTugas;
    String nUts;
    String nUas;

    public DataNilai() {

    }

    public DataNilai(String nama, String nis, String pelajaran, String nTugas, String nUts, String nUas) {
        this.nama = nama;
        this.nis = nis;
        this.pelajaran = pelajaran;
        this.nTugas = nTugas;
        this.nUts = nUts;
        this.nUas = nUas;
    }

    public String getNama() {
        return nama;
    }

    public String getNis() {
        return nis;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public String getnTugas() {
        return nTugas;
    }

    public String getnUts() {
        return nUts;
    }

    public String getnUas() {
        return nUas;
    }
}
