package com.example.myapplication;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityTimePickerInfoBinding;

public class TimePickerInfo extends AppCompatActivity {

    private ActivityTimePickerInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityTimePickerInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();
        binding.pickTimeId.setOnClickListener(e->{
            showTimePickerDialog();
        });
    }


   private void showTimePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);

    TimePickerDialog timePickerDialog = new TimePickerDialog(
            this,
            (view, selectedHour, selectedMinute) -> {
                binding.setTimeId.setText(
                        String.format("%02d:%02d", selectedHour, selectedMinute)
                );
            },
            hour,
            minute,
            true // true = 24-hour format
    );

    timePickerDialog.show();
}


     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("TimePicker Info"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}