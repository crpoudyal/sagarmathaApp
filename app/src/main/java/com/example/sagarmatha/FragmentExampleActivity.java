package com.example.sagarmatha;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FragmentExampleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FragmentOne fragmentOne;
    private  FragmentTwo fragmentTwo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction().add(R.id.container,fragmentOne,"ONE").commitNowAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().add(R.id.sec_container,fragmentTwo,"ONE").commitNowAllowingStateLoss();

    }
}
