package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView signUp;
    private TextInputLayout firstName, lastName, txtEmail, txtPassword, txtConfirmPassword;
    private MaterialButton registerUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        signUp = (TextView) findViewById(R.id.signUp);
        signUp.setOnClickListener(this);

        registerUser = (MaterialButton) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        firstName = (TextInputLayout) findViewById(R.id.firstName);
        lastName = (TextInputLayout) findViewById(R.id.lastName);
        txtEmail = (TextInputLayout) findViewById(R.id.txtEmail);
        txtPassword = (TextInputLayout) findViewById(R.id.txtPassword);
        txtConfirmPassword = (TextInputLayout) findViewById(R.id.txtConfirmPassword);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUp:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }

    }
    private void registerUser() {

        String valEmail = txtEmail.getEditText().getText().toString().trim();
        String valPassword = txtPassword.getEditText().getText().toString().trim();
        String valConfirm = txtConfirmPassword.getEditText().getText().toString().trim();
        String valFirstName = firstName.getEditText().getText().toString().trim();
        String valLastName = lastName.getEditText().getText().toString().trim();


        if (valFirstName.isEmpty()) {
            firstName.setError("First Name can't be empty!");
            firstName.requestFocus();
            return;
        }

        if (valLastName.isEmpty()) {
            lastName.setError("Last name can't be empty!");
            lastName.requestFocus();
            return;
        }
        if (valEmail.isEmpty()) {
            txtEmail.setError("Email can't be empty!");
            txtEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(valEmail).matches()) {
            txtEmail.setError("Please provide valid email");
            txtEmail.requestFocus();
            return;
        }
        if (valPassword.isEmpty()) {
            txtPassword.setError("Email can't be empty!");
            txtPassword.requestFocus();
            return;
        }
        if (valConfirm.isEmpty()) {
            txtConfirmPassword.setError("Email can't be empty!");
            txtConfirmPassword.requestFocus();
        }


    }

}