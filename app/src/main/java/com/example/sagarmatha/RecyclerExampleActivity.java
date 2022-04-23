package com.example.sagarmatha;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerExampleActivity extends AppCompatActivity {
    RecyclerView rvListData;
    private RecyclerListDataAdapter mAdapter;
    public ArrayList<ListData> listItems;
    private RecyclerListDataAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_example_layout);

        rvListData = findViewById(R.id.rv_list_data);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        mAdapter = new RecyclerListDataAdapter(this,listItems);
        rvListData.setLayoutManager(new LinearLayoutManager(this));
        rvListData.setAdapter(mAdapter);
    }
}
