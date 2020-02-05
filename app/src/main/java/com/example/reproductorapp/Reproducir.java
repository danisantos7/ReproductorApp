package com.example.reproductorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Reproducir extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void reproducirMusica(View v){
        Intent intent=new Intent(this, ReproducirMusica.class);
        startActivity(intent);
    }

    public void reproducirVideo(View v){
        Intent intent=new Intent(this, ReproducirVideo.class);
        startActivity(intent);
    }
}
