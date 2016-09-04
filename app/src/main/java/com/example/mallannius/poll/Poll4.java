package com.example.mallannius.poll;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Poll4 extends AppCompatActivity {

    ListView list;
    String itemvalue;
    Button submit;
    TextView text;


    String[] Candidates = {"Catherine Connolly", "Derek Nolan", "Hildegarde Naughton",
            "James Charity", "John Connolly", "Niall Ó Tuathail", "Mary Hoade", "Fidelma Healy Eames"};

    String[] Election_Party = {"Independent", "Labour", "Fine Gael", "independent", "Fianna Fáil", "Social Democrat", "Fianna Fáil", "Fine Gael"};

   /* the string is where to store data when we select something */
    String db_vote;
    String db_gender;
    String db_age;
    String db_marital;
    String db_children;
    String db_occupation;
    String db_income;
    String db_party;
    String db_comment;
    String db_candidates;

    MyDBManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll4);
        db = new MyDBManager(this);


        list = (ListView) findViewById(R.id.cand);
        submit = (Button) findViewById(R.id.submit);
        text= (TextView) findViewById(R.id.Q7);



        list.setAdapter(new MyCustomAdapter(Poll4.this, R.layout.row, Candidates, Election_Party));


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemvalue = list.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), itemvalue,
                        Toast.LENGTH_LONG).show();
                        db_candidates=itemvalue;
            }
        });

        Bundle bundle = getIntent().getExtras();
        db_vote = (bundle.getString("Vote"));
        db_gender = (bundle.getString("Gender"));
        db_age = (bundle.getString("Age"));
        db_marital = (bundle.getString("Marital"));
        db_children =(bundle.getString("Children"));
        db_occupation = (bundle.getString("Occupation"));
        db_income = (bundle.getString("Income"));
        db_party = (bundle.getString("Party"));
        db_comment = (bundle.getString("Comment"));
        db_candidates = (bundle.getString("Candidates"));

        // Click and submit poll
        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){


                db.open();

                db.insertPoll(db_vote, db_gender, db_age, db_marital, db_children, db_occupation, db_income, db_party, db_comment, db_candidates, itemvalue);
                db.close();

                /* put finish() to go back to the main screen*/
                finish();

            }
        });
    }

    public class MyCustomAdapter extends ArrayAdapter<String> {

        String[] values;
        String[] names;

        // Creating our own adaptor to be able to customise each row
        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects, String[] results)
        {
            super(context, textViewResourceId, objects);
            names=objects;
            values=results;
        }



        // This getview method is called each time a row needs to be formatted for the list
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View row =convertView;
            if(row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
            }

            TextView label=(TextView)row.findViewById(R.id.cand2);
            label.setText(names[position]);
            ImageView icon=(ImageView)row.findViewById(R.id.icon1);
            TextView icon2=(TextView)row.findViewById(R.id.cand3);



            if (Candidates[position]=="Catherine Connolly"){
                icon.setImageResource(R.drawable.catherine);
                icon2.setText(values[position]);
            }

            else if (Candidates[position]== "Derek Nolan")
            {
                icon.setImageResource(R.drawable.nolan);
                icon2.setText(values[position]);
            }else if (Candidates[position]== "Hildegarde Naughton")
            {
                icon.setImageResource(R.drawable.naughton);
                icon2.setText(values[position]);
            }
            else if (Candidates[position]==  "James Charity")
            {
                icon.setImageResource(R.drawable.charity);
                icon2.setText(values[position]);
            }
            else if (Candidates[position]== "John Connolly")
            {
                icon.setImageResource(R.drawable.johnc);
                icon2.setText(values[position]);
            }
            else if (Candidates[position]==  "Niall Ó Tuathail")
            {
                icon.setImageResource(R.drawable.nial);
                icon2.setText(values[position]);
            }
            else if (Candidates[position]==   "Mary Hoade")
            {
                icon.setImageResource(R.drawable.hoade);
                icon2.setText(values[position]);
            }
            else if (Candidates[position]==  "Fidelma Healy Eames")
            {
                icon.setImageResource(R.drawable.fidelma);
                icon2.setText(values[position]);
            }


            return row;
        }




    }
}
