package com.example.simplecalculator_gridlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2;
    EditText e1, e2;
    Button sum, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        // Correct line
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextText3);
        e2 = findViewById(R.id.editTextText4);

        sum = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mul = findViewById(R.id.button3);
        div = findViewById(R.id.button4);

        t1 = findViewById(R.id.textView7);
        t2 = findViewById(R.id.textView11);

        // Addition
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());

                double cal = f1 + f2;

                t2.setText("Addition = " + cal);
            }
        });

        // Subtraction
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());

                double cal = f1 - f2;

                t2.setText("Subtraction = " + cal);
            }
        });

        // Multiplication
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());

                double cal = f1 * f2;

                t2.setText("Multiplication = " + cal);
            }
        });

        // Division
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());

                double cal = f1 / f2;

                t2.setText("Division = " + cal);
            }
        });
    }
}
