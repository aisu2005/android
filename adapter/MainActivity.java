package com.example.adapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText num1, num2;
    Button btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnDivide = findViewById(R.id.btnDivide);

        String[] students = {
                "Anjali",
                "Nandana",
                "Leya",
                "Riya",
                "Miya",
                "Anu",
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        students
                );

        listView.setAdapter(adapter);

        btnDivide.setOnClickListener(v -> {
            try {
                int a = Integer.parseInt(
                        num1.getText().toString()
                );
                int b = Integer.parseInt(
                        num2.getText().toString()
                );
                int result = a / b;

                Toast.makeText(
                        MainActivity.this,
                        "Result = " + result,
                        Toast.LENGTH_SHORT
                ).show();
            } catch (ArithmeticException e) {
                Toast.makeText(
                        MainActivity.this,
                        "Cannot divide by zero",
                        Toast.LENGTH_SHORT
                ).show();
            } catch (NumberFormatException e) {
                Toast.makeText(
                        MainActivity.this,
                        "Enter valid numbers",
                        Toast.LENGTH_SHORT
                ).show();
            } catch (Exception e) {
                Toast.makeText(
                        MainActivity.this,
                        "An error occured",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}





