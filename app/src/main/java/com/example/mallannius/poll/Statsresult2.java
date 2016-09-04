package com.example.mallannius.poll;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.*;
import java.text.DecimalFormat;

public class Statsresult2 extends AppCompatActivity {


    TextView results;
    MyDBManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsresult2);

        results = (TextView) findViewById(R.id.results);

        db = new MyDBManager(this);


        db.open();

        int n1 = getCandidatesRows("Catherine Connolly");
        int n2 = getCandidatesRows("Derek Nolan");
        int n3 = getCandidatesRows("Hildegarde Naughton");
        int n4 = getCandidatesRows("James Charity");
        int n5 = getCandidatesRows("John Connolly");
        int n6 = getCandidatesRows("Niall Ó Tuathail");
        int n7 = getCandidatesRows("Mary Hoade");
        int n8 = getCandidatesRows("Fidelma Healy Eames");

        //Calculate statistics
        double p1 = n1;
        p1 = (p1/(n1+n2+n3+n4+n5+n6+n7+n8))*100;
        double p2 = n2;
        p2 = (p2/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p3 = n3;
        p3 = (p3/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p4 = n4;
        p4 = (p4/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p5 = n5;
        p5 = (p5/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p6 = n6;
        p6 = (p6/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p7 = n7;
        p7 = (p7/(n1+n2+n3+n4+n5+n6+n7+n8)*100);
        double p8 = n8;
        p8 = (p8/(n1+n2+n3+n4+n5+n6+n7+n8)*100);

        // Choose the format of statistics result

        DecimalFormat df = new DecimalFormat("#.##");

        //Get statistics
        results.append("\n\n"+df.format(p1)+"% will vote for Catherine Connolly");
        results.append("\n\n"+df.format(p2)+"% will vote for Derek Nolan");
        results.append("\n\n"+df.format(p3)+"% will vote for Hildegarde Naughton");
        results.append("\n\n"+df.format(p4)+"% will vote for James Charity");
        results.append("\n\n"+df.format(p5)+"% will vote for John Connolly");
        results.append("\n\n"+df.format(p6)+"% will vote for Niall Ó Tuathail");
        results.append("\n\n"+df.format(p7)+"% will vote for Mary Hoade");
        results.append("\n\n"+df.format(p8)+"% will vote for Fidelma Healy Eames");

        db.close();
    }

    public int getCandidatesRows(String Candidates) {
        Cursor c = db.getPollbyCandidates(Candidates);
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






