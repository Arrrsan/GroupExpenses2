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

        EditText amountInput = findViewById(R.id.editTextNumberSigned);
        Button submitBtn   = findViewById(R.id.submitGroupData);

        final int personIndex = getIntent().getIntExtra("person_index", -1);

        submitBtn.setOnClickListener(v -> {
            String txt = amountInput.getText().toString().trim();
            double amt;
            try {
                amt = Double.parseDouble(txt);
            } catch (NumberFormatException e) {
                Toast.makeText(
                        AddChargeActivity.this,
                        "Please enter a valid number",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            Money charge = new Money(amt);
            CreatingGroupActivity
                    .myGroup
                    .personList
                    .get(personIndex)
                    .addCharge(charge);

            finish();
        });
    }
}
