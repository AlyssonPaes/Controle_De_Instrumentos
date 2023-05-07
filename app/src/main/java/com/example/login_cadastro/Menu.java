package com.example.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button btinstrumento1, btinstnovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();

        btinstrumento1 = (Button) findViewById(R.id.btinstrumento1);

        btinstrumento1.setOnClickListener(this);

        btinstnovo = (Button) findViewById(R.id.btinstnovo);
        btinstnovo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btinstrumento1) {
            Intent intencao = new Intent(this, tela_instrumento.class);
            startActivity(intencao);
        }
        if (v.getId() == R.id.btinstnovo) {
            Intent intencao = new Intent(this, cadastro_instrumento.class);
            startActivity(intencao);
        }
    }
}