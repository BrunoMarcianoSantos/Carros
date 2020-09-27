package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class StageumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stageum);
        Bundle extras = getIntent().getExtras();
        TextView resultPotencia = findViewById(R.id.txtPot);
        try {
            TextView resultTorque = findViewById(R.id.txtTorquedois);
            TextView resultCilindrada = findViewById(R.id.txtCcdois);
            TextView resultAspiracao = findViewById(R.id.txtAspiracaodois);
            TextView resultTransmissao = findViewById(R.id.txtTransmissaodois);
            TextView resultPotencia1 = findViewById(R.id.txtPoten);
            TextView resultTorque1 = findViewById(R.id.txtTorque1);
            TextView resultCilindrada1 = findViewById(R.id.txtCc1);
            TextView resultAspiracao1 = findViewById(R.id.txtAspiracao1);
            TextView resultTransmissao1 = findViewById(R.id.txtTransmissao1);

            String potencia = extras.getString(MainActivity.EXTRA_MESSAGE_POTENCIA);
            String torque = extras.getString(MainActivity.EXTRA_MESSAGE_TORQUE);
            String cilindrada = extras.getString(MainActivity.EXTRA_MESSAGE_CILINDRADA);
            String aspiracao = extras.getString(MainActivity.EXTRA_MESSAGE_ASPIRACAO);
            String transmissao = extras.getString(MainActivity.EXTRA_MESSAGE_TRANSMISSAO);
            int potnova = Integer.parseInt(potencia);
            int tornova = Integer.parseInt(torque);
            int potencia2 = potnova + ((potnova * 10) / 100);
            int torque2 = tornova + ((tornova * 10) / 100);
            resultPotencia.setText(potencia);
            resultTorque.setText(torque);
            resultCilindrada.setText(cilindrada);
            resultAspiracao.setText(aspiracao);
            resultTransmissao.setText(transmissao);

            resultPotencia1.setText(Integer.toString(potencia2));
            resultTorque1.setText(Integer.toString(torque2));
            resultCilindrada1.setText(cilindrada);
            resultAspiracao1.setText(aspiracao);
            resultTransmissao1.setText(transmissao);
        }catch (Exception e){
            resultPotencia.setText("erro: " + e);
        }
    }

}