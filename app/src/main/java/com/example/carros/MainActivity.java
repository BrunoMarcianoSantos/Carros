package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensorLuminosity;
    public final static String EXTRA_MESSAGE_POTENCIA = "com.example.carros.POTENCIA";
    public final static String EXTRA_MESSAGE_TORQUE = "com.example.carros.TORQUE";
    public final static String EXTRA_MESSAGE_CILINDRADA = "com.example.carros.CILINDRADA";
    public final static String EXTRA_MESSAGE_ASPIRACAO = "com.example.carros.ASPIRACAO";
    public final static String EXTRA_MESSAGE_TRANSMISSAO = "com.example.carros.TRANSMISSAO";
    private final String VALOR_POTENCIA = "com.example.carros.POTENCIA";
    private final String VALOR_TORQUE = "com.example.carros.TORQUE";
    private final String VALOR_CILINDRADA = "com.example.carros.CILINDRADA";

    EditText savePotencia;
    EditText saveTorque;
    EditText saveCilindrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        sensorLuminosity = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        savePotencia = (EditText) findViewById(R.id.txtPotencia);
        saveTorque = (EditText) findViewById(R.id.txtTorque);
        saveCilindrada = (EditText) findViewById(R.id.txtCc);


        if (savedInstanceState != null) {
            savePotencia.setText(savedInstanceState.getString(VALOR_POTENCIA));
            saveTorque.setText(savedInstanceState.getString(VALOR_TORQUE));
            saveCilindrada.setText(savedInstanceState.getString(VALOR_CILINDRADA));
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensorLuminosity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        int valor = Math.round(sensorEvent.values[0]);


        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.screenBrightness = valor;
            getWindow().setAttributes(lp);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstance)
    {
        super.onSaveInstanceState(saveInstance);
        saveInstance.putString(VALOR_POTENCIA, savePotencia.getText().toString());
        saveInstance.putString(VALOR_TORQUE, saveTorque.getText().toString());
        saveInstance.putString(VALOR_CILINDRADA, saveCilindrada.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance) {
        super.onRestoreInstanceState(savedInstance);
        String valorpotencia = savedInstance.getString(VALOR_POTENCIA);
        /*int valorpotfinal = Integer.parseInt(valorpotencia);*/
        savePotencia.setText(valorpotencia);
        String valortorque = savedInstance.getString(VALOR_TORQUE);
        /*int valortorfinal = Integer.parseInt(valortorque);*/
        saveTorque.setText(valortorque);
        String valorcilindrada = savedInstance.getString(VALOR_CILINDRADA);
        /*int valorccfinal = Integer.parseInt(valorcilindrada);*/
        saveCilindrada.setText(valorcilindrada);
    }

    public void EnviarStageum (View v)
    {
        EditText txtPotencia = findViewById(R.id.txtPotencia);
        EditText txtTorque = findViewById(R.id.txtTorque);
        EditText txtCilindrada = findViewById(R.id.txtCc);
        CheckBox chkAspiracao = findViewById(R.id.chkAspiracao);
        CheckBox chkTransmissao = findViewById(R.id.chkTransmissao);

        String potencia = txtPotencia.getText().toString();
        String torque = txtTorque.getText().toString();
        String cilindrada = txtCilindrada.getText().toString();
        String aspiracao;
        String transmissao;

        if (chkAspiracao.isChecked()){
            aspiracao = "Natural";
        }
        else{
            aspiracao = "Turbo";
        }

        if (chkTransmissao.isChecked()){
            transmissao = "Manual";
        }

        else{
            transmissao = "Automático";
        }

        Intent intent = new Intent(this, StageumActivity.class);
        intent.putExtra(EXTRA_MESSAGE_POTENCIA, potencia);
        intent.putExtra(EXTRA_MESSAGE_TORQUE, torque);
        intent.putExtra(EXTRA_MESSAGE_CILINDRADA, cilindrada);
        intent.putExtra(EXTRA_MESSAGE_ASPIRACAO, aspiracao);
        intent.putExtra(EXTRA_MESSAGE_TRANSMISSAO, transmissao);
        startActivity(intent);
    }

    public void EnviarStagedois (View v)
    {
        EditText txtPotencia = findViewById(R.id.txtPotencia);
        EditText txtTorque = findViewById(R.id.txtTorque);
        EditText txtCilindrada = findViewById(R.id.txtCc);
        CheckBox chkAspiracao = findViewById(R.id.chkAspiracao);
        CheckBox chkTransmissao = findViewById(R.id.chkTransmissao);

        String potencia = txtPotencia.getText().toString();
        String torque = txtTorque.getText().toString();
        String cilindrada = txtCilindrada.getText().toString();
        String aspiracao;
        String transmissao;

        if (chkAspiracao.isChecked()){
            aspiracao = "Natural";
        }
        else{
            aspiracao = "Turbo";
        }

        if (chkTransmissao.isChecked()){
            transmissao = "Manual";
        }

        else{
            transmissao = "Automático";
        }

        Intent intent = new Intent(this, StagedoisActivity.class);
        intent.putExtra(EXTRA_MESSAGE_POTENCIA, potencia);
        intent.putExtra(EXTRA_MESSAGE_TORQUE, torque);
        intent.putExtra(EXTRA_MESSAGE_CILINDRADA, cilindrada);
        intent.putExtra(EXTRA_MESSAGE_ASPIRACAO, aspiracao);
        intent.putExtra(EXTRA_MESSAGE_TRANSMISSAO, transmissao);
        startActivity(intent);
    }

    public void EnviarDadosemail(View v) throws UnsupportedEncodingException
    {
        EditText txtPotencia = findViewById(R.id.txtPotencia);
        EditText txtTorque = findViewById(R.id.txtTorque);
        EditText txtCilindrada = findViewById(R.id.txtCc);
        CheckBox chkAspiracao = findViewById(R.id.chkAspiracao);
        CheckBox chkTransmissao = findViewById(R.id.chkTransmissao);

        String potencia = txtPotencia.getText().toString();
        String torque = txtTorque.getText().toString();
        String cilindrada = txtCilindrada.getText().toString();
        String aspiracao;
        String transmissao;

        if (chkAspiracao.isChecked()){
            aspiracao = "Natural";
        }
        else{
            aspiracao = "Turbo";
        }

        if (chkTransmissao.isChecked()){
            transmissao = "Manual";
        }

        else{
            transmissao = "Automático";
        }

        String uriText =
                "mailto:marcianosperformance@gmail.com" +
                        "?subject=" + URLEncoder.encode("Dados do carro", "utf-8") +
                        "&body=" + URLEncoder.encode("Potência: " + potencia + "\nTorque: " + torque + "\nCilindrada: "
                        + cilindrada + "\nAspiração: " + aspiracao + "\nTransmissão: " + transmissao, "utf-8");
        Uri uri = Uri.parse(uriText);
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(uri);
        startActivity(Intent.createChooser(it, "Enviar por Email"));
    }

    public void Ligarempresa (View v)
    {
        Uri uri = Uri.parse("tel:985400506");
        Intent i = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(i);
    }

}