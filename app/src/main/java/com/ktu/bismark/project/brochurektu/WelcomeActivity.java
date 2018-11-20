package com.ktu.bismark.project.brochurektu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity {

    LinearLayout lay1,lay2;
    Button btNext;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        lay1 = findViewById(R.id.layout1);
        lay2 = findViewById(R.id.layout2);
        btNext = findViewById(R.id.btnNext);

        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);

        lay1.setAnimation(uptodown);
        lay2.setAnimation(downtoup);

        SharedPreferences prefs;
        SharedPreferences.Editor sharedEditor;

        prefs = getSharedPreferences("mySharePref", Context.MODE_PRIVATE);
        sharedEditor = prefs.edit();
        if (prefs.getBoolean("isFirstTime",true)){
            sharedEditor.putBoolean("isFirstTime",false);
            sharedEditor.apply();
        }
        else {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
    }
}
