package com.example.wijaya.piyele;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wijaya.piyele.Model.DataNilai;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuNilaiActivity extends AppCompatActivity {

    Button zbtnInput;
    EditText znama, znis, zmapel, ztgs, zuts, zuas;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nilai);

        databaseReference = FirebaseDatabase.getInstance().getReference("DAFTAR");

        znama = (EditText) findViewById(R.id.edtNama);
        znis = (EditText) findViewById(R.id.edtNis);
        zmapel = (EditText) findViewById(R.id.edtMapel);
        ztgs = (EditText) findViewById(R.id.edtTugas);
        zuts = (EditText) findViewById(R.id.edtUts);
        zuas = (EditText) findViewById(R.id.edtUas);

        zbtnInput = (Button) findViewById(R.id.btnInputNilai);
        zbtnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNilai();
            }
        });
    }

    public void addNilai() {
        String nama = znama.getText().toString();
        String nis = znis.getText().toString();
        String mapel = zmapel.getText().toString();
        String tgs = ztgs.getText().toString();
        String uts = zuts.getText().toString();
        String uas = zuas.getText().toString();

        if (nama.isEmpty() || nis.isEmpty() || mapel.isEmpty() || tgs.isEmpty() || uts.isEmpty() || uas.isEmpty()) {
            Toast.makeText(MenuNilaiActivity.this, "Daftar List Wajib Di isi !", Toast.LENGTH_SHORT).show();
        } else {
            String id = databaseReference.push().getKey();
            DataNilai dataNilai = new DataNilai(nama,nis,mapel,tgs,uts,uas);
            databaseReference.child(id).setValue(dataNilai);

            Toast.makeText(MenuNilaiActivity.this, "DATA TELAH DI SIMPAN", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuNilaiActivity.this, MenuGuruActivity.class);
            startActivity(intent);
        }
    }

}
