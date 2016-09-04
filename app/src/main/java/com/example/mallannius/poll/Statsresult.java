package com.example.mallannius.poll;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.*;
import java.text.DecimalFormat;

public class Statsresult extends AppCompatActivity {


    TextView results;
    MyDBManager db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsresult);

        results = (TextView) findViewById(R.id.results);

        db = new MyDBManager(this);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            results.setText("Selected age range is: "+bundle.getString("Age") + "\n" + "Selected gender is: " + " ");
            results.append(bundle.getString("Gender") + "\n");
        }

        db.open();

        int n1 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Catherine Connolly");
        int n2 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Derek Nolan");
        int n3 =getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Hildegarde Naughton");
        int n4 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "James Charity");
        int n5 =getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "John Connolly");
        int n6 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Niall Ó Tuathail");
        int n7 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Mary Hoade");
        int n8 = getGenderANDAgeRows(bundle.getString("Gender"), bundle.getString("Age"), "Fidelma Healy Eames");

        //Calculate statistics
    int n = n1+n2+n3+n4+n5+n6+n7+n8;
        double p1 = n1;
        p1 = (p1/(n))*100;
        double p2 = n2;
        p2 = (p2/(n)*100);
        double p3 = n3;
        p3 = (p3/(n)*100);
        double p4 = n4;
        p4 = (p4/(n)*100);
        double p5 = n5;
        p5 = (p5/(n)*100);
        double p6 = n6;
        p6 = (p6/(n)*100);
        double p7 = n7;
        p7 = (p7/(n)*100);
        double p8 = n8;
        p8 = (p8/(n)*100);

        // Choose the format of statistics result
        DecimalFormat df = new DecimalFormat("#.##");

        //Get statistics
        results.append("\nThe number of voters in this category is : "+n+"\n\nVotes are broken down as follows:");
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

    public int getGenderANDAgeRows(String Gender, String Age, String Candidate) {
        Cursor c = db.getPollbyGenderAndAge(Gender,Age, Candidate);
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





