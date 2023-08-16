package com.example.bitcointors_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView objText = null;
    private EditText inrEditText = null;
    private TextView resultTextView = null;

    // Conversion rate
    private static final double BITCOIN_TO_INR = 2438063.00;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objText = findViewById(R.id.textHello);
        inrEditText = findViewById(R.id.inr);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void Convert(View view) {
        // Get the input value in INR from the EditText
        String inrValueString = inrEditText.getText().toString();

        if (!inrValueString.isEmpty()) {
            // Parse the input value to a double
            double inrValue = Double.parseDouble(inrValueString);

            // Convert Bitcoin value
            double bitcoinValue = inrValue / BITCOIN_TO_INR;

            // Display the converted Bitcoin value in the resultTextView
            resultTextView.setText(String.format("%.6f Bitcoin", bitcoinValue));
            Toast.makeText(getApplicationContext(), "This is the total Bitcoin value of your entered amount", Toast.LENGTH_LONG).show();
        } else {
            // Handle the case where the input value is empty
            resultTextView.setText("Enter a value in INR");
        }
    }
}
