package com.example.login_cadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) { banco = new CriaBanco(context); }


    public Cursor carregaTodosDados() {
        Cursor cursor;
        String[] campos = {"email", "senha", "cpf"};

        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, null, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public String insereDadosUsuario(String senha, String email, String cpf) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("cpf", cpf);
        valores.put("email", email);
        valores.put("senha", senha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro os dados, tente novamente!";
        else
            return "Dados do Usuário cadastrado com sucesso!";
    }

    public String insereDado(String senha, String email) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("senha", senha);
        valores.put("email", email);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

        public Cursor carregaDadosLogin(String email, String senha) {
        Cursor cursor;
        String[] campos = {"email", "senha"};
        String where = "email = '" + email + "' and senha = '" + senha + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}



