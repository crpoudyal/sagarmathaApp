package com.example.sagarmatha;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListExampleActivity extends AppCompatActivity {
    public ListView lvText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        lvText = findViewById(R.id.lv_text);


    }
}
