package com.vnurture.vnurture.gmaillayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by VNurtureTechnologies on 12/01/17.
 */

public class SplashScreenGmail extends Activity{

    ImageView logoSplashImage;
    private static int SPLASH_TIME_OUT = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_layout);


        logoSplashImage = (ImageView) findViewById(R.id.splash_logo);

        Animation logoAnimation = AnimationUtils.loadAnimation(this,R.anim.move_animation);

        logoSplashImage.startAnimation(logoAnimation);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenGmail.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
