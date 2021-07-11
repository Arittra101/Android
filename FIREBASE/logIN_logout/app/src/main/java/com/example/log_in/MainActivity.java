package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Log_In;
    ProgressBar pb;
    EditText email,passcode;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sign = (TextView) findViewById(R.id.create);
        Log_In =  findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();


        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 pb = findViewById(R.id.probar_singIN);
                 pb.setVisibility(View.VISIBLE);
                 email = findViewById(R.id.mail);
                 passcode = findViewById(R.id.pass);
                 String mail_string  = email.getText().toString().trim();
                 String pass_string = passcode.getText().toString().trim();

                if(mail_string.isEmpty())
                {
                    email.setError("Please Enter email");
                    email.requestFocus();
                }
               else if(!Patterns.EMAIL_ADDRESS.matcher(mail_string).matches())
               {
                   email.setError("Invalid Mail");
                   email.requestFocus();
               }
               else if(pass_string.length()<8)
                {
                    passcode.setError("Password Must be greater than 7 digit");
                }
               else {

                    pb.setVisibility(View.VISIBLE);
                   mAuth.signInWithEmailAndPassword(mail_string, pass_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    pb.setVisibility(View.GONE);
                                    Intent i = new Intent(getApplicationContext(),Profile.class);
                                    startActivity(i);
                                }
                                else
                                {
                                    pb.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(),"Unsuccefull log in",Toast.LENGTH_SHORT).show();
                                }
                        }
                    });


                }

            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent SignUP_intent = new Intent(getApplicationContext(),sign_up.class);
               // startActivity(SignUP_intent);
                Intent Sign_Up =new Intent(getApplicationContext(),SIgn_UPP.class);
                startActivity(Sign_Up);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //as your wish
    }
}