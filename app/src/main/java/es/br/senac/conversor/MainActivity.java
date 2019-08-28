package es.br.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

//declarando uma classe
//extends AppCompatActivity é uma herança de classe
public class MainActivity extends AppCompatActivity {

    int alturaEmCentimetro=0;

    private String formataValorComDoisDigitos(int valor){
        String retorno = String.format(Locale.FRANCE,"%.2f", valor);
        return "retorno da funçao";

    }

    // metodo que declara o ciclo de criação da tela...
    //Override sobre escreve um metodo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //declaração de metodo
        super.onCreate(savedInstanceState);
        // metodo que liga a Activity.java com o java
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        final TextView textMetros = (TextView) findViewById(R.id.textMetros);

        textMetros.setText(String.valueOf(alturaEmCentimetro));

        final TextView textAltura = (TextView) findViewById(R.id.textAltura);

        // textAltura.setText("asaasaa");

        final TextView textPes = (TextView) findViewById(R.id.textPes);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.skMetros);

        final Button button = (Button) findViewById(R.id.btmConverter);

        seekBar.setMax(230);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                alturaEmCentimetro = progress;
                //textMetros.setText(progress + "centimetro");

                textMetros.setText(formataValorComDoisDigitos(20));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}


