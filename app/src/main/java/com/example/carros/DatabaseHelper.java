package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper  {

    public static final String DATABASE_NAME = "dbCarros.db";
    public static final String CARROS_NOME_TABELA = "carros";
    public static final String CARROS_COLUNA_ID = "id";
    public static final String CARROS_COLUNA_MARCA = "marca";
    public static final String CARROS_COLUNA_MODELO = "modelo";
    public static final String CARROS_COLUNA_VERSAO = "versao";
    public static final String CARROS_COLUNA_STAGE = "stage";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table carros " +
                        "(id integer primary key auto_increment, marca text,modelo text,versao text, stage text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS carros");
        onCreate(db);
    }

    public class CarrosConec{
        private Conexao conexao;
        private SQLiteDatabase banco;

        public CarrosConec(Context context){
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }
    }

    public boolean insertCarros (Carros c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARROS_COLUNA_MARCA, c.get_marca());
        contentValues.put(CARROS_COLUNA_MODELO, c.get_modelo());
        contentValues.put(CARROS_COLUNA_VERSAO, c.get_versao());
        contentValues.put(CARROS_COLUNA_STAGE, c.get_stage());
        db.insert(CARROS_NOME_TABELA, null, contentValues);
        return true;
    }

    public ArrayList<Carros> getCarrosList() {
        ArrayList<Carros> lista = new ArrayList<Carros>() ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from carros", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            Carros c = new Carros();
            c.set_id(Integer.parseInt(res.getString(res.getColumnIndex(CARROS_COLUNA_ID))));
            c.set_marca(res.getString(res.getColumnIndex(CARROS_COLUNA_MARCA)));
            c.set_modelo(res.getString(res.getColumnIndex(CARROS_COLUNA_MODELO)));
            c.set_versao(res.getString(res.getColumnIndex(CARROS_COLUNA_VERSAO)));
            c.set_stage(res.getString(res.getColumnIndex(CARROS_COLUNA_STAGE)));

            lista.add(c);
            res.moveToNext();
        }

        return lista;
    }
}