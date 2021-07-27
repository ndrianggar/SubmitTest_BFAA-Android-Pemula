package com.codelagi.taaruf_hijaiyah;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity implements View.OnClickListener {
    private String title = "Profile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);
        setActionBarTitle(title);
        Button buttonCall = findViewById(R.id.btn_set_callme);
            buttonCall.setOnClickListener(this);
        Button buttonShare = findViewById(R.id.btn_set_share);
        buttonShare.setOnClickListener(this);
        }

    private void callMe(){
        String phoneNumber = "081911084103";
        Intent dialPhoneMe = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(dialPhoneMe);
    }

    public void ShareText(){
        Uri imageMe = Uri.parse("android.resource://" + getPackageName()
                + "/drawable/" + "about.jpg");
        TextView textView = findViewById(R.id.about_me);
        Intent shareAboutMe = new Intent(Intent.ACTION_SEND);
        shareAboutMe.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        shareAboutMe.putExtra(Intent.EXTRA_STREAM, imageMe);
        shareAboutMe.setType("image/jpeg");
        shareAboutMe.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareAboutMe, "send"));
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_set_callme){
            callMe();
        }else if(v.getId() == R.id.btn_set_share){
            ShareText();
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
