package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 private  FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mAuth = FirebaseAuth.getInstance();

             mAuth.createUserWithEmailAndPassword("avishek51775@gmail.com","123" +
                     "4567").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful())
                     {
                         System.out.println("sdsdsdsd YES");
                     }
                     else
                     {
                         
                         System.out.println("sdsdsd NO");
                     }
                 }
             });



            // System.out.println(e);


    }
}