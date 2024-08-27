package com.example.stress_guru;

import android.os.Bundle;
import android.view.View;
import android.util.Patterns;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputEmail, textInputPassword;
    Button confirmBtn, resetBtn;
    ImageButton exitBtn;

    private static final Pattern PASSWORD_PATTERN=
            Pattern.compile("^"+"(?=.*[0-9])"+"(?=.*[a-zA-Z])"+"(?=\\S+$)"+".{6,}"+"$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEmail=findViewById(R.id.input_email);
        textInputPassword=findViewById(R.id.input_password);
        confirmBtn=findViewById(R.id.confirm_button);
        exitBtn=findViewById(R.id.returnbutton);
        resetBtn=findViewById(R.id.resetpass_button);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail() | !validatePassword()){
                    return;
                }

                String email=textInputEmail.getEditText().getText().toString();
                String password = textInputPassword.getEditText().getText().toString();
                Toast.makeText(LoginActivity.this, "Email:"+email+"\n"+"Password:"+password,
                        Toast.LENGTH_LONG);
            }
        });
    }
    private boolean validateEmail(){
        String emailInput=textInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()){
            textInputEmail.setError("Failed. Email cannot be empty");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Please enter a valid email address");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordInput=textInputPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()){
            textInputPassword.setError("Failed. Password cannot be empty");
            return false;
        } else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            textInputPassword.setError("Password is weak");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
}