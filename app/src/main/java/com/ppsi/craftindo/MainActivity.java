package com.ppsi.craftindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ppsi.craftindo.Adapter.CardViewProdukAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProduk;
    private ArrayList<Produk> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProduk = findViewById(R.id.rv_produk);
        rvProduk.setHasFixedSize(true);

        list.addAll(ProdukData.getListData());
        showRecyclerCardView();
    }

    private void  showRecyclerCardView(){
        rvProduk.setLayoutManager(new LinearLayoutManager(this));
        CardViewProdukAdapter cardViewProdukAdapter = new CardViewProdukAdapter(list);
        rvProduk.setAdapter(cardViewProdukAdapter);
    }
}
