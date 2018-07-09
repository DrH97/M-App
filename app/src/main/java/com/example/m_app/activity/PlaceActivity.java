package com.example.m_app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.m_app.R;

public class PlaceActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title, description, price, location;
    private String placeTitle, placeDesc, placeImage, placePrice, placeLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        getSupportActionBar().hide();

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigateUp();
            }
        });

        if (getIntent() != null) {
            placeTitle = getIntent().getStringExtra("title");
            placeDesc = getIntent().getStringExtra("desc");
            placeImage = getIntent().getStringExtra("image");
            placeLoc = getIntent().getStringExtra("location");
            placePrice = getIntent().getStringExtra("price");
        }

        toolbar.setTitle(placeTitle);
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }
}
