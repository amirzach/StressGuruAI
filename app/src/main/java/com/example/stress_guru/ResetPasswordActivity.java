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

public class ResetPasswordActivity extends AppCompatActivity {

    TextInputLayout textInputEmail, textInputNewPassword, textConfirmNewPassword;
    Button confirmBtn;
    ImageButton exitBtn;

    private static final Pattern PASSWORD_PATTERN=
            Pattern.compile("^"+"(?=.*[0-9])"+"(?=.*[a-zA-Z])"+"(?=\\S+$)"+".{6,}"+"$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        textInputEmail=findViewById(R.id.input_email);
        textInputNewPassword=findViewById(R.id.input_new_password);
        textConfirmNewPassword=findViewById(R.id.confirm_new_password);
        confirmBtn=findViewById(R.id.confirm_button);
        exitBtn=findViewById(R.id.returnbutton);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity.this, MainActivity.class);
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
                String NewPassword = textInputNewPassword.getEditText().getText().toString();
                Toast.makeText(ResetPasswordActivity.this, "Email:"+email+"\n"+"New Password:"+NewPassword,
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
        String passwordInput=textInputNewPassword.getEditText().getText().toString().trim();
        String passwordCheck=textConfirmNewPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()){
            textInputNewPassword.setError("New Password entry cannot be empty");
            return false;
        } else if(passwordCheck.isEmpty()){
            textConfirmNewPassword.setError("Must confirm new password");
            return false;
        } else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            textInputNewPassword.setError("Password is weak");
            return false;
        } else if(!passwordInput.equals(passwordCheck)){
            textInputNewPassword.setError("New Password must be similar with confirmation password");
            return false;
        }else{
            textInputNewPassword.setError(null);
            return true;
        }
    }
}