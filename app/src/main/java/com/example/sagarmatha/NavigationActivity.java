package com.example.sagarmatha;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_activity);

        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.close,R.string.open);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //actionBarDrawerToggle.syncState();

    }
}
