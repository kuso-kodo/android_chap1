package com.name1e5s.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final String msg = "Hello World!";
    private int tapCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("name1e5s", msg);
        setContentView(R.layout.activity_main);

        final Button buttonTapHere = findViewById(R.id.buttonTapHere);
        final TextView textViewTapHere = findViewById(R.id.textViewTapButton);
        buttonTapHere.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                tapCount += 1;
                textViewTapHere.setText(String.format("You tapped th button %d times", tapCount));
            }
        });

        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textViewSeekBar = findViewById(R.id.textViewSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double value = progress * 100.0f / seekBar.getMax();
                textViewSeekBar.setText(String.format("%.2f%%", value));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        final ImageView imageView = findViewById(R.id.imageView);
        final Button buttonImageView = findViewById(R.id.buttonImageView);
        final int[] imageArray = {
                R.mipmap.egypt,
                R.mipmap.london,
                R.mipmap.paris,
                R.mipmap.rome,
                R.mipmap.pisa,
                R.mipmap.shanghai,
                R.mipmap.syndey,
                R.mipmap.wash
        };
        buttonImageView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                int index = new Random().nextInt(imageArray.length);
                imageView.setImageResource(imageArray[index]);
            }
        });

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://job.bytedance.com/campus/");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
