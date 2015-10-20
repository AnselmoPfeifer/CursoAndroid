package com.anselmopfeifer.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.adapters.ImageGridAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class GridActivity extends AppCompatActivity {
    @Bind(R.id.grid)
    GridView grid;

    private Integer[] imageList = {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_4,
            R.drawable.sample_6,
            R.drawable.sample_7,

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);
        ImageGridAdapter adapter = new ImageGridAdapter(this, imageList);
        grid.setAdapter(adapter);
    }
}
