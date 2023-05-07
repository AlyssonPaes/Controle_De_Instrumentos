package com.example.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btCadastrar, btAcessar;

    EditText txtEmail, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btAcessar = (Button) findViewById(R.id.btAcessar);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btAcessar.setOnClickListener(this);
        btCadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        {
        if (v.getId() == R.id.btAcessar)
            consultaUsuarioLogin();
        }
        if (v.getId() == R.id.btCadastrar)
        {
            Intent intencao = new Intent(this, Cadastrar.class);
            startActivity(intencao);

        }
    }

    public void consultaUsuarioLogin() {
        String Email = txtEmail.getText().toString();
        String Senha = txtSenha.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosLogin(Email, Senha);

        if (dados.moveToFirst()) {
            // levando parametros (nome do usuario) para a tela de login
            Intent tela = new Intent(this, Menu.class);
            String nome = dados.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("nome", nome);
            tela.putExtras(parametros);
            startActivity(tela);

        } else {
            String msg = "Dados não encontrados no sistema, digite outro!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }

    public void limpar(){
        txtEmail.setText("");
        txtSenha.setText("");
        txtEmail.requestFocus();
    }
}


