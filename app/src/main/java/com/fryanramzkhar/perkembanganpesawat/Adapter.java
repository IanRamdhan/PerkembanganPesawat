package com.fryanramzkhar.perkembanganpesawat;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    int[] gambarPesawat;
    String[] namaPesawat,detailPesawat;

    public Adapter(Context context, int[] gambarPesawat, String[] namaPesawat, String[] detailPesawat) {
        this.context = context;
        this.gambarPesawat = gambarPesawat;
        this.namaPesawat = namaPesawat;
        this.detailPesawat = detailPesawat;
    }
    @NonNull
    @Override

    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pesawat,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaPesawat[i]);
        Glide.with(context).load(gambarPesawat[i]).into(viewHolder.imgPesawat);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailPesawat.class);
                pindah.putExtra("np", namaPesawat[i]);
                pindah.putExtra("dp", detailPesawat[i]);
                pindah.putExtra("gp", gambarPesawat[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarPesawat.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPesawat;
        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPesawat = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);

        }
    }
}