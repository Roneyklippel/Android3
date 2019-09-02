package es.br.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import java.util.Locale;

//declarando uma classe
//extends AppCompatActivity é uma herança de classe
// é o classe MainActivity
// é a herança extends
public class MainActivity extends AppCompatActivity {

    // declaração de uma variavél
    // int significa inteiro
    //=0 é de onde ela vai inicializar
    int alturaEmCentimetro=0;

    int altura1=150;
    int altura2=180;
    int altura3=205;


    int SeekBar;





    // metodo que declara o ciclo de criação da tela...
    //Override sobre escreve um metodo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //declaração de metodo
        // quando tem super e o nome do metodo ele está indo no pai e buscando tudo que tem lá
        super.onCreate(savedInstanceState);
        // metodo que liga a Activity.java com o java
        setContentView(R.layout.activity_main);

        // instancia de um elemento de texto do android
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);

        txtMetros.setText(String.valueOf(alturaEmCentimetro));

        final TextView txtMedia = (TextView) findViewById(R.id.txtMedia);

        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar4 = (SeekBar)findViewById(R.id.seekBar4);
        seekBar4.setMax(230);

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
             txtPes.setText("Toque em Converter");
            }


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                alturaEmCentimetro = progress;
                //textMetros.setText(progress + "centimetro");
                String texto = formataValorComDoisDigitos(progress / 100.0);
                texto +="m.";
                SeekBar = progress;
                txtMetros.setText(texto);

            }



        });

        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double alturaEmPes = alturaEmCentimetro / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += "pé(s)";
                txtPes.setText(texto);

               int media = calcularMedia(altura1,altura2,altura3);

               if (SeekBar > media){
                   txtMedia.setText("Alto");

               }else if(SeekBar==media){
                   txtMedia.setText("Na média");
               }else{
                   txtMedia.setText("Baixo");
               }
            }
        });



        }
        //declarando um metodo ou função
        // metodo protegido private só propria classe acessa e o protec a propia classe acessa e quem herda
        //(double valor) é um argumeto da função
      //formataValorComDoisDigitos é o nome da função (ou metodo)
    private String formataValorComDoisDigitos(double valor){
        //convertendo a String em double
        return String.format(Locale.FRANCE, "%.2f",valor);
    }

    private int calcularMedia (int valor1, int valor2, int valor3){
        return (valor1+valor2+valor3) / 3;
    }
}


