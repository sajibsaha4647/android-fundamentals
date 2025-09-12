package com.example.myapplication;
import android.widget.DatePicker;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Locale;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;


import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityDatePickerInfoBinding;

import java.text.SimpleDateFormat;

public class DatePickerInfo extends AppCompatActivity {

   private ActivityDatePickerInfoBinding binding;
    private Calendar calendar;
    private int currentFormat = 0; // 0: MM/DD/YYYY, 1: DD-MM-YYYY, 2: Full Date
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
       binding = ActivityDatePickerInfoBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
         ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
    return insets;
});
       setupActionBar();
        // Initialize calendar
        calendar = Calendar.getInstance();

        // Set current date to the DatePicker
        updateDatePickerFromCalendar();

        // Display initial date
        updateSelectedDateText();

//        showDatePickerDialog();

           // Set up date change listener for the DatePicker
        binding.datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                updateSelectedDateText();
            }
        });

        // Set up button click listeners using view binding
        binding.btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        binding.btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToToday();
            }
        });

        binding.btnFormat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFormat = 0;
                updateSelectedDateText();
            }
        });

        binding.btnFormat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFormat = 1;
                updateSelectedDateText();
            }
        });

        binding.btnFormat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFormat = 2;
                updateSelectedDateText();
            }
        });


    }

   private void showDatePickerDialog() {
    // Get current date from calendar
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    // Create DatePickerDialog
    DatePickerDialog datePickerDialog = new DatePickerDialog(
            this,
            (view, selectedYear, selectedMonth, selectedDay) -> {
                // Update calendar
                calendar.set(Calendar.YEAR, selectedYear);
                calendar.set(Calendar.MONTH, selectedMonth);
                calendar.set(Calendar.DAY_OF_MONTH, selectedDay);

                // Update TextView
                binding.selectedDateText.setText(
                        selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear
                );
            },
            year,
            month,
            day
    );

    // Optional: restrict to today or future dates
    // datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

    // Show the dialog
    datePickerDialog.show();
}


      private void setToToday() {
        calendar = Calendar.getInstance();
        updateDatePickerFromCalendar();
        updateSelectedDateText();
        Toast.makeText(this, "Set to today's date", Toast.LENGTH_SHORT).show();
    }

    private void updateDatePickerFromCalendar() {
        binding.datePicker.updateDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    private void updateSelectedDateText() {
        String formattedDate;

        switch (currentFormat) {
            case 1:
                formattedDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.getTime());
                break;
            case 2:
                formattedDate = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault()).format(calendar.getTime());
                break;
            default:
                formattedDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(calendar.getTime());
        }

        binding.selectedDateText.setText("Selected Date: " + formattedDate);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null; // Clean up binding reference
    }



     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("DatePicker Info"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}