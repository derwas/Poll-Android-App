package com.example.mallannius.poll;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Poll extends AppCompatActivity{

    RadioGroup vote;
    RadioGroup gender;
    Spinner age;
    Button buttonext;

    /* the string is where to store data when we select something */
    String db_vote;
    String db_gender;
    String db_age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll);


        vote = (RadioGroup)findViewById(R.id.vote);
        db_vote = "Yes";
        gender = (RadioGroup)findViewById(R.id.gender);
        db_gender = "Male";
        age = (Spinner)findViewById(R.id.agegroup);
        db_age = "18-25";
        buttonext = (Button) findViewById(R.id.next);


        vote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.radio6:
                        db_vote = "Yes";
                        break;
                    case R.id.radio7:
                        db_vote = "No";
                        break;
                }
            }
        });
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.radio1:
                        db_gender = "Male";
                        break;
                    case R.id.radio2:
                        db_gender = "Female";
                        break;
                }
            }
        });


        // Create a list of strings for the Spinner
        List<String> list = new ArrayList<String>();
        list.add("18-25");
        list.add("26-35");
        list.add("36-45");
        list.add("46-60");
        list.add("60+");

        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        age.setAdapter(dataadapter);

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                db_age = age.getSelectedItem().toString();
                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        // Click and move to the next activity
        buttonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poll.this, Poll2.class);
                intent.putExtra("Vote", db_vote);
                intent.putExtra("Gender", db_gender);
                intent.putExtra("Age", db_age);

                //put finish()to go back to the main screen
                finish();
                startActivity(intent);
            }
        });



    }

}



