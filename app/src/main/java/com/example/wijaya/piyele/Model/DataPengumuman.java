package com.example.wijaya.piyele.Model;

/**
 * Created by Wijaya on 07-Jan-18.
 */

public class DataPengumuman {

    String isiPengumuman;
    String tanggalPengumuman;

    public DataPengumuman() {

    }

    public DataPengumuman(String isiPengumuman, String tanggalPengumuman) {
        this.isiPengumuman = isiPengumuman;
        this.tanggalPengumuman = tanggalPengumuman;
    }

    public String getIsiPengumuman() {
        return isiPengumuman;
    }

    public String getTanggalPengumuman() {
        return tanggalPengumuman;
    }
}
