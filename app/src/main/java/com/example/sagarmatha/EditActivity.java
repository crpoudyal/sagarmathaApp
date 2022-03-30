package com.example.sagarmatha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";

    EditText fname,lname;
    Button save_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        fname = findViewById(R.id.fname);
        lname= findViewById(R.id.lname);
        save_btn =findViewById(R.id.save_btn);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String newFname = fname.getText().toString();
                Log.i("TAG",newFname);

               String newLname = lname.getText().toString();
                Log.i("TAG",newLname);

                Intent resultIntent = new Intent();
                resultIntent.putExtra(FIRSTNAME,newFname);
                resultIntent.putExtra(LASTNAME,newLname);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        Intent i = getIntent();
        String firstname = i.getStringExtra(DashboardActivity.FIRSTNAME);
        String lastname = i.getStringExtra(DashboardActivity.LASTNAME);

        fname.setText(firstname);
        lname.setText(lastname);


    }
}
