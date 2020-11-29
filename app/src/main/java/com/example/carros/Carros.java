package com.example.carros;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Carros implements Serializable {
    private int id;
    private String marca;
    private String modelo;
    private String versao;
    private String stage;

    public Carros(int id, String marca, String modelo, String versao, String stage) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.versao = versao;
        this.stage = stage;
    }

    public Carros(){   }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String get_marca() {
        return marca;
    }

    public void set_marca(String marca) {
        this.marca = marca;
    }

    public String get_modelo() {
        return modelo;
    }

    public void set_modelo(String modelo) {
        this.modelo = modelo;
    }

    public String get_versao() {
        return versao;
    }

    public void set_versao(String versao) {
        this.versao = versao;
    }

    public String get_stage() {
        return stage;
    }

    public void set_stage(String stage) {
        this.stage = stage;
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("Id", this.id);
            obj.put("Marca", this.marca);
            obj.put("Modelo", this.modelo);
            obj.put("Versão", this.versao);
            obj.put("Stage Solicitado", this.stage);
        } catch (JSONException e) {

        }
        return obj;
    }
}
