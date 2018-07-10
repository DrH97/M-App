package com.example.m_app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.m_app.R;

public class PlaceActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title, description, price, location;
    private String placeTitle, placeDesc, placeImage, placePrice, placeLoc;

    private Toolbar toolbar;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        mProgressBar = findViewById(R.id.place_progressBar);

        mProgressBar.setVisibility(View.VISIBLE);

//        getSupportActionBar().hide();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

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

        getSupportActionBar().setTitle(placeTitle);

        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.place_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favourite) {
            return true;
        }

        if (id == R.id.action_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
