package com.example.sagarmatha;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GridExampleActivity extends AppCompatActivity {
    private GridView gridView;

    private  ListExampleAdapter mAdapter;
    public ArrayList<ListData> listItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_example_layout);

        gridView = findViewById(R.id.grid_view);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android1","This is description for title"));
        listItems.add(new ListData("Android2","This is description for title"));
        listItems.add(new ListData("Android3","This is description for title"));
        listItems.add(new ListData("Android4","This is description for title"));
        listItems.add(new ListData("Android5","This is description for title"));
        listItems.add(new ListData("Android6","This is description for title"));


        mAdapter = new ListExampleAdapter(this,listItems);
        gridView.setAdapter(mAdapter);
    }
}
