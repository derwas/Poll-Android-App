package com.example.mallannius.poll;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.*;
import java.text.DecimalFormat;

public class Statsresult1 extends AppCompatActivity {


    TextView results;
    MyDBManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsresult1);

        results = (TextView) findViewById(R.id.results);

        db = new MyDBManager(this);

        db.open();

        int n1 = getVoterRows("Yes");
        int n2 = getVoterRows("No");

        //Calculate statistics
        double p1 = n1;
        p1 = (p1/(n1+n2))*100;
        double p2 = n2;
        p2 = (p2/(n1+n2)*100);

        // Choose the format of statistics result
        DecimalFormat df = new DecimalFormat("#.##");

        //Get statistcs
        results.append("\n\n"+df.format(p1)+"% will vote");
        results.append("\n\n"+df.format(p2)+"% will NOT vote");

        db.close();
    }



    public int getVoterRows(String Vote) {
        Cursor c = db.getPollbyVoter(Vote);
        int n=0;
        if (c.moveToFirst()) {
            do {
                n++;
            }
            while (c.moveToNext());
        }
        return n;
    }


}





