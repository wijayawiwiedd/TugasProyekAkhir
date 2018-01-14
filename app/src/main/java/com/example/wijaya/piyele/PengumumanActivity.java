package com.example.wijaya.piyele;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wijaya.piyele.Model.DataPengumuman;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PengumumanActivity extends AppCompatActivity {

    EditText pengumuman;
    TextView tgl;
    Calendar date;
    int day, month, year;
    String tanggal;

    Button btnPengumuman;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman);

        databaseReference = FirebaseDatabase.getInstance().getReference("PENGUMUMAN");

        pengumuman = (EditText) findViewById(R.id.txtpengumuman);
        tgl = (TextView) findViewById(R.id.txtdate);

        date = Calendar.getInstance();

        day = date.get(Calendar.DAY_OF_MONTH);
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);

        month = month + 1;
        tanggal = ""+day+"/"+month+"/"+year;
        tgl.setText(tanggal);

        tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(PengumumanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        tanggal = ""+dayOfMonth+"/"+month+"/"+year;
                        tgl.setText(tanggal);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        } );

        btnPengumuman = (Button) findViewById(R.id.btnPeng);
        btnPengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPengumuman();
            }
        });
    }

    public void addPengumuman() {
        String peng = pengumuman.getText().toString();

        if (peng.isEmpty() || tanggal.isEmpty()) {
            Toast.makeText(PengumumanActivity.this, "Daftar Wajib Di Isi !", Toast.LENGTH_SHORT).show();
        } else {
            String id = databaseReference.push().getKey();
            DataPengumuman dataPengumuman = new DataPengumuman(peng,tanggal);
            databaseReference.child(id).setValue(dataPengumuman);

            Toast.makeText(PengumumanActivity.this, "Pengumuman Terkirim", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
