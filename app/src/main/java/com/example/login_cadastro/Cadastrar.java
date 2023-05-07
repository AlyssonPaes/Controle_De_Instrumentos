package com.example.login_cadastro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastrar extends AppCompatActivity  implements View.OnClickListener {

    Button btGravar;
    EditText txtCadCPF, txtCadEmail, txtCadSenha, txtCadConfSenha;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btGravar = (Button) findViewById(R.id.btGravar);
        txtCadEmail = (EditText) findViewById(R.id.txtCadEmail);
        txtCadSenha = (EditText) findViewById(R.id.txtCadSenha);
        txtCadConfSenha = (EditText) findViewById(R.id.txtCadConfSenha);
        txtCadCPF = (EditText) findViewById(R.id.txtCadCPF);

        btGravar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        String CadEmail = txtCadEmail.getText().toString();
        String CadSenha = txtCadSenha.getText().toString();
        String CadConfSenha = txtCadConfSenha.getText().toString();
        String CadCPF = txtCadCPF.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        if (CadSenha.equals(CadConfSenha)) {
            resultado = bd.insereDadosUsuario(CadCPF,CadEmail, CadSenha);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            limpar();
        }else{
            String msg = "As senhas digitadas não são iguais, digite novamente!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
    public void limpar()
    {
        txtCadEmail.setText("");
        txtCadSenha.setText("");
        txtCadConfSenha.setText("");
        txtCadCPF.setText("");
    }
}
