package com.example.validation;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioGroup radioGroup;
    Spinner spinner;
    CheckBox checkBox;
    Button btnSubmit;

    String[] country = {"Select Country", "India", "USA", "UK", "Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Connecting Java variables with XML views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkBox);

        btnSubmit = findViewById(R.id.btnSubmit);

        // Spinner Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                country
        );

        spinner.setAdapter(adapter);

        // Submit Button
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Name validation
                if (name.isEmpty()) {
                    etName.setError("Enter Name");
                    etName.requestFocus();
                    return;
                }

                // Email validation
                if (email.isEmpty()) {
                    etEmail.setError("Enter Email");
                    etEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Invalid Email");
                    etEmail.requestFocus();
                    return;
                }

                // Password validation
                if (password.length() < 8) {
                    etPassword.setError(
                            "Password must be at least 8 characters"
                    );
                    etPassword.requestFocus();
                    return;
                }

                // Gender validation
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(
                            MainActivity.this,
                            "Select Gender",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                // Country validation
                if (spinner.getSelectedItemPosition() == 0) {
                    Toast.makeText(
                            MainActivity.this,
                            "Select Country",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                // Terms and Conditions validation
                if (!checkBox.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Accept Terms and Conditions",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                // Successful validation
                Toast.makeText(
                        MainActivity.this,
                        "Validation Successful",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
