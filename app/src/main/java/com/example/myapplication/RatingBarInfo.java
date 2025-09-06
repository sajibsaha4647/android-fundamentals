package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityRatingBarInfoBinding;

public class RatingBarInfo extends AppCompatActivity {

    private ActivityRatingBarInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRatingBarInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();
        submitRatingBar();
    }

    private void submitRatingBar(){
       binding.SubmitRatingId.setOnClickListener(e->{
           binding.ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser)->{
               Log.d("TAG", "ratingBar1: " + ratingBar1);
               Log.d("TAG", "rating: " + rating);
               Log.d("TAG", "fromUser: " + fromUser);
               if (fromUser) {
                   Toast.makeText(this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
               }
           });
       });
    }



     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("RatingBarInfo"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}