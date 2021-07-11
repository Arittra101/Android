package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.ktx.Firebase;

public class SIgn_UPP extends AppCompatActivity implements View.OnClickListener {
    Button sign_up;
    EditText email,pass;
    private FirebaseAuth mAuth;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_ign__u_p_p);
        sign_up = findViewById(R.id.signUp);
        mAuth=FirebaseAuth.getInstance();
        sign_up.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        pb = findViewById(R.id.proBar);
        email = findViewById(R.id.mail);
        String email_string = email.getText().toString().trim();
        pass = findViewById(R.id.pass);
        String pass_string  = pass.getText().toString().trim();

        if(email_string.isEmpty())
        {
            email.setError("Please Enter the Email");
            email.requestFocus();
        }
         if(!Patterns.EMAIL_ADDRESS.matcher(email_string).matches())
        {
            email.setError("Invalid Pass");
            email.requestFocus();
        }
         if(pass_string.length()<8)
        {
            pass.setError("Pass Code Must be greater than 7");
            pass.requestFocus();
        }
        else {
//            email.setText("Done");
             pb.setVisibility(View.VISIBLE);
             mAuth.createUserWithEmailAndPassword(email_string, pass_string)
                     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()) {
                                 pb.setVisibility(View.GONE);
                                 Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();

                             } else {
                                 // If sign in fails, display a message to the user.

                                 if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(getApplicationContext(),"Already Registered",Toast.LENGTH_SHORT).show();
                                 }
                                 else
                                 {
                                     Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                                 }
                             }
                         }
                     });
         }
    }
}
