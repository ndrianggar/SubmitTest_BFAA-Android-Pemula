package com.codelagi.taaruf_hijaiyah;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class ListHijaiyahAdapter extends RecyclerView.Adapter<ListHijaiyahAdapter.ListViewHolder> {
    private ArrayList<Hijaiyah> listHijaiyah;
    private OnItemClickCallback onItemClickCallback;

    void SetOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    ListHijaiyahAdapter(ArrayList<Hijaiyah> list){this.listHijaiyah = list;}

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hijaiyah, viewGroup,false);
    return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hijaiyah hijaiyah = listHijaiyah.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hijaiyah.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(hijaiyah.getName());
        holder.tvDetail.setText(hijaiyah.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHijaiyah.get(holder.getAdapterPosition()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return listHijaiyah.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnDetail =itemView.findViewById(R.id.btn_set_detail);
        }
    }


    public interface OnItemClickCallback {
        void onItemClicked(Hijaiyah data);
    }
}
