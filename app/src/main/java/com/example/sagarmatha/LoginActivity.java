package com.example.sagarmatha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    String email_str,password_str,firstname_str,lastname_str;


    TextView signup;
    EditText edt_email,edt_password;
    Button login_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

//         finding view
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        login_btn = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup);


//       if user doesn't have account navigate to register screen

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

//        Getting data
        Intent intent = getIntent();

        if (intent.hasExtra(RegisterActivity.EMAIL)) {
            email_str = intent.getStringExtra(RegisterActivity.EMAIL);
        }
        if (intent.hasExtra(RegisterActivity.PASSWORD)) {
            password_str = intent.getStringExtra(RegisterActivity.PASSWORD);
        }if(intent.hasExtra(RegisterActivity.FIRSTNAME)){
            firstname_str = intent.getStringExtra(RegisterActivity.FIRSTNAME);
        }if(intent.hasExtra(RegisterActivity.LASTNAME)){
            lastname_str = intent.getStringExtra(RegisterActivity.LASTNAME);
        }
//        Handling login btn

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();

                if(email.equals(email_str) && password.equals(password_str)){

                    Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(LoginActivity.this,DashboardActivity.class);
                    intent1.putExtra(EMAIL,email);
                    intent1.putExtra(PASSWORD,password);
                    intent1.putExtra(FIRSTNAME,firstname_str);
                    Log.i("TAG",firstname_str);
                    intent1.putExtra(LASTNAME,lastname_str);
                    startActivity(intent1);
                    finish();

                }else{
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
