package com.anselmopfeifer.htapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.models.User;
import com.anselmopfeifer.htapp.util.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FActivity extends AppCompatActivity{
    @Bind(R.id.f_text)
    TextView fText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        ButterKnife.bind(this);
        if(getIntent().getExtras().containsKey(Constants.EXTRA_FOR_F)){
            User user = (User) getIntent().getSerializableExtra(Constants.EXTRA_FOR_F);
            fText.setText("Login: " + user.getLogin() + " Senha: " + user.getPassword());
        }
    }


    @OnClick(R.id.f_btn)
    public void goToActiivity(){
        Intent i = new Intent(FActivity.this,GActivity.class);
        i.putExtra(Constants.EXTRA_FOR_G, fText.getText().toString());
        startActivity(i);
    }
}
