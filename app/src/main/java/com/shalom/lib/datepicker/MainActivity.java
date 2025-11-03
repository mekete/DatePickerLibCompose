package com.shalom.lib.datepicker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.shalom.android.material.datepicker.EthiopicDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Test app for Ethiopian Date Picker Library
 */
public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowPicker = findViewById(R.id.btnShowPicker);
        resultText = findViewById(R.id.resultText);

        btnShowPicker.setOnClickListener(v -> showEthiopicDatePicker());
    }

    private void showEthiopicDatePicker() {
        EthiopicDatePicker datePicker = EthiopicDatePicker.Builder.datePicker()
                .setTitleText("Select Ethiopian Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        datePicker.addOnPositiveButtonClickListener(selection -> {
            String selectedDate = dateFormat.format(new Date(selection));
            resultText.setText("Selected Date:\n" + selectedDate + "\n\n(Ethiopian calendar conversion coming in Phase 2)");
        });

        datePicker.show(getSupportFragmentManager(), "ETHIOPIC_DATE_PICKER");
    }
}