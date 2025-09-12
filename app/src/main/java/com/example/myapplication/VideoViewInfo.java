package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityButtonviewBinding;
import com.example.myapplication.databinding.ActivityVideoViewInfoBinding;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class VideoViewInfo extends AppCompatActivity {

    private ActivityVideoViewInfoBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
         binding = ActivityVideoViewInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupActionBar();

//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(binding.videoView);
//        binding.videoView.setMediaController(mediaController);
////            String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
//           Uri uri = Uri.parse("https://www.html5videoplayer.net/videos/toystory.mp4");
//binding.videoView.setVideoURI(uri);
//binding.videoView.start();

PlayerView playerView = binding.playerView; // must match the PlayerView ID
SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();
playerView.setPlayer(player);

// Local raw video
Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
MediaItem mediaItem = MediaItem.fromUri(uri);

player.setMediaItem(mediaItem);
player.prepare();
player.play();


//binding.videoView.setOnErrorListener((mp, what, extra) -> {
//    Log.e("VideoDebug", "VideoView Error: what=" + what + " extra=" + extra);
//    return true;
//});

    }




     private void setupActionBar() {
        // Get the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
            getSupportActionBar().setDisplayShowHomeEnabled(true); // Make it clickable
            getSupportActionBar().setTitle("VideoViewInfo"); // Set title
        }
    }

    // Handle back button clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back when button is clicked
        return true;
    }
}