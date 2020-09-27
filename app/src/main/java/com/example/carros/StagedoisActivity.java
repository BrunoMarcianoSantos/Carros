package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StagedoisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagedois);
        Bundle extras = getIntent().getExtras();
        TextView resultPotencia = findViewById(R.id.txtPotenciadois2);
        try {
            TextView resultTorque = findViewById(R.id.txtTorquedois2);
            TextView resultCilindrada = findViewById(R.id.txtCcdois2);
            TextView resultAspiracao = findViewById(R.id.txtAspiracaodois2);
            TextView resultTransmissao = findViewById(R.id.txtTransmissaodois2);
            TextView resultPotencia1 = findViewById(R.id.txtPotencia2);
            TextView resultTorque1 = findViewById(R.id.txtTorque2);
            TextView resultCilindrada1 = findViewById(R.id.txtCc2);
            TextView resultAspiracao1 = findViewById(R.id.txtAspiracao2);
            TextView resultTransmissao1 = findViewById(R.id.txtTransmissao2);

            String potencia = extras.getString(MainActivity.EXTRA_MESSAGE_POTENCIA);
            String torque = extras.getString(MainActivity.EXTRA_MESSAGE_TORQUE);
            String cilindrada = extras.getString(MainActivity.EXTRA_MESSAGE_CILINDRADA);
            String aspiracao = extras.getString(MainActivity.EXTRA_MESSAGE_ASPIRACAO);
            String transmissao = extras.getString(MainActivity.EXTRA_MESSAGE_TRANSMISSAO);
            int potnova = Integer.parseInt(potencia);
            int tornova = Integer.parseInt(torque);
            int potencia2 = potnova + ((potnova * 20) / 100);
            int torque2 = tornova + ((tornova * 20) / 100);
            resultPotencia.setText(potencia);
            resultTorque.setText(torque);
            resultCilindrada.setText(cilindrada);
            resultAspiracao.setText(aspiracao);
            resultTransmissao.setText(transmissao);

            resultPotencia1.setText(Integer.toString(potencia2));
            resultTorque1.setText(Integer.toString(torque2));
            resultCilindrada1.setText(cilindrada);
            resultAspiracao1.setText("Turbo");
            resultTransmissao1.setText(transmissao);
        }catch (Exception e){
            resultPotencia.setText("Erro: " + e);
        }
    }
}