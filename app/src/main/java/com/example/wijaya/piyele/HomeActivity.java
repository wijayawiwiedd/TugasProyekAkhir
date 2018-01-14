package com.example.wijaya.piyele;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
    }

    public void btnGuru(View view) {
        Intent intent = new Intent(HomeActivity.this, MenuGuruActivity.class);
        startActivity(intent);
    }

    public void btnWali(View view) {
        Intent intent = new Intent(HomeActivity.this, MenuWaliActivity.class);
        startActivity(intent);
    }

    public void btnLogout(View view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
