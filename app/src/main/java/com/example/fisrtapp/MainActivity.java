package com.example.fisrtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        Info =  findViewById(R.id.textView);
        Login =  findViewById(R.id.btnLogin);
        Info.setText("Welcome");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(Name.getText().toString(), Password.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    counter--;
                    Info.setText("No.of attempts remaining: " + String.valueOf(counter));

                    if (counter == 0){
                        
                        Info.setText("Try again later");
                        Login.setEnabled(false);
                    }
                }
            }

            ;
        });
    }

    private Boolean validate(String userName, String userPassword) {

        if ((userName.equalsIgnoreCase("vaish") && (userPassword.equals("12345")))) {
            return true;
        } else return false;
    }
}

