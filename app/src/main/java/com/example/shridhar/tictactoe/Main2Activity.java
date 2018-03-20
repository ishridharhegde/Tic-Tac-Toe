package com.example.shridhar.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends Activity
{

    protected Button b11,b12,b13,b21,b22,b23,b31,b32,b33;
    protected boolean b11click,b12click,b13click,b21click,b22click,b23click,b31click,b32click,b33click;
    protected boolean player1,player2;
    protected String p1,p2;
    protected boolean gameOver; //Simply to say wether game is over or not, may be useful for later versions of the app
    Drawable btnClr;
    Button winB1,winB2,winB3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        b11=(Button) findViewById(R.id.block11);
        b12=(Button) findViewById(R.id.block12);
        b13=(Button) findViewById(R.id.block13);
        b21=(Button) findViewById(R.id.block21);
        b22=(Button) findViewById(R.id.block22);
        b23=(Button) findViewById(R.id.block23);
        b31=(Button) findViewById(R.id.block31);
        b32=(Button) findViewById(R.id.block32);
        b33=(Button) findViewById(R.id.block33);

//        pl1=(EditText) findViewById(R.id.pl1name);
//        pl2=(EditText) findViewById(R.id.pl2name);

        b11click=b12click=b13click=b21click=b22click=b23click=b31click=b32click=b33click=false;
        player1=false;
        player2=false;

        //Getting the names of the players from the bundle in PlayersName class
        Bundle extras = getIntent().getExtras();
        p1 = extras.getString("player1name");
        p2 = extras.getString("player2name");

        //Getting background of the button to reset after we color them
        btnClr=b11.getBackground();
        //initialising the win buttons for the restart buttons not to crash
        winB1=b11;
        winB2=b12;
        winB3=b13;

        p1=p1+" won th game !";
        p2=p2+" won the game !";

    }


    public void b11Clicked(View v)
    {
        if(b11click)    //Check if it was previously clicked
            return;
        b11click=true;      //Click flag true
        if(!player1)
        {
            b11.setText("×");       //Player 1 plays
            player1=true;
            player2=false;
        }
        else
        {
            b11.setText("O");
            player2=true;
            player1=false;
        }

        row1();
        column1();
        pdiagonal();

    }

    public void b12Clicked(View v)
    {
        if(b12click)
            return;
        b12click=true;
        if(!player1)
        {
            b12.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b12.setText("O");
            player2=true;
            player1=false;
        }

        row1();
        column2();

    }

    public void b13Clicked(View v)
    {
        if(b13click)
            return;
        b13click=true;
        if(!player1)
        {
            b13.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b13.setText("O");
            player2=true;
            player1=false;
        }

        row1();
        column3();
        diagonal();

    }

    public void b21Clicked(View view)
    {
        if(b21click)
            return;
        b21click=true;
        if(!player1)
        {
            b21.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b21.setText("O");
            player2=true;
            player1=false;
        }

        row2();
        column1();

    }

    public void b22Clicked(View view)
    {
        if(b22click)
            return;
        b22click=true;
        if(!player1)
        {
            b22.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b22.setText("O");
            player2=true;
            player1=false;
        }

        row2();
        column2();
        pdiagonal();
        diagonal();

    }

    public void b23Clicked(View view)
    {
        if(b23click)
            return;
        b23click=true;
        if(!player1)
        {
            b23.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b23.setText("O");
            player2=true;
            player1=false;
        }

        row2();
        column3();
    }

    public void b31Clicked(View view)
    {
        if(b31click)
            return;
        b31click=true;

        if(!player1)
        {
            b31.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b31.setText("O");
            player2=true;
            player1=false;
        }

        row3();
        column1();
        diagonal();

    }

    public void b32Clicked(View view)
    {
        if(b32click)
            return;
        b32click=true;
        if(!player1)
        {
            b32.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b32.setText("O");
            player2=true;
            player1=false;
        }

        row3();
        column2();

    }

    public void b33Clicked(View view)
    {
        if(b33click)
            return;
        b33click=true;
        if(!player1)
        {
            b33.setText("×");
            player1=true;
            player2=false;
        }
        else
        {
            b33.setText("O");
            player2=true;
            player1=false;
        }

        row3();
        column3();
        pdiagonal();

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void reset(View v)
    {
        b11.setText("");
        b12.setText("");
        b13.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");
        player1=player2=false;
        b11click=b12click=b13click=b21click=b22click=b23click=b31click=b32click=b33click=false;
        winB1.setBackground(btnClr);
        winB2.setBackground(btnClr);
        winB3.setBackground(btnClr);
    }



    //Color the buttons
    public void colorTheButtons()
    {
        winB1.setBackgroundColor(Color.CYAN);
        winB2.setBackgroundColor(Color.CYAN);
        winB3.setBackgroundColor(Color.CYAN);

    }


    //Prompt the user after someone wins
    public void promptTheUser(String winner)
    {
        new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(winner)
                .setMessage("You want to continue ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        b11.setText("");
                        b12.setText("");
                        b13.setText("");
                        b21.setText("");
                        b22.setText("");
                        b23.setText("");
                        b31.setText("");
                        b32.setText("");
                        b33.setText("");
                        player1=player2=false;
                        b11click=b12click=b13click=b21click=b22click=b23click=b31click=b32click=b33click=false;
                        winB1.setBackground(btnClr);
                        winB2.setBackground(btnClr);
                        winB3.setBackground(btnClr);
                    }

                })
                .setNegativeButton("No",new DialogInterface.OnClickListener()
                {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }

                })
                .show();
    }


    //Check who is the winner
    public void checkWinner(Button button)
    {
        if(TextUtils.equals(button.getText(),"×"))
            promptTheUser(p1);
        else
            promptTheUser(p2);
    }





    //Functions to check if the game is done or not

    public void row1()
    {
        if(b11.getText().toString()==b12.getText().toString() && b11.getText().toString()==b13.getText().toString())
        {
            winB1=b11;
            winB2=b12;
            winB3=b13;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b11);
                }
            },500);

        }
    }

    public void row2()
    {
        if(b21.getText().toString()==b22.getText().toString() && b22.getText().toString()==b23.getText().toString())
        {
            winB1=b21;
            winB2=b22;
            winB3=b23;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b21);
                }
            },500);

        }
    }

    public void row3()
    {
        if(b31.getText().toString()==b32.getText().toString() && b32.getText().toString()==b33.getText().toString())
        {
            winB1=b31;
            winB2=b32;
            winB3=b33;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b31);
                }
            },500);
        }
    }

    public void  column1()
    {
        if(b11.getText().toString()==b21.getText().toString() && b21.getText().toString()==b31.getText().toString())
        {
            winB1=b11;
            winB2=b21;
            winB3=b31;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b11);
                }
            },500);
        }
    }

    public void column2()
    {
        if(b12.getText().toString()==b22.getText().toString() && b22.getText().toString()==b32.getText().toString())
        {
            winB1=b12;
            winB2=b22;
            winB3=b32;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b12);
                }
            },500);
        }
    }

    public void column3()
    {
        if(b13.getText().toString()==b23.getText().toString() && b23.getText().toString()==b33.getText().toString())
        {
            winB1=b13;
            winB2=b23;
            winB3=b33;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b13);
                }
            },500);
        }
    }

    public void pdiagonal()
    {
        if(b11.getText().toString()==b22.getText().toString() && b22.getText().toString()==b33.getText().toString())
        {
            winB1=b11;
            winB2=b22;
            winB3=b33;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b11);
                }
            },500);
        }
    }

    public void diagonal()
    {
        if(b13.getText().toString()==b22.getText().toString() && b22.getText().toString()==b31.getText().toString())
        {
            winB1=b13;
            winB2=b22;
            winB3=b31;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(b13);
                }
            },500);
        }
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



    @Override
    public void onBackPressed()
    {
        new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("CLOSING THE CURRENT GAME")
                .setMessage("All your progress will be lost ! Are you sure you want to close ?")
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


}
