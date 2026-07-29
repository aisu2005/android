package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editName);
        e2 = findViewById(R.id.editEmail);
        e3 = findViewById(R.id.editPass);
        b = findViewById(R.id.button);
        b.setOnClickListener(v -> {
            String name = e1.getText().toString();
            String email = e1.getText().toString();
            String password = e1.getText().toString();

            SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name", name);
            editor.putString("email", email);
            editor.putString("password", password);
            editor.commit();

            Toast.makeText(this,
                    "Registration successful",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("user Name", name);
            startActivity(intent);


        });
    }
}
