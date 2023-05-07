package com.example.login_cadastro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;


    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios ("
                + "cpf integer primary key autoincrement,"
                + "senha interger,"
                + "email text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
