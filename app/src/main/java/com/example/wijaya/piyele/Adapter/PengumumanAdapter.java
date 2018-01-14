package com.example.wijaya.piyele.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wijaya.piyele.Model.DataNilai;
import com.example.wijaya.piyele.Model.DataPengumuman;
import com.example.wijaya.piyele.R;

import java.util.List;

/**
 * Created by Wijaya on 07-Jan-18.
 */

public class PengumumanAdapter extends ArrayAdapter<DataPengumuman> {

    private Activity context;
    private List<DataPengumuman> dataPengumumanList;

   public PengumumanAdapter (Activity context, List<DataPengumuman> dataPengumumanList) {
       super(context, R.layout.list_pengumuman, dataPengumumanList);
       this.context = context;
       this.dataPengumumanList = dataPengumumanList;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {

        //jika list siswa kosong
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_pengumuman, parent, false);
        }

        TextView zPengumuman = (TextView) listItemView.findViewById(R.id.tvIsiPengumuman);
        TextView zTgl = (TextView) listItemView.findViewById(R.id.tvIsiTanggal);

        DataPengumuman dataPengumuman = dataPengumumanList.get(position);

        zPengumuman.setText(dataPengumuman.getIsiPengumuman());
        zTgl.setText(dataPengumuman.getTanggalPengumuman());

        return listItemView;
    }
}
