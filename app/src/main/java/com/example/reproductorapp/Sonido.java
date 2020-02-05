package com.example.reproductorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class Sonido extends AppCompatActivity {
    private MediaRecorder miGrabacion;
    private String outputFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void grabar(View view) {
        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/MiGrabacion.3gp";
        miGrabacion = new MediaRecorder();
        miGrabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabacion.setOutputFormat(MediaRecorder.OutputFormat.
                THREE_GPP);
        miGrabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        miGrabacion.setOutputFile(outputFile);

        try {
            miGrabacion.prepare();
            miGrabacion.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Grabando", Toast.LENGTH_LONG).show();
    }

    public void detener(View view) {
        if (miGrabacion != null) {
            miGrabacion.stop();
            miGrabacion.release();
            miGrabacion = null;
            Toast.makeText(getApplicationContext(), "El audio se ha grabado con éxito", Toast.LENGTH_LONG).show();
        }
    }

    public void reproducir(View view) {
        MediaPlayer m_reproducir = new MediaPlayer();
        try {
            m_reproducir.setDataSource(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            m_reproducir.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        m_reproducir.start();
        Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_LONG).show();
    }
}
