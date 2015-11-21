package com.anselmopfeifer.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.adapters.UserImageListAdapter;
import com.anselmopfeifer.htapp.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class UserImageActiivity extends AppCompatActivity {

    @Bind(R.id.list_nomes)
    ListView dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setNome("Anselmo");
        user1.setImage(R.drawable.ic_profile_noavatar);

        user2.setNome("Pedro");
        user2.setImage(R.drawable.ic_profile_noavatar);

        user3.setNome("Joao");
        user3.setImage(R.drawable.ic_profile_noavatar);

        user4.setNome("Pfeifer");
        user4.setImage(R.drawable.ic_profile_noavatar);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        final UserImageListAdapter adapter = new UserImageListAdapter(this, users);
        dados.setAdapter(adapter);

        dados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UserImageActiivity.this, adapter.getItem(position).getNome(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
