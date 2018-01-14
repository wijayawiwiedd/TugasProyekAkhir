package com.example.wijaya.piyele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wijaya.piyele.Adapter.NilaiAdapter;
import com.example.wijaya.piyele.Model.DataNilai;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;

    List<DataNilai> dataNilaiList;

    private ValueEventListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("DAFTAR");
        listView = (ListView) findViewById(R.id.listViewSiswa);

        dataNilaiList = new ArrayList<>();

        //data tampil
        fetchData();

    }

    public void fetchData() {
        mListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot daftarSnapshot : dataSnapshot.getChildren()) {
                    DataNilai dataNilai = daftarSnapshot.getValue(DataNilai.class);
                    dataNilaiList.add(dataNilai);
                }
                NilaiAdapter adapter = new NilaiAdapter(MainActivity.this, dataNilaiList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addListenerForSingleValueEvent(mListener);
    }
}
