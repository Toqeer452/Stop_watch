package com.example.myapplication;

import android.media.MediaPlayer;
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
    MediaPlayer mp,sp;



    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mp = MediaPlayer.create(this, R.raw.buzzer);
        sp = MediaPlayer.create(this,R.raw.buzzer);







}
    public void starttime (View v){
        int time = 0;
        countDownTimer = new CountDownTimer(61000, 1000) {
            public void onTick(long millisUntilFinished) {
                mp.start();
//                binding.time.setText(""+millisUntilFinished / 1000);
                binding.time.setText(""+millisUntilFinished / 1000);
//                int pp = (int) (millisUntilFinished / 1000);
                int pp = (int) (millisUntilFinished / 1000);

                if (pp<56){
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                }
                if (pp<=3){
                    sp.start();
                    if (pp<=0){
                        sp.stop();
                    }
                }

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



