package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CadcarroActivity extends AppCompatActivity {

    TextView marca;
    TextView modelo;
    TextView versao;
    TextView stage;
    private DatabaseHelper dbc;
    private CarrosConec inserir;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadcarro);

        marca = findViewById(R.id.txtMarca);
        modelo = findViewById(R.id.txtModelo);
        versao = findViewById(R.id.txtVersao);
        stage = findViewById(R.id.txtStagecad);
        inserir = new CarrosConec(this);
    }

    public void Inserircarro(View v)
    {
        Carros c = new Carros();
        c.setMarca(marca.getText().toString());
        c.setModelo(modelo.getText().toString());
        c.setVersao(versao.getText().toString());
        c.setStage(stage.getText().toString());
        long id = dbc.insertCarros(u);
        Toast.maketext(this, "Carro Cadastrado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public boolean BackupInterno()
    {
        try {
            ArrayList<Carros> c = dbc.getCarrosList();
            File file = getFileStreamPath(BACKUP_CARROS);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(c);
            oos.close();
            fos.close();
            return  true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void Backupcarro (View v)
    {
        BackupInterno();
        Toast.maketext(this, "Backup realizado!",Toast.LENGTH_SHORT).show();
    }
}