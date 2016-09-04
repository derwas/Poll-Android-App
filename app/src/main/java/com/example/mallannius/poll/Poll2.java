package com.example.mallannius.poll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Poll2 extends AppCompatActivity {
    RadioGroup marital;
    Spinner children;
    Spinner occupation;
    Button buttonext2;


    /* the string is where to store data when we select something */
    String db_marital;
    String db_children;
    String db_occupation;

    // ----
    String db_vote;
    String db_gender;
    String db_age;
    //----

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll2);


        marital = (RadioGroup) findViewById(R.id.marital_status);
        db_marital = "Other";
        children = (Spinner) findViewById(R.id.children);
        db_children = "0";
        occupation = (Spinner) findViewById(R.id.occupation);
        db_occupation = "Accountant";
        buttonext2 = (Button) findViewById(R.id.next2);

        Bundle bundle = getIntent().getExtras();
        db_vote = (bundle.getString("Vote"));
        db_gender = (bundle.getString("Gender"));
        db_age = (bundle.getString("Age"));



        marital.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.radio3:
                        db_marital = "Other";
                        break;
                    case R.id.radio4:
                        db_marital = "Single";
                        break;
                    case R.id.radio5:
                        db_marital = "Married";
                        break;
                }
            }
        });

        // Create a list of strings for the Spinner
        List<String> list1 = new ArrayList<String>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5+");

        ArrayAdapter<String> dataadapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);

        dataadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        children.setAdapter(dataadapter1);

        children.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                db_children = children.getSelectedItem().toString();

                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        // Create a list of strings for the Spinner
        List<String> list2 = new ArrayList<String>();
        list2.add("Accountant");
        list2.add("Doctor");
        list2.add("Self-employed");
        list2.add("Student");
        list2.add("Teacher");
        list2.add("Other");

        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);

        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        occupation.setAdapter(dataadapter2);

        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                db_occupation = occupation.getSelectedItem().toString();

                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> paren) {

            }

        });

        // Click and move to the next activity
        buttonext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poll2.this, Poll3.class);

                intent.putExtra("Vote", db_vote);
                intent.putExtra("Gender", db_gender);
                intent.putExtra("Age", db_age);
                intent.putExtra("Marital", db_marital);
                intent.putExtra("Children", db_children);
                intent.putExtra("Occupation", db_occupation);

                //put finish()to go back to the main screen
                finish();

                startActivity(intent);


            }
        });

    }
}