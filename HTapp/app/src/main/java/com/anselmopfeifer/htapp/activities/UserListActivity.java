package com.anselmopfeifer.htapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.adapters.UserListAdapter;
import com.anselmopfeifer.htapp.models.User;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 03/11/2015.
 */
public class UserListActivity extends AppCompatActivity {

    @Bind(R.id.user_list_view)
    ListView userListView;
    @Bind(R.id.user_list_btn)
    Button btnBack;

    private UserListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(UserListActivity.this)
                        .setTitle("Excluir Usuário")
                        .setMessage("Deseja realmente Exluir?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.getItem(position).delete();
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
        adapter = new UserListAdapter(this, User.getAllUser());
        userListView.setAdapter(adapter);
    }
}

