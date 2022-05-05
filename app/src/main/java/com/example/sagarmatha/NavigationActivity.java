package com.example.sagarmatha;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
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
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentOne("This is add action"),
                "Fragment one").commitAllowingStateLoss();

       navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.action_add:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentOne("This is add action"),
                               "Fragment one").commitAllowingStateLoss();
                       break;
                   case R.id.action_delete:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentOne("This is delete action"),
                               "Fragment one").commitAllowingStateLoss();
                       break;
                   case R.id.action_view:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentOne("This is view action"),
                               "Fragment one").commitAllowingStateLoss();
                       break;
                   case R.id.logout:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentOne("This is Logout action"),
                               "Fragment one").commitAllowingStateLoss();
                       break;
               }

               drawerLayout.closeDrawers();
               return true;
           }
       });

    }
}
