package com.ppsi.craftindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String PRODUK_NAME = "name";
    public static final String PRODUK_DETAIL = "detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvNamaProduk = findViewById(R.id.tv_nama_produk);
        TextView tvDetialProduk = findViewById(R.id.tv_detail_produk);
        ImageView ivPhotoProduk = findViewById(R.id.iv_photo_produk);

        String mNamaProduk = getIntent().getStringExtra(PRODUK_NAME);
        String mDetailProduk = getIntent().getStringExtra(PRODUK_DETAIL);
        int mPhotoProduk = getIntent().getIntExtra("photo",0);

        tvNamaProduk.setText(mNamaProduk);
        tvDetialProduk.setText(mDetailProduk);
        ivPhotoProduk.setImageResource(mPhotoProduk);
    }
}
