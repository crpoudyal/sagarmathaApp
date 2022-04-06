package com.example.sagarmatha;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {
    public ListView lvTest;
    public ArrayList<ListData> listItems;
    private ListExampleAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        lvTest = findViewById(R.id.lv_text);

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
        mAdapter = new ListExampleAdapter(this,listItems);

        lvTest.setAdapter(mAdapter);

        listItems.add(new ListData("new title","This is description for title"));

        mAdapter.notifyDataSetChanged();

    }
}
