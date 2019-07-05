package com.webtek.edupro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Nilabh on 23-01-2018.
 */

public class splash extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (new User(splash.this).getUsername() != "") {
                    startActivity(new Intent(splash.this, student.class));
                    finish();
                } else {
                    startActivity(new Intent(splash.this, MainActivity.class));
                    finish();
                }
            }
        }, 2000);
    }
}
