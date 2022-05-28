package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView signUp;
    private TextInputLayout firstName, lastName, email, password, confirmPassword;
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
        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        confirmPassword = (TextInputLayout) findViewById(R.id.confirmPassword);

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

        String valEmail = email.getEditText().getText().toString().trim();
        String valPassword = password.getEditText().getText().toString().trim();
        String valConfirm = confirmPassword.getEditText().getText().toString().trim();
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
            email.setError("Email can't be empty!");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(valEmail).matches()) {
            email.setError("Please provide valid email");
            email.requestFocus();
            return;
        }
        if (valPassword.isEmpty()) {
            password.setError("Email can't be empty!");
            password.requestFocus();
            return;
        }
        if (valConfirm.isEmpty()) {
            confirmPassword.setError("Email can't be empty!");
            confirmPassword.requestFocus();
        }

        mAuth.createUserWithEmailAndPassword(valEmail, valPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(valFirstName, valLastName, valEmail);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}