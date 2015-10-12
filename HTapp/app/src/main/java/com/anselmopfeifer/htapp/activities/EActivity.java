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
import butterknife.OnLongClick;

/**
 * Created by Anselmo on 06/10/2015.
 */
public class EActivity extends AppCompatActivity{
    int contadorOnClick = 0;

    @Bind(R.id.e_title)
    TextView eTitle;

    @Bind(R.id.e_Edit_text)
    EditText eEditText;

    @Bind(R.id.e_btn_ok)
    Button eButtonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        //Forma nativa de criar
//        TextView eTitle = (TextView) findViewById(R.id.e_title);
//        EditText eEditText = (EditText) findViewById(R.id.e_Edit_text);
//        Button eButtonOk = (Button) findViewById(R.id.e_btn_ok);
        //Inicializar o ButterKnife

        ButterKnife.bind(this);
        eEditText.getText();

        eButtonOk.setText("Click Aqui");
        eButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contadorOnClick%2==0) {
                    eTitle.setText("HIGH TECH");
                } else {
                    eTitle.setText("TECH HIGH");
                }
                contadorOnClick ++;
            }
        });



       /* eButtonOk.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                eTitle.setText("TEXTE");
                return true;
            }
        });*/

    }

    //Outra forma de usar, (pode ser feito com OnLong e OnClick
    @OnLongClick(R.id.e_btn_ok)
    public boolean changeText(){
        eTitle.setText("TEXTE");
        return true;
    }
}

