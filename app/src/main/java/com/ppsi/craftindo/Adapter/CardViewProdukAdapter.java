package com.ppsi.craftindo.Adapter;

import android.content.Intent;
import android.os.Bundle;
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
import com.ppsi.craftindo.DetailActivity;
import com.ppsi.craftindo.Produk;
import com.ppsi.craftindo.R;

import java.util.ArrayList;

public class CardViewProdukAdapter extends RecyclerView.Adapter<CardViewProdukAdapter.CardViewViewHolder> {
    private ArrayList<Produk> listProduk;

    public CardViewProdukAdapter (ArrayList<Produk> list) {
        this.listProduk = list;
    }

    @NonNull
    @Override
    public CardViewProdukAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_produk, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewProdukAdapter.CardViewViewHolder holder, final int position) {
        final Produk produk = listProduk.get(position);

        Glide.with(holder.itemView.getContext())
                .load(produk.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(produk.getName());
        holder.tvDetail.setText(produk.getDetail());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                moveIntent.putExtra(DetailActivity.PRODUK_NAME, produk.getName());
                moveIntent.putExtra(DetailActivity.PRODUK_DETAIL, produk.getDetail());
                moveIntent.putExtra("photo", listProduk.get(position).getPhoto());
                holder.itemView.getContext().startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnBuy, btnDetail;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnBuy = itemView.findViewById(R.id.btn_set_buy);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
        }
    }
}
