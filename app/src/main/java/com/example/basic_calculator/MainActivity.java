package com.example.basic_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2, addResult, subResult, multiResult, divResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        addResult = findViewById(R.id.editTextNumberAddResult);
        subResult = findViewById(R.id.editTextNumber5SubResult);
        multiResult = findViewById(R.id.editTextNumberMultiResult);
        divResult = findViewById(R.id.editTextNumberDivResult);
    }

    public void Add(View view) {
        if (validateInputs()) {
            float a = Float.parseFloat(num1.getText().toString());
            float b = Float.parseFloat(num2.getText().toString());
            addResult.setText(String.format("%.3f",a + b));
        }
    }

    public void Subtract(View view) {
        if (validateInputs()) {
            float a = Float.parseFloat(num1.getText().toString());
            float b = Float.parseFloat(num2.getText().toString());
            subResult.setText(String.format("%.3f",a - b));
        }
    }

    public void Multiply(View view) {
        if (validateInputs()) {
            float a = Float.parseFloat(num1.getText().toString());
            float b = Float.parseFloat(num2.getText().toString());
            multiResult.setText(String.format("%.3f",a * b));
        }
    }

    public void Divide(View view) {
        if (validateInputs()) {
            float a = Float.parseFloat(num1.getText().toString());
            float b = Float.parseFloat(num2.getText().toString());
            if (b == 0) {
                Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                divResult.setText("Error");
            } else {
                divResult.setText(String.format("%.3f",a / b));
            }
        }
    }

    private boolean validateInputs() {
        if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
