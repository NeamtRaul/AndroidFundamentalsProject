package com.example.talentradar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText mName,mSurname,mEmail,mPassword;
    private Button mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mAuth = FirebaseAuth.getInstance();

        mSignUp = findViewById(R.id.mySignUpButton);
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });
        mName = findViewById(R.id.mySignUpName);
        mSurname = findViewById(R.id.mySignUpSurname);
        mEmail = findViewById(R.id.mySignUpEmailTextView);
        mPassword = findViewById(R.id.mySignUpPasswordTextView);

    }
    private void RegisterUser(){
        String name = mName.getText().toString().trim();
        String surname = mSurname.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if(name.isEmpty()){
            mName.setError("You did not enter your name!");
            mName.requestFocus();
            return;
        }
        if(surname.isEmpty()){
            mSurname.setError("You did not enter your surname!");
            mSurname.requestFocus();
            return;
        }
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
            mPassword.setError("Your password is too short! Please choose a password of minimum 7 characters!");
            mPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            UserInfo user = new UserInfo(name,surname,email);


                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SecondActivity.this,"Your account has been successfully created",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(SecondActivity.this,"Registration failed. Try again",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(SecondActivity.this,"Registration failed. Try again",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}

