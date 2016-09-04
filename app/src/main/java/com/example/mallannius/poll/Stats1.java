package com.example.mallannius.poll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class Stats1 extends AppCompatActivity {

    Spinner spinner1, spinner2, spinner3;
    Button submit;

    String db_age;
    String db_gender;
    String db_occupation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats1);

        spinner1 = (Spinner) findViewById(R.id.agebracket);
        spinner2 = (Spinner) findViewById(R.id.gender2);
        spinner3 = (Spinner) findViewById(R.id.occupation);
        submit = (Button) findViewById(R.id.submitstats);



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

        spinner1.setAdapter(dataadapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_age = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        // Create a list of strings for the Spinner
        List<String> list2 = new ArrayList<String>();
        list2.add("Male");
        list2.add("Female");

        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);

        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinner2.setAdapter(dataadapter2);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_gender = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        // Create a list of strings for the Spinner
        List<String> list3 = new ArrayList<String>();
        list3.add("Accountant");
        list3.add("Doctor");
        list3.add("Self-employed");
        list3.add("Student");
        list3.add("Teacher");
        list3.add("Other");

        ArrayAdapter<String> dataadapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list3);

        dataadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinner3.setAdapter(dataadapter3);


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(),parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_occupation=parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stats1.this, Statsresultjob.class);
                intent.putExtra("Age",db_age);
                intent.putExtra("Gender",db_gender);
                intent.putExtra("Occupation",db_occupation);
                startActivity(intent);
            }
        });




    }


}
