package com.example.mallannius.poll;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Database extends AppCompatActivity {

    TextView results;
    MyDBManager db;
    LinearLayout container;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        container = (LinearLayout) findViewById(R.id.data);
        results = (TextView) findViewById(R.id.database);

        db = new MyDBManager(this);

        //// open Database and get rows

        db.open();

        getRows();

        db.close();
    }


    //---get all rows---
    public void getRows() {
        Cursor c = db.getAllTask();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

    public void ShowTask(Cursor c) {

        TextView text = new TextView(this);

        results.append("\n" + "id: " + c.getString(0) + "\n" +
                "Vote: " + c.getString(1) + "\n" +
                "Gender: " + c.getString(2) + "\n" +
                "Age: " + c.getString(3) + "\n" +
                "Marital: " + c.getString(4) + "\n" +
                "Children: " + c.getString(5) + "\n" +
                "Occupation: " + c.getString(6) + "\n" +
                "Income: " + c.getString(7) + "\n" +
                "Party: " + c.getString(8) + "\n" +
                "Comment: " + c.getString(9) + "\n" +
                "Candidate: " + c.getString(10) + "\n");

        container.addView(text);

    }

}