package com.example.myapplication;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    private ActivityMainBinding binding;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






}
    public void starttime (View v){
        countDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                binding.time.setText(""+millisUntilFinished / 1000);
                int pp = (int) (millisUntilFinished / 1000);
                
                binding.progressBar.setProgress(pp);
                // logic to set the EditText could go here
            }

            public void onFinish() {
                binding.time.setText("done!");
            }

        }.start();



    }
    public void stoptime (View v) {
        countDownTimer.cancel();

    }




}



