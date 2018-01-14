package com.example.wijaya.piyele;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuWaliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_wali);

        getSupportActionBar().hide();
    }

    public void daftarNilai(View view) {
        Intent intent = new Intent(MenuWaliActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void daftarPengumuman(View view) {
        Intent intent = new Intent(MenuWaliActivity.this, ReadPengumumanActivity.class);
        startActivity(intent);
    }
}
