package com.codelagi.taaruf_hijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHijaiyah extends AppCompatActivity {

    public static final String DATA_JUDUL = "Data_JUDUL";
    public static final String DATA_DETAIL_HURUF = "Data_Detail_Huruf";
    public static final String DATA_BG_BELAKANG = "DATA_BG_BELAKANG";
    public static final String DATA_ICON_LITLE = "DATA_ICON_LITLE";
    private String title = "Mode Detail";
    Button btnGoBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hijaiyah);
        setActionBarTitle(title);
        ImageView imageViewBg, imageViewLittle;
        TextView content_huruf_detail, judul;

        imageViewBg = findViewById(R.id.data_terima_bg_belakang);
        imageViewLittle = findViewById(R.id.data_terima_img_kecil);

        content_huruf_detail = findViewById(R.id.data_terima_content_huruf);
        judul = findViewById(R.id.data_terima_judul);
        btnGoBack = findViewById(R.id.btn_back);

        String textDetail = getIntent().getStringExtra(DATA_DETAIL_HURUF);
        int image = getIntent().getIntExtra(DATA_BG_BELAKANG,0);
        String textJudul = getIntent().getStringExtra(DATA_JUDUL);
        int imageLittle = getIntent().getIntExtra(DATA_ICON_LITLE,0);


        imageViewBg.setImageResource(image);
        content_huruf_detail.setText(textDetail);
        judul.setText(textJudul);
        imageViewLittle.setImageResource(imageLittle);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);// New activity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}