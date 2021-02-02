package com.example.talentradar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView mSignUpTextView;
    private Button mLoginButton;
    private EditText mEmail, mPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignUpTextView = findViewById(R.id.mySignUpTextView);
        mLoginButton = findViewById(R.id.myLogInButton);
        mEmail = findViewById(R.id.myEmailTextView);
        mPassword = findViewById(R.id.myPasswordTextView);
        mAuth = FirebaseAuth.getInstance();

        mSignUpTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }
    private void userLogin(){
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if(email.isEmpty()){
            mEmail.setError("You did not enter your email!");
            mEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("You did not enter a valid e-mail address!");
            mEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            mPassword.setError("You did not enter your password!");
            mPassword.requestFocus();
            return;
        }

        if(password.length()<7){
            mPassword.setError("Your password is too short! Please choose a password of minimum 8 characters!");
            mPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent (MainActivity.this,MainMenu.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"You entered the wrong e-mail/password!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}