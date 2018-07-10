package com.example.m_app.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.m_app.GlideApp;
import com.example.m_app.R;
import com.example.m_app.adapter.ActivitiesListAdapter;
import com.example.m_app.model.Activity;
import com.example.m_app.model.ActivityResponse;
import com.example.m_app.rest.ApiClient;
import com.example.m_app.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaceActivity extends AppCompatActivity {

    private static final String TAG = PlaceActivity.class.getSimpleName();
    private ImageView image;
    private TextView title, description, price, location;
    private String placeTitle, placeDesc, placeImage, placePrice, placeLoc;

    private int place_id;

    private Toolbar toolbar;
    private ProgressBar mProgressBar, mActProgressBar;

    private List<Activity> activities = new ArrayList<>();

    private ExpandableListView expListView;
    private ActivitiesListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        mProgressBar = findViewById(R.id.place_progressBar);
        mActProgressBar = findViewById(R.id.activities_progressBar);

        mProgressBar.setVisibility(View.VISIBLE);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigateUp();
            }
        });

        image = findViewById(R.id.app_bar_image);
        description = findViewById(R.id.details);
        price = findViewById(R.id.price);
        location = findViewById(R.id.location);

        expListView = findViewById(R.id.activities_list);
        listAdapter = new ActivitiesListAdapter(this, activities);

        expListView.setAdapter(listAdapter);

        new SetupPlaceData().execute();

//        prepareActivitiesData();

    }

    private void prepareActivitiesData() {
        Activity activity = new Activity(1, 1, (double)200, "none", "none", "none", "none", "Biking", "Biking For 3 hrs", false);
        activities.add(activity);

        activity = new Activity(2, 4, (double)2000, "none", "none", "none", "none", "Swimming", "Swimming For 6 hrs", false);
        activities.add(activity);

        activity = new Activity(3, 4, (double)500, "none", "none", "none", "none", "QuadBiking", "Follow a nature trail as you bike along", false);
        activities.add(activity);

        listAdapter.notifyDataSetChanged();
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

    private class SetupPlaceData extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (getIntent() != null) {
                place_id = getIntent().getIntExtra("id", 0);
                placeTitle = getIntent().getStringExtra("title");
                placeDesc = getIntent().getStringExtra("desc");
                placeImage = getIntent().getStringExtra("image");
                placeLoc = getIntent().getStringExtra("location");

                placePrice = getIntent().getStringExtra("price");

                if (getIntent().getStringExtra("price") == null)
                    placePrice = "FREE";

                return true;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            if (aVoid) {
                GlideApp.with(getBaseContext())
                        .load(placeImage)
                        .placeholder(R.drawable.bc_small)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(image);

                location.setText(placeLoc);
                description.setText(placeDesc);
                price.setText(placePrice);

                getSupportActionBar().setDisplayShowTitleEnabled(true);
                getSupportActionBar().setTitle(placeTitle);

                mProgressBar.setVisibility(View.GONE);
                setupActivities();
            } else {
                finish();
            }

        }
    }

    private void setupActivities() {

        mActProgressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ActivityResponse> call = apiInterface.getPlaceActivities(place_id);

        call.enqueue(new Callback<ActivityResponse>() {
            @Override
            public void onResponse(Call<ActivityResponse> call, Response<ActivityResponse> response) {
                if (response.body() != null && response.body().getTotalResults() > 0)
                    setupListView(response.body().getActivities());
                else
                    mActProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ActivityResponse> call, Throwable t) {

                mActProgressBar.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setupListView(List<Activity> activityList) {
        activities.clear();
        activities.addAll(activityList);

        listAdapter.notifyDataSetChanged();

        mActProgressBar.setVisibility(View.GONE);
    }


}
