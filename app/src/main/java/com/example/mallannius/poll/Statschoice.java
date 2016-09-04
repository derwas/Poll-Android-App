package com.example.mallannius.poll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statschoice extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    String db_vote;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statschoice);


        button1 = (Button) findViewById(R.id.option1);
        button2 = (Button) findViewById(R.id.option2);
        button3 = (Button) findViewById(R.id.option3);
        button4 = (Button) findViewById(R.id.option4);

        // Click and move to the next activity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statschoice.this, Stats.class);
                startActivity(intent);
            }
        });

        // Click and move to the next activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statschoice.this, Stats1.class);
                startActivity(intent);
            }
        });

        // Click and move to the next activity
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statschoice.this, Statsresult1.class);
                intent.putExtra("Vote",db_vote);
                startActivity(intent);
            }
        });

        // Click and move to the next activity
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statschoice.this, Statsresult2.class);
                startActivity(intent);
            }
        });



    }
}


