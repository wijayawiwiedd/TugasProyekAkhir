package com.example.wijaya.piyele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wijaya.piyele.Adapter.PengumumanAdapter;
import com.example.wijaya.piyele.Model.DataNilai;
import com.example.wijaya.piyele.Model.DataPengumuman;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadPengumumanActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;

    List<DataPengumuman> dataPengumumanList;

    private ValueEventListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_pengumuman);

        databaseReference = FirebaseDatabase.getInstance().getReference("PENGUMUMAN");
        listView = (ListView) findViewById(R.id.listPengumuman);

        dataPengumumanList = new ArrayList<>();

        getData();

    }

    public void getData() {
        mListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot daftarSnapshot : dataSnapshot.getChildren()) {
                    DataPengumuman dataPengumuman = daftarSnapshot.getValue(DataPengumuman.class);
                    dataPengumumanList.add(dataPengumuman);
                }
                PengumumanAdapter pengumumanAdapter = new PengumumanAdapter(ReadPengumumanActivity.this, dataPengumumanList);
                listView.setAdapter(pengumumanAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addListenerForSingleValueEvent(mListener);

    }
}
