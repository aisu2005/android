package com.example.intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView a1,a2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        a1=findViewById(R.id.n1);
        a2=findViewById(R.id.n2);

        Bundle extra = getIntent().getExtras();
        String text=extra.getString("name");
        String text1=extra.getString("age");
        a1.setText(text);
        a2.setText(text1);
    }
}

