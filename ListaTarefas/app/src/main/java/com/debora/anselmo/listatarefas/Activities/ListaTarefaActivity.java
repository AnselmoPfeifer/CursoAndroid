package com.debora.anselmo.listatarefas.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.debora.anselmo.listatarefas.Adapter.ListaTarefaAdapter;
import com.debora.anselmo.listatarefas.R;
import com.debora.anselmo.listatarefas.Tarefa;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Debora on 21/11/2015.
 */
public class ListaTarefaActivity extends AppCompatActivity {
    @Bind(R.id.lista)
    ListView lista;

    @Bind(R.id.voltar)
    Button btnVoltar;

    private ListaTarefaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tarefa);
        ButterKnife.bind(this);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             finish();
                                         }
                                     }
        );

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(ListaTarefaActivity.this)
                        .setTitle("Excluir Tarefa")
                        .setMessage("Deseja realmente Exluir?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.getItem(position);
                                adapter.notifyDataSetChanged();
                            }
                        });

                return true;
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ListaTarefaAdapter(this, Tarefa.getAllTarefa());
        lista.setAdapter(adapter);
    }

}
