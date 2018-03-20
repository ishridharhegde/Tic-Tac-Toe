package com.example.shridhar.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ImageView myImageView = (ImageView) findViewById(R.id.imgvw);
        TextView myTextView = (TextView)findViewById(R.id.welcome);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        myImageView.startAnimation(myFadeInAnimation);
        myTextView.startAnimation(myFadeInAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                 Intent i=new Intent(MainActivity.this, MainOptions.class);
                startActivity(i);
                finish();
            }
        }, 2500);
    }



    @Override
    protected void onRestart()
    {
        super.onRestart();
        finish();
    }


}
