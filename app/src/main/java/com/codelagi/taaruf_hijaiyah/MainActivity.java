package com.codelagi.taaruf_hijaiyah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // deklarasi title pada appBar
    private String title = "Mode List";

    // panggil Mode List untuk data serta buat identifier
    private RecyclerView rvHijaiyah;

    //deklarasi dan panggil Kelas Hijaiyah dengan tipe data list
    private  ArrayList<Hijaiyah> list = new ArrayList<>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMenu(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMenu(int selectedMenu){
        switch (selectedMenu){
            case R.id.action_about_me:
                title = "About Me";
                aboutMe();
                break;
            case R.id.action_list_card_hihaiiah:
                title = "List Card";
                showReyclerCardView();
                break;
        }
    }

    public void aboutMe(){
        Intent moveAboutPage = new Intent(MainActivity.this, AboutMe.class);
        startActivity(moveAboutPage);
        }
    // override state OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // panggil activity oncreate dengan metode super
        super.onCreate(savedInstanceState);
        // tentukan tampilan layout mana yang digunakan
        setContentView(R.layout.activity_main);
        // setTitle yang sudah dideklarasikan
        setActionBarTitle(title);


        rvHijaiyah = findViewById(R.id.rv_hijaiyah);
        rvHijaiyah.setHasFixedSize(true);

        list.addAll(HijaiyahData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHijaiyah.setLayoutManager(new LinearLayoutManager(this));
        ListHijaiyahAdapter listHijaiyahAdapter = new ListHijaiyahAdapter(list);
        rvHijaiyah.setAdapter(listHijaiyahAdapter);
        setActionBarTitle(title);

        listHijaiyahAdapter.SetOnItemClickCallback(new ListHijaiyahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hijaiyah data) {
                showSelectedHijaiyah(data);

            }
        });
    }

    private void showReyclerCardView(){
        rvHijaiyah.setLayoutManager(new LinearLayoutManager(this));
        CardListHijaiyahAdapter cardListHijaiyahAdapter = new CardListHijaiyahAdapter(list);
        rvHijaiyah.setAdapter(cardListHijaiyahAdapter);
        cardListHijaiyahAdapter.SetOnItemClickCallback(new CardListHijaiyahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hijaiyah data) {
                showSelectedHijaiyah(data);

            }
        });
    }

    private void showSelectedHijaiyah(Hijaiyah hijaiyah) {
       Toast toast = Toast.makeText(this, "Makhraj " + hijaiyah.getName().toString()  + " " + hijaiyah.getDetail() , Toast.LENGTH_SHORT);
        toast.show();
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}