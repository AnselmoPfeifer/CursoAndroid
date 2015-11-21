package com.debora.anselmo.listatarefas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.debora.anselmo.listatarefas.R;
import com.debora.anselmo.listatarefas.Tarefa;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Debora on 21/11/2015.
 */
public class CadastroListaActivity extends AppCompatActivity {
    @Bind(R.id.titulo)
    EditText titulo;

    @Bind(R.id.tarefa)
    EditText tarefaa;

    @Bind(R.id.completa)
    RadioButton completa;

    @Bind(R.id.incompleta)
    RadioButton incompleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tarefa);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.salvar)
    public void registerTarefa(){
        if(!TextUtils.isEmpty(titulo.getText().toString()) &&
                !TextUtils.isEmpty(tarefaa.getText().toString())){
            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(titulo.getText().toString());
            tarefa.setTarefa(tarefaa.getText().toString());
            tarefa.isCompleta(completa);
            tarefa.isIncompleta(incompleta);
            titulo.getText().clear();
            tarefaa.getText().clear();
            startActivity(new Intent(CadastroListaActivity.this, ListaTarefaActivity.class));
        }else{
            Toast.makeText(this, "Algum campo esta vazio", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
    }
}
