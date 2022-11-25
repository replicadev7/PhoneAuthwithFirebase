package com.rahul.otpverification.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.rahul.otpverification.R;
import com.rahul.otpverification.databinding.ActivitySplashBinding;

public class SplashAct extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor et;
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginOrNot();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean login = sp.getBoolean("isLogin", false);
                Log.e("rrr", "run----: "+login );
                if (login){
                    Intent i=new Intent(SplashAct.this,MainActivity.class);
                    startActivity(i);
                }else {
                    Intent i=new Intent(SplashAct.this,LoginActivity.class);
                    startActivity(i);
                }

            }
        }, 2000);
    }

    private void loginOrNot() {
        sp =getSharedPreferences("checkbox", MODE_PRIVATE);
        et = sp.edit();
        et.putBoolean("isLogin", false);
    }
}