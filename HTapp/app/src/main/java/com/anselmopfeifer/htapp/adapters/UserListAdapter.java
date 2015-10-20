package com.anselmopfeifer.htapp.adapters;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class UserListAdapter extends ArrayAdapter<User> {

    public UserListAdapter(Context context, List<User> objects) {
        super(context, R.layout.activity_list_user, objects);
    }

    @Override
    public View getView(int position, View item, ViewGroup parent) {
        final ViewHolder holder;
        if(item == null){
            item = View.inflate(getContext(), R.layout.activity_list_user, null);
            holder = new ViewHolder();

            ButterKnife.bind(holder, item);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        final  User user = getItem(position);
        if(user != null){
            holder.image.setImageResource(user.getImage());
            holder.name.setText(user.getNome());
        }
        return item;
    }

    public class ViewHolder{
        @Bind(R.id.lis_users_image)
        ImageView image;
        @Bind(R.id.list_users_nome)
        TextView name;
    }
}
