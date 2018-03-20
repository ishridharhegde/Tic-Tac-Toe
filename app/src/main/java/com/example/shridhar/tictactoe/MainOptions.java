package com.example.shridhar.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainOptions extends Activity
{

    //Waste code
    SharedPreferences mPrefs;
    final String welcomeScreenShownPref = "welcomeScreenShown";

    Button angryButton;
    private String m_Text = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    //Full screen needed code
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.main_options);

        //Making fullscreen
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //Creating the play button link
        angryButton = (Button) findViewById(R.id.angry_btn);

        //Animating game header
        textView = (TextView) findViewById(R.id.gameheader);
        textView.startAnimation((Animation) AnimationUtils.loadAnimation(MainOptions.this,R.anim.translate));


        //Welcome screen
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);

        if (!welcomeScreenShown) {
            // here you can launch another activity if you like
            // the code below will display a popup

            String whatsNewTitle = getResources().getString(R.string.whatsNewTitle);
            String whatsNewText = getResources().getString(R.string.whatsNewText);
            new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_DARK).setIcon(android.R.drawable.ic_dialog_alert).setTitle(whatsNewTitle).setMessage(whatsNewText).setPositiveButton(
                    R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();

            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean(welcomeScreenShownPref, true);
            editor.commit(); // Very important to save the preference
        }



    }

    public void playGame(View view)
    {

        Intent intent = new Intent(MainOptions.this, PlayersName.class);
        intent.putExtra("game",1);
        startActivity(intent);
    }

    //4*4 handle
    public void play4(View view)
    {
        Intent intent = new Intent(MainOptions.this, PlayersName.class);
        intent.putExtra("game",2);
        startActivity(intent);
    }


    //How to play button pressed
    public void howtoplay(View view)
    {
        Intent intent = new Intent(MainOptions.this, howToPlay.class);
        startActivity(intent);
    }


    //About
    public void about(View view)
    {
        Intent intent = new Intent(MainOptions.this, about.class);
        startActivity(intent);
    }


    //Quit button
    public void quit(View view)
    {
        new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("EXIT THE GAME ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


    @Override
    public void onBackPressed()
    {
        new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("EXIT THE GAME ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
        }




    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        immersiveMode();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        immersiveMode();
                    }
                });
    }


    public void immersiveMode() {
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }



}
