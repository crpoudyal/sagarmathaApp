package com.example.sagarmatha;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {

    Toolbar toolbar;

    public ListView lvTest;
    public ArrayList<ListData> listItems;
    private ListExampleAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvTest = findViewById(R.id.lv_text);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        mAdapter = new ListExampleAdapter(this,listItems);

        lvTest.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lv_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                listItems.add(new ListData("New title","This is description for title"));
                mAdapter.notifyDataSetChanged();
                break;
            case android.R.id.home:
                finish();
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
}
