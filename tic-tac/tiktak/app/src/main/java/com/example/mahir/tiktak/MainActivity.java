package com.example.mahir.tiktak;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button [] B_array;
    boolean turn = true; //X = true 0 = false
    int turn_count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)this.findViewById(R.id.button1);
        b2 = (Button)this.findViewById(R.id.button2);
        b3 = (Button)this.findViewById(R.id.button3);
        b4 = (Button)this.findViewById(R.id.button4);
        b5 = (Button)this.findViewById(R.id.button5);
        b6 = (Button)this.findViewById(R.id.button6);
        b7 = (Button)this.findViewById(R.id.button7);
        b8 = (Button)this.findViewById(R.id.button8);
        b9 = (Button)this.findViewById(R.id.button9);
        B_array = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9};

        for(Button b : B_array){

            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
    Button b = (Button) v;
        buttonclicked(b);
    }
    public void buttonclicked(Button b){
        if(turn){
            b.setText("X");
            b.setBackgroundColor(Color.CYAN);
        }else{
            b.setText("0");
            b.setBackgroundColor(Color.GREEN);
        }

        b.setClickable(false);
        turn = !turn;
        checkwinner();
    }
    private void checkwinner(){
        boolean winner = false;
        if(b1.getText()==b2.getText() && b2.getText() == b3.getText() && (!b2.isClickable()||!b1.isClickable() || !b3.isClickable()))
            winner=true;
        else if(b4.getText()==b5.getText() && b5.getText() == b6.getText() && (!b5.isClickable() || !b4.isClickable() || !b6.isClickable()))
            winner = true;
        else if (b7.getText()==b8.getText() && b8.getText() == b9.getText() && (!b8.isClickable() || !b7.isClickable() || !b9.isClickable()))
            winner = true;
        else if(b1.getText()==b4.getText() && b4.getText() == b7.getText() && ((!b1.isClickable() || !b4.isClickable() || !b7.isClickable())))
            winner = true;
        else if (b2.getText()==b5.getText() && b5.getText() == b8.getText() && (!b5.isClickable() || !b2.isClickable() || !b8.isClickable()))
            winner = true;
        else if (b3.getText()==b6.getText() && b6.getText() == b9.getText() && (!b9.isClickable() || !b6.isClickable() || !b3.isClickable()))
            winner = true;
        else if (b1.getText()==b5.getText() && b5.getText() == b9.getText() && (!b1.isClickable() || !b5.isClickable() || !b9.isClickable()))
            winner = true;
        else if (b3.getText()==b5.getText() && b5.getText() == b7.getText() && (!b5.isClickable() || !b3.isClickable() || !b7.isClickable()))
            winner = true;
        
        if(winner){
            if(!turn){
                Toast.makeText(getApplicationContext(), "X Wins", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "0 Wins", Toast.LENGTH_SHORT).show();
            }
            for(Button b:B_array){
                b.setClickable(false);

            }
        }
    }
}
