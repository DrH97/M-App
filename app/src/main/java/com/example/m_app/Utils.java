package com.example.m_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.m_app.activity.MainActivity;
import com.example.m_app.activity.SplashScreenActivity;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    private Context context;
    private SharedPreferences sharedPrefs;

    public Utils(Context context) {
        this.context = context;
        this.sharedPrefs = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public void setNavItems(MainActivity mainActivity, NavigationView navigationView) {
        if (!auth()) {

            MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_profile);
            menuItem.setVisible(false);
            menuItem = navigationView.getMenu().findItem(R.id.nav_favourites);
            menuItem.setVisible(false);
            menuItem = navigationView.getMenu().findItem(R.id.nav_signout);
            menuItem.setVisible(false);

            menuItem = navigationView.getMenu().findItem(R.id.nav_signin);
            menuItem.setVisible(true);
            mainActivity.invalidateOptionsMenu();

        }
    }

    public boolean auth() {

        return sharedPrefs.getBoolean("auth", false);
    }

    public boolean signout() {
        AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        if (AccessToken.getCurrentAccessToken() != null) {
                            LoginManager.getInstance().logOut();
                        }

                        if (deletePrefs())
                            context.startActivity(new Intent(context, SplashScreenActivity.class));
                    }
                });

//        AuthUI.getInstance()
//                .delete(context)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });

        return true;

    }

    private boolean deletePrefs() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove("auth");
        editor.remove("username");
        editor.remove("email");
        editor.remove("photo");
//                        editor.apply();
        return editor.commit();
    }

    public void login() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("auth", true);
        editor.apply();
    }

    public void loginUser(FirebaseUser user) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("auth", true);
        editor.putString("username", user.getDisplayName());
        editor.putString("email", user.getEmail());
        editor.putString("photo", user.getPhotoUrl().toString());
        editor.apply();
    }

    public Map getUserData() {
        Map <String, String> arrayMap = new HashMap<>();

        Log.e("Utils", sharedPrefs.getAll().toString());
        String username = sharedPrefs.getString("username", "Gymtastic App");
        String email = sharedPrefs.getString("email", "gymtastic.app.com");
        String photo = sharedPrefs.getString("photo", "gymtastic");

        arrayMap.put("username", username);
        arrayMap.put("email", email);
        arrayMap.put("photo", photo);

        return arrayMap;
    }

    public void setUpUserData(View header) {
        ImageView photo = header.findViewById(R.id.user_image);
        TextView username = header.findViewById(R.id.username);
        TextView email = header.findViewById(R.id.user_email);

        Map userData = getUserData();

        if (userData.get("photo") != "gymtastic")
            Glide.with(context)
                .load(userData.get("photo"))
                .into(photo);

        username.setText(userData.get("username").toString());
        email.setText(userData.get("email").toString());
    }
}
