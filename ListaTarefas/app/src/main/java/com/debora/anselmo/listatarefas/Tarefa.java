package com.debora.anselmo.listatarefas;

import android.app.DownloadManager;
import android.widget.RadioButton;

import java.util.List;

/**
 * Created by Debora on 21/11/2015.
 */
public class Tarefa {

    private String titulo;
    private String tarefa;
    private boolean completa;
    private boolean incompleta;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public boolean isCompleta(RadioButton completa) {
        return this.completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public boolean isIncompleta(RadioButton incompleta) {
        return this.incompleta;
    }

    public void setIncompleta(boolean incompleta) {
        this.incompleta = incompleta;
    }

    public static List<Tarefa> getAllTarefa(){
        return Tarefa.getAllTarefa();
    }
}
