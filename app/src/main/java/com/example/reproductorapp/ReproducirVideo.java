package com.example.reproductorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReproducirVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir_video);

        VideoView miVideo=(VideoView)findViewById(R.id.videoView);

        MediaController mController=new MediaController(this);
        miVideo.setMediaController(mController);

        miVideo.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.siempre));

        miVideo.requestFocus();
    }
}
