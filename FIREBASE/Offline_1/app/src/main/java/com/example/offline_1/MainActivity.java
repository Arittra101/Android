package com.example.offline_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText userId1,name1,stuId1;
    private Button logIN1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId1 = findViewById(R.id.userid);
        name1 = findViewById(R.id.name);
        stuId1 = findViewById(R.id.stuId);
        logIN1 = findViewById(R.id.logIN);
        logIN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] str = new String[3];
                str[0]= userId1.getText().toString().trim();
                str[1]= name1.getText().toString().trim();
                str[2]= stuId1.getText().toString().trim();

                Intent intent = new Intent(getApplicationContext(),LOGIN.class);
                intent.putExtra("string-array",str);
                startActivity(intent);
            }
        });




    }
}

//    info i = new info(userId1.getText().toString().trim(),name1.getText().toString().trim(),stuId1.getText().toString().trim());
//                intent.putExtra("info", (Parcelable) i);
//
//                        info i = (info) getIntent().getSerializableExtra("info");
//
//
//                        tx1.setText(i.getUserId());
//                        tx2.setText(i.getName());
//                        tx3.setText(i.getStudentId());