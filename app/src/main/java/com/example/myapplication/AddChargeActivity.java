package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

import code.Money;

public class AddChargeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_charge);
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.activity_add_charge),
                (v, insets) -> {
                    Insets b = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(b.left, b.top, b.right, b.bottom);
                    return insets;
                }
        );

        // Find the EditText where the user enters the dollar amount, and find the submit button

        EditText amountInput = findViewById(R.id.editTextNumberSigned);
        Button submitBtn   = findViewById(R.id.submitGroupData);

        // Read which person index we’re charging (passed in via Intent)

        final int personIndex = getIntent().getIntExtra("person_index", -1);

        submitBtn.setOnClickListener(v -> {

            // 1) Get the text and trim whitespace

            String txt = amountInput.getText().toString().trim();
            double amt;
            try {
                // 2) Parse the string into a double
                amt = Double.parseDouble(txt);
            } catch (NumberFormatException e) {

                // 3) If parsing fails, show an error toast and bail out

                Toast.makeText(
                        AddChargeActivity.this,
                        "Please enter a valid number",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            // 4) Wrap the parsed amount in your Money class

            Money charge = new Money(amt);

            // 5) Add this charge to the correct Person in your shared group

            CreatingGroupActivity
                    .myGroup
                    .personList
                    .get(personIndex)
                    .addCharge(charge);

            // 6) Finish this Activity—return to the list screen (which will refresh)

            finish();
        });
    }
}
