package com.myapp.nilesh.connect3game;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer=0;
    int[] initialstate={2,2,2,2,2,2,2,2,2};
    int[][] winningpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean activestate=true;
    boolean gameisover=true;
public void click(View view) {
   for (int k = 0; k < initialstate.length; k++) {
        if (initialstate[k] == 2) {
            gameisover = false;
            break;
        }
        else
            gameisover = true;

    }
    if (  !gameisover) {
        ImageView counter = (ImageView) view;

        int tap = Integer.parseInt(counter.getTag().toString());
        if (initialstate[tap] == 2 && activestate) {
            initialstate[tap] = activeplayer;
            counter.setTranslationY(-1500);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.zero);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.cross);
                activeplayer = 0;
            }

            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] winningposition : winningpos) {
                if (initialstate[winningposition[0]] == initialstate[winningposition[1]] && initialstate[winningposition[1]] == initialstate[winningposition[2]] && initialstate[winningposition[0]] != 2) {

                    String message = "";
                    if (activeplayer == 1) {
                        message = "Zero";

                    } else {
                        message = "Cross";

                    }
                    activestate = false;
                    Button playagain = (Button) findViewById(R.id.playagain);
                    TextView winner = (TextView) findViewById(R.id.winner);
                    winner.setText(message + " has won!");
                    playagain.setVisibility(View.VISIBLE);
                    winner.setVisibility(View.VISIBLE);

                }

            }
        }
    }else {
        //boolean gameisover = true;
        //for(int gamestate: initialstate)

        //if (gameisover == true && (initialstate[winningposition[0]] != initialstate[winningposition[1]] && initialstate[winningposition[1]] != initialstate[winningposition[2]])) {
        //if (gameisover == true) {

        Button playagain = (Button) findViewById(R.id.playagain);
        TextView winner = (TextView) findViewById(R.id.winner);
        winner.setText("It's a draw");
        playagain.setVisibility(View.VISIBLE);
        winner.setVisibility(View.VISIBLE);



    }

}
public void playagain(View view)
{
    Button playagain=(Button)findViewById(R.id.playagain);
    TextView winner=(TextView)findViewById(R.id.winner);
    playagain.setVisibility(View.INVISIBLE);
    winner.setVisibility(View.INVISIBLE);
    GridLayout gridLayout2=(GridLayout)findViewById(R.id.gridLayout2);
    for(int i=0;i<gridLayout2.getChildCount();i++)
    {
        ImageView counter=(ImageView) gridLayout2.getChildAt(i);
        counter.setImageDrawable(null);
    }
    for(int j=0;j<initialstate.length;j++)
    {
        initialstate[j]=2;
    }
    activeplayer=0;
    activestate=true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
