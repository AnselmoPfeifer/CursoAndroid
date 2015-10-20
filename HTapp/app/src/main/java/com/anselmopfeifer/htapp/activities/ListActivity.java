package com.anselmopfeifer.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.anselmopfeifer.htapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class ListActivity extends AppCompatActivity{
    @Bind(R.id.list_nomes)
    ListView list;

    private static final String[] NAMES = new String[]{
            "Joao",
            "Maria",
            "Debora",
            "Jose"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NAMES);
        list.setAdapter(adapter);
    }
}
