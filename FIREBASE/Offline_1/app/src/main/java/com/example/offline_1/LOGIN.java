package com.example.offline_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        String[] string = getIntent().getStringArrayExtra("string-array");

        tx1.setText(string[0]);
        tx2.setText(string[1]);
        tx3.setText(string[2]);
    }
}