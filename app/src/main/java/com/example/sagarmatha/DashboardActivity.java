package com.example.sagarmatha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {

    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String PASSWORD = "password";

    String email,password,firstname,lastname;
    TextView txt_email,txt_password,txt_firstname,txt_lastname;
    Button edt_btn;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt_email = findViewById(R.id.res_email);
        txt_password = findViewById(R.id.res_password);
        txt_firstname =findViewById(R.id.res_firstname);
        txt_lastname = findViewById(R.id.res_lastname);
        edt_btn = findViewById(R.id.edt_btn);






        Intent i = getIntent();
        email = i.getStringExtra(LoginActivity.EMAIL);
        password = i.getStringExtra(LoginActivity.PASSWORD);
        firstname = i.getStringExtra(LoginActivity.FIRSTNAME);
        lastname = i.getStringExtra(LoginActivity.LASTNAME);

        txt_email.setText("Email : "+email);
        txt_password.setText("Password : "+password);
        txt_firstname.setText("FirstName : "+firstname);
        Log.i("TAG",firstname);
        txt_lastname.setText("LastName : "+lastname);

        edt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,EditActivity.class);
                intent.putExtra(FIRSTNAME,firstname);
                intent.putExtra(LASTNAME,lastname);
                startActivityForResult(intent,1);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_text,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                break;
            case  R.id.action_notif:
                break;
            case android.R.id.home:
                finish();
                break;
                
        }
        return super.onOptionsItemSelected(item);
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
              firstname = data.getStringExtra(EditActivity.FIRSTNAME);
                lastname = data.getStringExtra(EditActivity.LASTNAME);
                txt_firstname.setText("FirstName : "+firstname);
                txt_lastname.setText("LastName : "+lastname);
            }
        }
    }
}
