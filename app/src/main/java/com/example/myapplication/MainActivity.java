package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.text.BreakIterator;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    int i = 0;
    private boolean running=true;
    private long pauseoffset;
    final Handler handler = new Handler();
    Animation round;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




//        binding.btnstart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (i<=100){
//                            binding.progressBar.setProgress(i);
//                            i++;
//                            handler.postDelayed(this,60);
//                        }else {
//                            handler.removeCallbacks(this);
//                        }
//
//                    }
//                },60);
//
//            }
//        });
//
    }

    public void starttime (View v){
        final Handler handler = new Handler();

//            handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (i<=100){
//
////                            binding.time.setText(""+i);
////                            binding.progressBar.setProgress(i);
////                            binding.progressBar.setMax(60*time);
//                            binding.circularSeekBar.setProgress(i);
//                            i++;
//                            handler.postDelayed(this,590);
//                        }else {
//                            handler.removeCallbacks(this);
//                        }
//                    }
//                },590);
            binding.time.setBase(SystemClock.elapsedRealtime());
            binding.time.start();
//            running = false;
        startSeekBar(true);


    }
    public void stoptime (View v) {

            i=0;
            pauseoffset = SystemClock.elapsedRealtime() - binding.time.getBase();
            binding.time.stop();
            running = false;
//            binding.circularSeekBar.setProgress(i);
        startSeekBar(false);


    }

    public void startSeekBar(boolean check){
        if (check==true){
            if (binding.circularSeekBar.getProgress()<100){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i==0){

//                            binding.time.setText(""+i);
//                            binding.progressBar.setProgress(i);
//                            binding.progressBar.setMax(60*time);
                            binding.circularSeekBar.setProgress(i);
                            i++;
                            handler.postDelayed(this,590);
                        }else {
                            handler.removeCallbacks(this);
                        }
                    }
                },590);

            }
        }else{
            binding.circularSeekBar.setProgress(0);
        }
    }
}



