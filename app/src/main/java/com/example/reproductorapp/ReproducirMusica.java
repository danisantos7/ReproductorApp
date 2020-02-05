package com.example.reproductorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ReproducirMusica extends AppCompatActivity {
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView imagen;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir_musica);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        play_pause = (Button)findViewById(R.id.btn_playpause);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        imagen = (ImageView)findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.etapasraras);
        vectormp[1] = MediaPlayer.create(this, R.raw.cicatrices);
        vectormp[2] = MediaPlayer.create(this, R.raw.lento);

    }
    //Método para play pause
    public void playPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pause);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para parar canción
    public void stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.etapasraras);
            vectormp[1] = MediaPlayer.create(this, R.raw.cicatrices);
            vectormp[2] = MediaPlayer.create(this, R.raw.lento);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            imagen.setImageResource(R.drawable.cancion1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para repetir una canción
    public void repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repitiendo);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Método para saltar canción
    public void siguiente(View view){
        if(posicion < vectormp.length -1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    imagen.setImageResource(R.drawable.cancion1);
                } else if(posicion == 1){
                    imagen.setImageResource(R.drawable.cancion2);
                }else if(posicion == 2){
                    imagen.setImageResource(R.drawable.cancion3);
                }

            } else {
                posicion++;

                if(posicion == 0){
                    imagen.setImageResource(R.drawable.cancion1);
                } else if(posicion == 1){
                    imagen.setImageResource(R.drawable.cancion2);
                }else if(posicion == 2){
                    imagen.setImageResource(R.drawable.cancion3);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }


    //Método para regresar a la canción anterior
    public void anterior(View view) {
        if (posicion >= 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.etapasraras);
                vectormp[1] = MediaPlayer.create(this, R.raw.cicatrices);
                vectormp[2] = MediaPlayer.create(this, R.raw.lento);
                posicion--;

                if (posicion == 0) {
                    imagen.setImageResource(R.drawable.cancion1);
                } else if (posicion == 1) {
                    imagen.setImageResource(R.drawable.cancion2);
                } else if (posicion == 2) {
                    imagen.setImageResource(R.drawable.cancion3);
                }

                vectormp[posicion].start();

            } else {
                posicion--;

                if (posicion == 0) {
                    imagen.setImageResource(R.drawable.cancion1);
                } else if (posicion == 1) {
                    imagen.setImageResource(R.drawable.cancion2);
                } else if (posicion == 2) {
                    imagen.setImageResource(R.drawable.cancion3);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
