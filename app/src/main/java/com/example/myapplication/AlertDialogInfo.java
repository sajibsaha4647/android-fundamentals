package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap; // If you want ordered map

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityAlertDialogInfoBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class AlertDialogInfo extends AppCompatActivity {


    private ActivityAlertDialogInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlertDialogInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this); // This causes the edge-to-edge behavior
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();
         submitButton();
    }


    private void submitButton() {
        // You can use binding here
        binding.clickButton.setOnClickListener(v -> {
            String name = binding.etName.getText().toString();
            String email = binding.etEmail.getText().toString();

//            JSONObject data = new JSONObject();
           Map<String, String> data = new HashMap<>();
            try {
                data.put("name", name);
                data.put("email", email);
//                  Log.d("JSON_DATA", String.valueOf(data));

                   // Validate name
            if (name.isEmpty()) {
                binding.etName.setError("Please enter your name");
                binding.etName.requestFocus();
                return;
            }

            // Validate email
            if (email.isEmpty()) {
                binding.etEmail.setError("Please enter your email");
                binding.etEmail.requestFocus();
                return;
            }

            // Validate email format
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.setError("Please enter a valid email");
                binding.etEmail.requestFocus();
                return;
            }

                showDataInDialog(data);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });
    }

    private void showDataInDialog(Map<String, String> data) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Confirmation")
           .setMessage("Are you sure you want to delete this item?")
           .setPositiveButton("Ok", (dialog, which) -> {
             Toast.makeText(this, "Information submitted successfully", Toast.LENGTH_SHORT).show();
           })
           .setNegativeButton("Cancel", (dialog, which) -> {
               dialog.dismiss();
           });
//           .setNeutralButton("More Info", (dialog, which) -> {
//
//           });

    builder.create().show();
}






     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("Alert dialog"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}