package com.example.shridhar.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayersName extends Activity
{
    EditText pl1;
    EditText pl2;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_name);

        //Making fullscreen
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        pl1 = (EditText) findViewById(R.id.player1name);
        pl2 = (EditText) findViewById(R.id.player2name);

        Intent mIntent = getIntent();
        game = mIntent.getIntExtra("game",1);

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


    public void playTheGame(View view)
    {
        if(TextUtils.isEmpty(pl1.getText()) || TextUtils.isEmpty(pl2.getText()))
        {
            new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Oops! Players details not entered.\nKindly enter the names ~_~")
                .setCancelable(false)
                .setNegativeButton("Ok. I will enter.", null)
                .show();

        }
        else
        {

            Intent g1 = new Intent(this, Main2Activity.class);
            Intent g2 = new Intent(this,FourGridScreen.class);
            Bundle extras = new Bundle();
            extras.putString("player1name",pl1.getText().toString());
            extras.putString("player2name",pl2.getText().toString());

            if(game==1)
            {
                g1.putExtras(extras);
                startActivity(g1);
            }
            else
            {
                g2.putExtras(extras);
                startActivity(g2);
            }

        }

    }


    @Override
    protected void onRestart()
    {
        super.onRestart();
        finish();
    }


}
