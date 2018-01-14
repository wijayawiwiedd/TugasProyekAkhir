package com.example.wijaya.piyele;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuGuruActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_guru);

        getSupportActionBar().hide();
    }

    public void btnNilai(View view) {
        Intent intent = new Intent(MenuGuruActivity.this, MenuNilaiActivity.class);
        startActivity(intent);
    }

    public void btnPengumuman(View view) {
        Intent intent = new Intent(MenuGuruActivity.this, PengumumanActivity.class);
        startActivity(intent);
    }
}
