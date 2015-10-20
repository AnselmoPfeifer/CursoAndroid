package com.anselmopfeifer.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.util.Constants;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 12/10/2015.
 */
public class GActivity extends AppCompatActivity {
    @Bind(R.id.g_text)
    TextView gText;
    @Bind(R.id.g_btn)
    Button btnG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g);
        ButterKnife.bind(this);

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(getIntent().getExtras().containsKey(Constants.EXTRA_FOR_G)){
            gText.setText(getIntent().getExtras().getString(Constants.EXTRA_FOR_G));
            //gText.setText(getIntent().getStringExtra(Constants.EXTRA_FOR_G));
        }
    }
}
