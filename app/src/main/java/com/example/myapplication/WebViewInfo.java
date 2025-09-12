package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityWebViewInfoBinding;

public class WebViewInfo extends AppCompatActivity {

    private ActivityWebViewInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
         binding = ActivityWebViewInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();

        loadUrl("https://pub.dev");
        setupWebView();
    }


     private void setupWebView() {
        WebSettings webSettings = binding.webview.getSettings();

        // Enable JavaScript
        webSettings.setJavaScriptEnabled(true);

        // Enable DOM storage
        webSettings.setDomStorageEnabled(true);

        // Enable database
        webSettings.setDatabaseEnabled(true);

        // Enable zoom controls
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        // Enable cache
//        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        // Set WebView client to handle links internally
        binding.webview.setWebViewClient(new MyWebViewClient());

        // Set WebChrome client to handle progress
        binding.webview.setWebChromeClient(new MyWebChromeClient());
    }

    private void loadUrl(String url) {
        binding.webview.loadUrl(url);
    }




    // Handle back button press for WebView navigation
    @Override
    public void onBackPressed() {
        if (binding.webview.canGoBack()) {
            binding.webview.goBack();
        } else {
            super.onBackPressed();
        }
    }


     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("WebViewInfo"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }


     // Custom WebViewClient
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            // Load all URLs within WebView
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    // Custom WebChromeClient for progress handling
    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress < 100) {
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.progressBar.setProgress(newProgress);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }
        }
    }
}


