package com.shalom.lib.datepicker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.util.Pair;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private SimpleDateFormat dateFormat;

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

        // Initialize date formatter
        dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());

        // Get references to UI elements
        Button btnSingleDatePicker = findViewById(R.id.btnSingleDatePicker);
        Button btnRangeDatePicker = findViewById(R.id.btnRangeDatePicker);
        resultText = findViewById(R.id.resultText);

        // Set up Single Date Picker
        btnSingleDatePicker.setOnClickListener(v -> showSingleDatePicker());

        // Set up Date Range Picker
        btnRangeDatePicker.setOnClickListener(v -> showDateRangePicker());
    }

    private void showSingleDatePicker() {
        // Create a single date picker
        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select a Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        // Handle date selection
        datePicker.addOnPositiveButtonClickListener(selection -> {
            String selectedDate = dateFormat.format(new Date(selection));
            resultText.setText("Single Date: " + selectedDate);
        });

        // Show the date picker
        datePicker.show(getSupportFragmentManager(), "SINGLE_DATE_PICKER");
    }

    private void showDateRangePicker() {
        // Create a date range picker
        MaterialDatePicker<Pair<Long, Long>> dateRangePicker =
                MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select Date Range")
                .build();

        // Handle date range selection
        dateRangePicker.addOnPositiveButtonClickListener(selection -> {
            String startDate = dateFormat.format(new Date(selection.first));
            String endDate = dateFormat.format(new Date(selection.second));
            resultText.setText("Date Range:\nFrom: " + startDate + "\nTo: " + endDate);
        });

        // Show the date range picker
        dateRangePicker.show(getSupportFragmentManager(), "DATE_RANGE_PICKER");
    }
}