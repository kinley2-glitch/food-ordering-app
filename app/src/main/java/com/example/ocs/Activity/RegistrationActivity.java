package com.example.ocs.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ocs.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, regemail, regpassword, confpassword;
    Button signUp;
    TextView login;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.inputName);
        regemail = findViewById(R.id.Email);
        regpassword = findViewById(R.id.password_E);
        confpassword = findViewById(R.id.Confpassword);

        signUp = findViewById(R.id.signUpbtn);
        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(view ->{
            createUser();
        });

        login.setOnClickListener(view ->{
            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        });
    }

    private void createUser(){
        String Iname = name.getText().toString();
        String email = regemail.getText().toString();
        String password = regpassword.getText().toString();
        String cpassword = confpassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            regemail.setError("Email cannot be empty");
            regemail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            regpassword.setError("Password cannot be empty");
            regpassword.requestFocus();
        }else{
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this, "User registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Error" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}