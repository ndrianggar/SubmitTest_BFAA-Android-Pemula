package com.codelagi.taaruf_hijaiyah;

import android.app.Instrumentation;
import android.content.Intent;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Arrays;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class CardListHijaiyahAdapter extends RecyclerView.Adapter<CardListHijaiyahAdapter.CardListHijaiyahHolder>{

   private ArrayList<Hijaiyah> listHijaiyah;
   private OnItemClickCallback onItemClickCallback;
    private String title = "Mode Card";


    void SetOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public CardListHijaiyahAdapter(ArrayList<Hijaiyah> list){
       this.listHijaiyah = list;
   }
    @NonNull
    @Override
    public CardListHijaiyahHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_cardhijaiyah, viewGroup, false);
        return new CardListHijaiyahHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListHijaiyahAdapter.CardListHijaiyahHolder holder, int position) {
        Hijaiyah hijaiyah = listHijaiyah.get(position);



        Glide.with(holder.itemView.getContext())
                .load(hijaiyah.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(hijaiyah.getName());
        holder.tvDetail.setText(hijaiyah.getDetail());
        holder.imgPhoto.setImageResource(hijaiyah.getPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHijaiyah.get(holder.getAdapterPosition()));
            }
        });

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_set_detail) {
                    Intent intentDetail = new Intent(v.getContext(), DetailHijaiyah.class);
                    intentDetail.putExtra(DetailHijaiyah.DATA_JUDUL, hijaiyah.getName());
                    intentDetail.putExtra(DetailHijaiyah.DATA_DETAIL_HURUF, hijaiyah.getDetail());
                    intentDetail.putExtra(DetailHijaiyah.DATA_BG_BELAKANG, hijaiyah.getPhoto());
                    v.getContext().startActivity(intentDetail);
                }
            }

        });


    }
    @Override
    public int getItemCount() {
        return listHijaiyah.size();
    }

    public class CardListHijaiyahHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnDetail, btnBack;


        public CardListHijaiyahHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);

        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Hijaiyah data);
    }


}
