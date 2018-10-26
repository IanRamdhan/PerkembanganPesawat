package com.fryanramzkhar.perkembanganpesawat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclePesawat extends AppCompatActivity {

    @BindView(R.id.my_recycle_pesawat)
    RecyclerView myRecyclePesawat;

    String[] namaPesawat,detailPesawat;
    int[] gambarPesawat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_pesawat);
        ButterKnife.bind(this);

        namaPesawat = getResources().getStringArray(R.array.sejarah_pesawat);
        detailPesawat = getResources().getStringArray(R.array.detail_pesawat);
        gambarPesawat = new int[]{R.drawable.ornithoper,R.drawable.zeppelin,R.drawable.triplane,R.drawable.fokker,R.drawable.boeing,R.drawable.airbus};

        Adapter adapter = new Adapter(RecyclePesawat.this, gambarPesawat, namaPesawat, detailPesawat);
        myRecyclePesawat.setHasFixedSize(true);
        myRecyclePesawat.setLayoutManager(new LinearLayoutManager(RecyclePesawat.this));
        myRecyclePesawat.setAdapter(adapter);
    }
}
