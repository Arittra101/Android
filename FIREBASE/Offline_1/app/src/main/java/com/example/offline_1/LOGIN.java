package com.example.offline_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LOGIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);
        TextView tx1,tx2,tx3;
        tx1 = findViewById(R.id.t1);
        tx2 = findViewById(R.id.t2);
        tx3 = findViewById(R.id.t3);
        Button btn = findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        String[] string = getIntent().getStringArrayExtra("string-array");

        tx1.setText("User ID     "+string[0]);
        tx2.setText("Name     "+string[1]);
        tx3.setText("Student Id     "+string[2]);
    }
}