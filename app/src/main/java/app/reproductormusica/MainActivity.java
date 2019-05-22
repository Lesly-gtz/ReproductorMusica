package app.reproductormusica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pausa, stop, siguiente, anterior;
    MediaPlayer mp;
    ImageView iv;
    TextView cancion, cantante;
    int posicion = 0;

    MediaPlayer vector[] = new MediaPlayer[6];
    /*Arreglo de imagenes*/
     int[] image ={
              R.drawable.exo,
              R.drawable.pentagon,
              R.drawable.redvelvet,
              R.drawable.seventeen,
              R.drawable.shinee,
              R.drawable.superjunior
      };
     /*Arreglo de datos*/
    String [][]datos={
             {"Power", "EXO"},
             {"Shine", "Pentagon"},
             {"Red Flavor", "Red Velvet"},
             {"Home", "Seventeen"},
             {"Good Evening", "SHINee"},
             {"Black Suit", "Super Junior"}
     };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stop = (Button) findViewById(R.id.btn_stop);
        siguiente = (Button) findViewById(R.id.btn_siguiente);
        anterior = (Button) findViewById(R.id.btn_anterior);
        play_pausa = (Button) findViewById(R.id.btnPlay);
        iv = (ImageView) findViewById(R.id.imageView);
        cancion = (TextView)findViewById(R.id.textCancion);
        cantante = (TextView)findViewById(R.id.textCantante);


        /*Agregar Canciones*/
        vector[0] = MediaPlayer.create(this, R.raw.exo);
        cancion.setText(datos[0][0]);
        cantante.setText(datos[0][1]);
        vector[1] = MediaPlayer.create(this, R.raw.pentagon);
        vector[2] = MediaPlayer.create(this, R.raw.redvelvet);
        vector[3] = MediaPlayer.create(this, R.raw.seventeen);
        vector[4] = MediaPlayer.create(this, R.raw.shinee);
        vector[5] = MediaPlayer.create(this, R.raw.superjunior);

        play_pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vector[posicion].isPlaying()) {
                    vector[posicion].pause();
                    play_pausa.setBackgroundResource(R.drawable.play);
                    Toast.makeText(getApplicationContext(), "Pausa", Toast.LENGTH_SHORT).show();
                } else {
                    vector[posicion].start();
                    play_pausa.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vector[posicion] != null) {
                    vector[posicion].stop();

                    vector[0] = MediaPlayer.create(getApplicationContext(), R.raw.exo);
                    vector[1] = MediaPlayer.create(getApplicationContext(), R.raw.pentagon);
                    vector[2] = MediaPlayer.create(getApplicationContext(), R.raw.redvelvet);
                    vector[3] = MediaPlayer.create(getApplicationContext(), R.raw.seventeen);
                    vector[4] = MediaPlayer.create(getApplicationContext(), R.raw.shinee);
                    vector[5] = MediaPlayer.create(getApplicationContext(), R.raw.superjunior);
                    posicion = 0;
                    play_pausa.setBackgroundResource(R.drawable.play);
                    iv.setImageResource(R.drawable.exo);
                    cancion.setText(datos[0][0]);
                    cantante.setText(datos[0][1]);
                    Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
                }
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion < vector.length - 1) {
                    if (vector[posicion].isPlaying()) {
                        vector[posicion].stop();
                        posicion++;
                        vector[posicion].start();

                        if (posicion == 0){
                            iv.setImageResource(image[0]);
                            cancion.setText(datos[0][0]);
                            cantante.setText(datos[0][1]);
                        }
                        else if (posicion == 1){
                            iv.setImageResource(image[1]);
                            cancion.setText(datos[1][0]);
                            cantante.setText(datos[1][1]);
                        }
                        else if (posicion == 2){
                            iv.setImageResource(image[2]);
                            cancion.setText(datos[2][0]);
                            cantante.setText(datos[2][1]);
                        }
                        else if (posicion == 3){
                            iv.setImageResource(image[3]);
                            cancion.setText(datos[3][0]);
                            cantante.setText(datos[3][1]);
                        }
                        else if (posicion == 4){
                            iv.setImageResource(image[4]);
                            cancion.setText(datos[4][0]);
                            cantante.setText(datos[4][1]);
                        }
                        else if (posicion == 5){
                            iv.setImageResource(image[5]);
                            cancion.setText(datos[5][0]);
                            cantante.setText(datos[5][1]);
                        }
                    }
                    else {
                        posicion++;

                        if (posicion == 0){
                            iv.setImageResource(image[0]);
                            cancion.setText(datos[0][0]);
                            cantante.setText(datos[0][1]);
                        }
                        else if (posicion == 1){
                            iv.setImageResource(image[1]);
                            cancion.setText(datos[1][0]);
                            cantante.setText(datos[1][1]);
                        }
                        else if (posicion == 2){
                            iv.setImageResource(image[2]);
                            cancion.setText(datos[2][0]);
                            cantante.setText(datos[2][1]);
                        }
                        else if (posicion == 3){
                            iv.setImageResource(image[3]);
                            cancion.setText(datos[3][0]);
                            cantante.setText(datos[3][1]);
                        }
                        else if (posicion == 4){
                            iv.setImageResource(image[4]);
                            cancion.setText(datos[4][0]);
                            cantante.setText(datos[4][1]);
                        }
                        else if (posicion == 5){
                            iv.setImageResource(image[5]);
                            cancion.setText(datos[5][0]);
                            cantante.setText(datos[5][1]);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion >= 1) {
                    if (vector[posicion].isPlaying()) {
                        vector[posicion].stop();
                        vector[0] = MediaPlayer.create(getApplicationContext(), R.raw.exo);
                        vector[1] = MediaPlayer.create(getApplicationContext(), R.raw.pentagon);
                        vector[2] = MediaPlayer.create(getApplicationContext(), R.raw.redvelvet);
                        vector[3] = MediaPlayer.create(getApplicationContext(), R.raw.seventeen);
                        vector[4] = MediaPlayer.create(getApplicationContext(), R.raw.shinee);
                        vector[5] = MediaPlayer.create(getApplicationContext(), R.raw.superjunior);
                        posicion--;
                        vector[posicion].start();

                        if (posicion == 0){
                            iv.setImageResource(image[0]);
                            cancion.setText(datos[0][0]);
                            cantante.setText(datos[0][1]);
                        }
                        else if (posicion == 1){
                            iv.setImageResource(image[1]);
                            cancion.setText(datos[1][0]);
                            cantante.setText(datos[1][1]);
                        }
                        else if (posicion == 2){
                            iv.setImageResource(image[2]);
                            cancion.setText(datos[2][0]);
                            cantante.setText(datos[2][1]);
                        }
                        else if (posicion == 3){
                            iv.setImageResource(image[3]);
                            cancion.setText(datos[3][0]);
                            cantante.setText(datos[3][1]);
                        }
                        else if (posicion == 4){
                            iv.setImageResource(image[4]);
                            cancion.setText(datos[4][0]);
                            cantante.setText(datos[4][1]);
                        }
                        else if (posicion == 5){
                            iv.setImageResource(image[5]);
                            cancion.setText(datos[5][0]);
                            cantante.setText(datos[5][1]);
                        }
                    } else {
                        posicion--;

                        if (posicion == 0){
                            iv.setImageResource(image[0]);
                            cancion.setText(datos[0][0]);
                            cantante.setText(datos[0][1]);
                        }
                        else if (posicion == 1){
                            iv.setImageResource(image[1]);
                            cancion.setText(datos[1][0]);
                            cantante.setText(datos[1][1]);
                        }
                        else if (posicion == 2){
                            iv.setImageResource(image[2]);
                            cancion.setText(datos[2][0]);
                            cantante.setText(datos[2][1]);
                        }
                        else if (posicion == 3){
                            iv.setImageResource(image[3]);
                            cancion.setText(datos[3][0]);
                            cantante.setText(datos[3][1]);
                        }
                        else if (posicion == 4){
                            iv.setImageResource(image[4]);
                            cancion.setText(datos[4][0]);
                            cantante.setText(datos[4][1]);
                        }
                        else if (posicion == 5){
                            iv.setImageResource(image[5]);
                            cancion.setText(datos[5][0]);
                            cantante.setText(datos[5][1]);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
