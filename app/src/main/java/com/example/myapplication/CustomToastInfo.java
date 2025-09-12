package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityCustomToastInfoBinding;

public class CustomToastInfo extends AppCompatActivity {

    private ActivityCustomToastInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityCustomToastInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();


setPressOnToast();

    }


   private void setPressOnToast() {
    binding.pressCustomToastId.setOnClickListener(e -> {
        showCustomToast();

    });
}

private void showCustomToast() {
    Log.d("tag","press");
    LayoutInflater inflater = getLayoutInflater();
    View layout = inflater.inflate(R.layout.custom_toast, null);

    // Update text
    TextView text = layout.findViewById(R.id.toastText);
    text.setText("Custom toast message here!");

    // Create toast
    Toast toast = new Toast(this); // Activity context (not getApplicationContext())
    toast.setDuration(Toast.LENGTH_LONG);
    toast.setView(layout);

    // Position: bottom, centered, 100px above bottom
    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 10);

    toast.show();

}





     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("CustomToast"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}