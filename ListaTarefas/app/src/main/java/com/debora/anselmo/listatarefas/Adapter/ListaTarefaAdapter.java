package com.debora.anselmo.listatarefas.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.debora.anselmo.listatarefas.R;
import com.debora.anselmo.listatarefas.Tarefa;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Debora on 21/11/2015.
 */
public class ListaTarefaAdapter extends ArrayAdapter<Tarefa> {
    public ListaTarefaAdapter(Context context, List<Tarefa> lista) {
        super(context, R.layout.activity_list_tarefa, lista);
    }

    @Override
    public View getView(int position, View item, ViewGroup parent) {
        final ViewHolder holder;
        if(item == null){
            item = View.inflate(getContext(), R.layout.acitivity_tarefa_item, null);
            holder = new ViewHolder();

            ButterKnife.bind(holder, item);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }
        final Tarefa tarefa = getItem(position);
        holder.titulo.setText(tarefa.getTitulo());
        holder.tarefa.setText(tarefa.getTarefa());
        return item;
    }

    public class ViewHolder{
        @Bind(R.id.tarefa_titulo)
        TextView titulo;
        @Bind(R.id.tarefa_tarefa)
        TextView tarefa;
        @Bind(R.id.tarefa_status)
        TextView status;
    }
}
