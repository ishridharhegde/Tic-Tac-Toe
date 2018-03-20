package com.example.shridhar.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

public class FourGridScreen extends Activity
{
    //Create objects for the buttons
    Button b11,b12,b13,b14;
    Button b21,b22,b23,b24;
    Button b31,b32,b33,b34;
    Button b41,b42,b43,b44;
    Button winB1,winB2,winB3;

    Boolean b11click,b12click,b13click,b14click;
    Boolean b21click,b22click,b23click,b24click;
    Boolean b31click,b32click,b33click,b34click;
    Boolean b41click,b42click,b43click,b44click;

    Boolean p1,p2;

    String p1name,p2name;

    Drawable btnClr;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_grid_screen);



        //Link the buttons with their XML attributes
        b11 = (Button) findViewById(R.id.block11);
        b12 = (Button) findViewById(R.id.block12);
        b13 = (Button) findViewById(R.id.block13);
        b14 = (Button) findViewById(R.id.block14);

        b21 = (Button) findViewById(R.id.block21);
        b22 = (Button) findViewById(R.id.block22);
        b23 = (Button) findViewById(R.id.block23);
        b24 = (Button) findViewById(R.id.block24);

        b31 = (Button) findViewById(R.id.block31);
        b32 = (Button) findViewById(R.id.block32);
        b33 = (Button) findViewById(R.id.block33);
        b34 = (Button) findViewById(R.id.block34);

        b41 = (Button) findViewById(R.id.block41);
        b42 = (Button) findViewById(R.id.block42);
        b43 = (Button) findViewById(R.id.block43);
        b44 = (Button) findViewById(R.id.block44);

        //Initialise the flags
        b11click=b12click=b13click=b14click=b21click=b22click=b23click=b24click=b31click=b32click=b33click=b34click=b41click=b42click=b43click=b44click=false;
        p1=p2=false;

        //Getting player names from the calling activity
        Bundle extras = getIntent().getExtras();
        p1name = extras.getString("player1name");
        p2name = extras.getString("player2name");

        //Saving the current button background
        btnClr=b11.getBackground();
        //Intitialising win buttons for reset button not to crash
        winB1=b11;
        winB2=b12;
        winB3=b13;

        p1name += " won the game !";
        p2name += " won the game !";

    }


    // HANDLING BUTTON CLICK EVENTS

    public void b11Clicked(View v)
    {
        if(b11click)    //Check if it was previously clicked
            return;
        b11click=true;      //Click flag true
        if(!p1)
        {
            b11.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b11.setText("O");
            p2=true;
            p1=false;
        }
        row11();
        column11();
        pdiagonal11();
    }

    public void b12Clicked(View v)
    {
        if(b12click)    //Check if it was previously clicked
            return;
        b12click=true;      //Click flag true
        if(!p1)
        {
            b12.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b12.setText("O");
            p2=true;
            p1=false;
        }
        row11();
        row12();
        column21();
        pdiagonal12();
    }

    public void b13Clicked(View v)
    {
        if(b13click)    //Check if it was previously clicked
            return;
        b13click=true;      //Click flag true
        if(!p1)
        {
            b13.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b13.setText("O");
            p2=true;
            p1=false;
        }
        row12();
        row11();
        column31();
        diagonal11();
    }

    public void b14Clicked(View v)
    {
        if(b14click)    //Check if it was previously clicked
            return;
        b14click=true;      //Click flag true
        if(!p1)
        {
            b14.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b14.setText("O");
            p2=true;
            p1=false;
        }
        row12();
        column41();
        diagonal12();
    }

    public void b21Clicked(View v)
    {
        if(b21click)    //Check if it was previously clicked
            return;
        b21click=true;      //Click flag true
        if(!p1)
        {
            b21.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b21.setText("O");
            p2=true;
            p1=false;
        }
        column11();
        column12();
        row21();
        pdiagonal21();
    }

    public void b22Clicked(View v)
    {
        if(b22click)    //Check if it was previously clicked
            return;
        b22click=true;      //Click flag true
        if(!p1)
        {
            b22.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b22.setText("O");
            p2=true;
            p1=false;
        }
        row21();
        row22();
        column21();
        column22();
        pdiagonal22();
    }


    public void b23Clicked(View v)
    {
        if(b23click)    //Check if it was previously clicked
            return;
        b23click=true;      //Click flag true
        if(!p1)
        {
            b23.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b23.setText("O");
            p2=true;
            p1=false;
        }
        row21();
        row22();
        column31();
        column32();
        diagonal21();
    }


    public void b24Clicked(View v)
    {
        if(b24click)    //Check if it was previously clicked
            return;
        b24click=true;      //Click flag true
        if(!p1)
        {
            b24.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b24.setText("O");
            p2=true;
            p1=false;
        }
        row22();
        column41();
        column42();
        diagonal22();
    }


    public void b31Clicked(View v)
    {
        if(b31click)    //Check if it was previously clicked
            return;
        b31click=true;      //Click flag true
        if(!p1)
        {
            b31.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b31.setText("O");
            p2=true;
            p1=false;
        }
        row31();
        column12();
        diagonal11();
    }


    public void b32Clicked(View v)
    {
        if(b32click)    //Check if it was previously clicked
            return;
        b32click=true;      //Click flag true
        if(!p1)
        {
            b32.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b32.setText("O");
            p2=true;
            p1=false;
        }
        row31();
        row32();
        column21();
        column22();
        diagonal12();
        diagonal21();
    }

    public void b33Clicked(View v)
    {
        if(b33click)    //Check if it was previously clicked
            return;
        b33click=true;      //Click flag true
        if(!p1)
        {
            b33.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b33.setText("O");
            p2=true;
            p1=false;
        }
        row31();
        row32();
        column31();
        column32();
        pdiagonal11();
    }

    public void b34Clicked(View v)
    {
        if(b34click)    //Check if it was previously clicked
            return;
        b34click=true;      //Click flag true
        if(!p1)
        {
            b34.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b34.setText("O");
            p2=true;
            p1=false;
        }
        row32();
        column41();
        column42();
        pdiagonal12();
    }

    public void b41Clicked(View v)
    {
        if(b41click)    //Check if it was previously clicked
            return;
        b41click=true;      //Click flag true
        if(!p1)
        {
            b41.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b41.setText("O");
            p2=true;
            p1=false;
        }
        row41();
        column12();
        diagonal21();
    }

    public void b42Clicked(View v)
    {
        if(b42click)    //Check if it was previously clicked
            return;
        b42click=true;      //Click flag true
        if(!p1)
        {
            b42.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b42.setText("O");
            p2=true;
            p1=false;
        }
        row41();
        row42();
        column22();
        diagonal22();
    }

    public void b43Clicked(View v)
    {
        if(b43click)    //Check if it was previously clicked
            return;
        b43click=true;      //Click flag true
        if(!p1)
        {
            b43.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b43.setText("O");
            p2=true;
            p1=false;
        }
        row41();
        row42();
        column32();
        pdiagonal21();
    }

    public void b44Clicked(View v)
    {
        if(b44click)    //Check if it was previously clicked
            return;
        b44click=true;      //Click flag true
        if(!p1)
        {
            b44.setText("×");       //Player 1 plays
            p1=true;
            p2=false;
        }
        else
        {
            b44.setText("O");
            p2=true;
            p1=false;
        }
        row42();
        column42();
        pdiagonal22();
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
                        b11click=b12click=b13click=b14click=b21click=b22click=b23click=b24click=b31click=b32click=b33click=b34click=b41click=b42click=b43click=b44click=false;
                        p1=p2=false;

                        b11.setText("");
                        b12.setText("");
                        b13.setText("");
                        b14.setText("");

                        b21.setText("");
                        b22.setText("");
                        b23.setText("");
                        b24.setText("");

                        b31.setText("");
                        b32.setText("");
                        b33.setText("");
                        b34.setText("");

                        b41.setText("");
                        b42.setText("");
                        b43.setText("");
                        b44.setText("");
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
            promptTheUser(p1name);
        else
            promptTheUser(p2name);
    }


    // CHECKING ROWS AND COLUMNS FOR GAME

    public void row11()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }


    public void row12()
    {
        if(b12.getText().toString()==b13.getText().toString() && b12.getText().toString()==b14.getText().toString())
        {
            winB1=b12;
            winB2=b13;
            winB3=b14;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }



    public void row21()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }


    public void row22()
    {
        if(b22.getText().toString()==b23.getText().toString() && b22.getText().toString()==b24.getText().toString())
        {
            winB1=b22;
            winB2=b23;
            winB3=b24;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void row31()
    {
        if(b31.getText().toString()==b32.getText().toString() && b32.getText().toString()==b33.getText().toString())
        {
            winB1=b31;
            winB2=b31;
            winB3=b33;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void row32()
    {
        if(b32.getText().toString()==b33.getText().toString() && b34.getText().toString()==b33.getText().toString())
        {
            winB1=b32;
            winB2=b33;
            winB3=b34;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }


    public void row41()
    {
        if(b41.getText().toString()==b42.getText().toString() && b42.getText().toString()==b43.getText().toString())
        {
            winB1=b41;
            winB2=b42;
            winB3=b43;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void row42()
    {
        if(b42.getText().toString()==b43.getText().toString() && b44.getText().toString()==b43.getText().toString())
        {
            winB1=b42;
            winB2=b43;
            winB3=b44;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void  column11()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void  column12()
    {
        if(b21.getText().toString()==b31.getText().toString() && b21.getText().toString()==b41.getText().toString())
        {
            winB1=b21;
            winB2=b31;
            winB3=b41;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void column21()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void column22()
    {
        if(b22.getText().toString()==b32.getText().toString() && b22.getText().toString()==b42.getText().toString())
        {
           winB1=b22;
           winB2=b32;
           winB3=b42;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void column31()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void column32()
    {
        if(b23.getText().toString()==b33.getText().toString() && b23.getText().toString()==b43.getText().toString())
        {
            winB1=b23;
            winB2=b33;
            winB3=b43;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }


    public void column41()
    {
        if(b14.getText().toString()==b24.getText().toString() && b24.getText().toString()==b34.getText().toString())
        {
            winB1=b14;
            winB2=b24;
            winB3=b34;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void column42()
    {
        if(b24.getText().toString()==b34.getText().toString() && b24.getText().toString()==b44.getText().toString())
        {
            winB1=b24;
            winB2=b34;
            winB3=b44;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void pdiagonal11()
    {
        if(b11.getText().toString()==b22.getText().toString() && b11.getText().toString()==b33.getText().toString())
        {
            winB1=b11;
            winB2=b22;
            winB3=b33;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void pdiagonal12()
    {
        if(b12.getText().toString()==b23.getText().toString()&& b12.getText().toString()==b34.getText().toString())
        {
            winB1=b12;
            winB2=b23;
            winB3=b34;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void pdiagonal21()
    {
        if(b21.getText().toString()==b32.getText().toString() && b21.getText().toString()==b43.getText().toString())
        {
            winB1=b21;
            winB2=b32;
            winB3=b43;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void pdiagonal22()
    {
        if(b22.getText().toString()==b33.getText().toString() && b22.getText().toString()==b44.getText().toString())
        {
            winB1=b22;
            winB2=b33;
            winB3=b44;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void diagonal11()
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
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void diagonal12()
    {
        if(b14.getText().toString()==b23.getText().toString() && b23.getText().toString()==b32.getText().toString())
        {
            winB1=b14;
            winB2=b23;
            winB3=b32;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void diagonal21()
    {
        if(b23.getText().toString()==b32.getText().toString() && b32.getText().toString()==b41.getText().toString())
        {
            winB1=b23;
            winB2=b32;
            winB3=b41;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }

    public void diagonal22()
    {
        if(b24.getText().toString()==b33.getText().toString() && b33.getText().toString()==b42.getText().toString())
        {
            winB1=b24;
            winB2=b33;
            winB3=b42;
            colorTheButtons();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkWinner(winB1);
                }
            },500);
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void reset(View view)
    {
        b11click=b12click=b13click=b14click=b21click=b22click=b23click=b24click=b31click=b32click=b33click=b34click=b41click=b42click=b43click=b44click=false;
        p1=p2=false;

        b11.setText("");
        b12.setText("");
        b13.setText("");
        b14.setText("");

        b21.setText("");
        b22.setText("");
        b23.setText("");
        b24.setText("");

        b31.setText("");
        b32.setText("");
        b33.setText("");
        b34.setText("");

        b41.setText("");
        b42.setText("");
        b43.setText("");
        b44.setText("");
        winB1.setBackground(btnClr);
        winB2.setBackground(btnClr);
        winB3.setBackground(btnClr);

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
