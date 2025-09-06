package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityImageViewBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
        textView = findViewById(R.id.textviewid);
        textView.setText("welcome");

//        RelativeLayId
//                ConstraintLayId

        binding.ButtonViewId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ButtonView.class);
            startActivity(intent);
        });


        binding.RelativeLayId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, RelativelayoutCart.class);
            startActivity(intent);
        });
        binding.ConstraintLayId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ConstraintLayoutCart.class);
            startActivity(intent);
        });

        binding.ImageViewButtonViewId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ImageButtonView.class);
            startActivity(intent);
        });

        binding.EditText.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, EditTextView.class);
            startActivity(intent);
        });

        binding.ImageViewId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ImageView.class);
            startActivity(intent);
        });

        binding.CheckboxId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, CheckBoxView.class);
            startActivity(intent);
        });

         binding.RadioButtonId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, RadioButtonInfo.class);
            startActivity(intent);
        });

        binding.RatingBarId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, RatingBarInfo.class);
            startActivity(intent);
        });

        binding.SeekBarId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, SeekBarInfo.class);
            startActivity(intent);
        });

        binding.SwitchId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, SwitchViewInfo.class);
            startActivity(intent);
        });

        binding.WebViewId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, WebViewInfo.class);
            startActivity(intent);
        });

        binding.DatePickerId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, DatePickerInfo.class);
            startActivity(intent);
        });

        binding.DatePickerDialogId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, DatePickerDialog.class);
            startActivity(intent);
        });

        binding.TimePickerId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, TimePickerInfo.class);
            startActivity(intent);
        });

        binding.TimePickerDialogId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, TimePickerDialog.class);
            startActivity(intent);
        });

        binding.TimePickerDialogId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, TimePickerInfo.class);
            startActivity(intent);
        });

        binding.AndroidClockId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, AndroidClockInfo.class);
            startActivity(intent);
        });

        binding.Alertdialogid.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, AlertDialogInfo.class);
            startActivity(intent);
        });

        binding.Toastid.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ToastInfo.class);
            startActivity(intent);
        });

        binding.CustomToastid.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, CustomToastInfo.class);
            startActivity(intent);
        });

        binding.VideoViewId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, VideoViewInfo.class);
            startActivity(intent);
        });

        binding.ZoomControlId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, ZoomControllInfo.class);
            startActivity(intent);
        });

        binding.FontFamilyId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, FontFamilyInfo.class);
            startActivity(intent);
        });

         binding.WeightSumId.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, WeightSumInfo.class);
            startActivity(intent);
        });


    }
}