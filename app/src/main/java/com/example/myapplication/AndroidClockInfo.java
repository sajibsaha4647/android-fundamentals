package com.example.myapplication;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityAlertDialogInfoBinding;
import com.example.myapplication.databinding.ActivityAndroidClockInfoBinding;

public class AndroidClockInfo extends AppCompatActivity {

    private ActivityAndroidClockInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAndroidClockInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       setupActionBar();
       showTimePicker();
    }


    private void showTimePicker() {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);

//    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
//        (view, selectedHour, selectedMinute) -> {
//            String time = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
//            Toast.makeText(this, "Selected time: " + time, Toast.LENGTH_SHORT).show();
//        }, hour, minute, true); // true for 24-hour format


}




     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("Android Clock"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}