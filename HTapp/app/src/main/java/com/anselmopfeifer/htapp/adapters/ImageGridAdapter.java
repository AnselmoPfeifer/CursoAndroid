package com.anselmopfeifer.htapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.models.User;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class ImageGridAdapter extends ArrayAdapter<Integer> {
    public ImageGridAdapter(Context context, Integer[] imageList) {
        super(context, R.layout.activity_grid_item, imageList);
    }


    @Override
    public View getView(int position, View item, ViewGroup parent) {
        final ViewHolder holder;
        if(item == null){
            item = View.inflate(getContext(), R.layout.activity_grid_item, null);
            holder = new ViewHolder();

            ButterKnife.bind(holder, item);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        final Integer image = getItem(position);
        if(image != null){
            holder.image.setImageResource(image);
        }
        return item;
    }

    public class ViewHolder{
    @Bind(R.id.grid_image)
        ImageView image;
    }
}
