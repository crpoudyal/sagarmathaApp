package com.example.sagarmatha;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {
    TextView login;
    EditText edt_firstname, edt_lastname, edt_email, edt_password, edt_conform_password, edt_phone;
    Button register_btn;

    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


//        finding view
        edt_firstname = findViewById(R.id.edt_fname);
        edt_lastname = findViewById(R.id.edt_lname);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_conform_password = findViewById(R.id.edt_cpassword);
        edt_phone = findViewById(R.id.edt_phone);
        register_btn = findViewById(R.id.register_btn);
        login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        get text
                String firstName = edt_firstname.getText().toString();
                String lastName = edt_lastname.getText().toString();
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                String conform_password = edt_conform_password.getText().toString();
                String phone = edt_phone.getText().toString();


               boolean chk =  validation(firstName, lastName, email, password, conform_password, phone);
               if(chk){
                   Toast.makeText(RegisterActivity.this, "Registration success", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);

//                   sending data
                   intent.putExtra(FIRSTNAME,firstName);
                   Log.i("TAG",firstName);
                   intent.putExtra(LASTNAME,lastName);
                   intent.putExtra(EMAIL,email);
                   intent.putExtra(PASSWORD,password);
                   intent.putExtra(PHONE,phone);
                   startActivity(intent);
                   finish();

               }else {
                   Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
               }

            }
        });


    }

    private Boolean validation(String firstName, String lastName, String email, String password, String conform_password, String phone) {
        if (firstName.isEmpty()) {
            edt_firstname.setError("Please enter your first name");
            return false;
        } else if (lastName.isEmpty()) {
            edt_lastname.setError("Please enter your last name");
            return false;

        } else if (email.isEmpty()) {
            edt_email.setError("Please enter your email");
            return false;

        } else if (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
            edt_email.setError("Valid Email xyz@gmail.com");
            return false;

        }else if(password.isEmpty()){
            edt_email.setError("Please enter your password");
            return false;

        }else if(phone.isEmpty()){
            edt_email.setError("Please enter your phone number");
            return false;
        }
        return  true;
    }

}
