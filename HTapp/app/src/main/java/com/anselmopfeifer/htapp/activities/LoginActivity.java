package com.anselmopfeifer.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 06/10/2015.
 */
public class LoginActivity extends AppCompatActivity {
    String sucessoLogin = "Login Efetuado com Sucesso!";
    String errorLogin = "Erro ao Efetuar Login!";
    @Bind(R.id.login_title)
    TextView loginTitle;

    @Bind(R.id.login_resultado)
    TextView login_resultado;

    @Bind(R.id.login_login)
    EditText loginLogin;

    @Bind(R.id.login_senha)
    EditText loginSenha;

    @Bind(R.id.login_btn1)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);

        ButterKnife.bind(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginLogin.getText().toString().equals("123") && loginSenha.getText().toString().equals("123")){
                    login_resultado.setText(sucessoLogin);
                    }else{
                        login_resultado.setText(errorLogin);
                    }

                login_resultado.setVisibility(View.VISIBLE);
                }




        });

    }
}
