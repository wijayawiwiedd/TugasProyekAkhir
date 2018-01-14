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
import com.example.wijaya.piyele.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Wijaya on 07-Jan-18.
 */

public class NilaiAdapter extends ArrayAdapter<DataNilai> {

    private Activity context;
    private List<DataNilai> dataNilaiList;

    public NilaiAdapter (Activity context, List<DataNilai> dataNilaiList) {
        super(context, R.layout.list_siswa, dataNilaiList);

        this.context = context;
        this.dataNilaiList = dataNilaiList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {

        //jika list siswa kosong
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_siswa, parent, false);
        }

        TextView zPelajaran = (TextView) listItemView.findViewById(R.id.tvIsiPelajaran);
        TextView zTugas = (TextView) listItemView.findViewById(R.id.tvIsiTugas);
        TextView zUts = (TextView) listItemView.findViewById(R.id.tvIsiUts);
        TextView zUas = (TextView) listItemView.findViewById(R.id.tvIsiUas);
        TextView zNama = (TextView) listItemView.findViewById(R.id.tvListNama);
        TextView zNis = (TextView) listItemView.findViewById(R.id.tvListNis);

        DataNilai dataNilai = dataNilaiList.get(position);

        zPelajaran.setText(dataNilai.getPelajaran());
        zTugas.setText(dataNilai.getnTugas());
        zUts.setText(dataNilai.getnUts());
        zUas.setText(dataNilai.getnUas());
        zNama.setText(dataNilai.getNama());
        zNis.setText(dataNilai.getNis());

        return listItemView;
    }
}
