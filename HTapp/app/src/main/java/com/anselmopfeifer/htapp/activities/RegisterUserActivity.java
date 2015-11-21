package com.anselmopfeifer.htapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.models.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anselmo on 03/11/2015.
 */
public class RegisterUserActivity extends AppCompatActivity{

    @Bind(R.id.register_nome)
    EditText register_nome;

    @Bind(R.id.register_email)
    EditText register_email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register_btn)
    public void registerUser(){
        if(!TextUtils.isEmpty(register_nome.getText().toString()) &&
                !TextUtils.isEmpty(register_email.getText().toString())){
            User user = new User();
            user.setNome(register_nome.getText().toString());
            user.setEmail(register_email.getText().toString());
            user.save();
            register_email.getText().clear();
            register_nome.getText().clear();
            startActivity(new Intent(RegisterUserActivity.this, UserListActivity.class));
        }else{
            Toast.makeText(this, "Algum campo esta vazio", Toast.LENGTH_SHORT).show();
        }
    }
}
