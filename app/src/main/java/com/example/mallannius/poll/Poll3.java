package com.example.mallannius.poll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class Poll3 extends AppCompatActivity {

    Spinner income;
    Spinner party;
    EditText comment;

    Button buttonext4;

    /* the string is where to store data when we select something */
    String db_income;
    String db_party;
    String db_comment;
    //---

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
        setContentView(R.layout.poll3);

        buttonext4 = (Button) findViewById(R.id.button);
        income = (Spinner) findViewById(R.id.incomerange);
        db_income = "0-30k";
        party = (Spinner) findViewById(R.id.party);
        db_gender = "Fine Gael";
        comment = (EditText) findViewById(R.id.comment);


        Bundle bundle = getIntent().getExtras();
        db_vote = (bundle.getString("Vote"));
        db_gender = (bundle.getString("Gender"));
        db_age = (bundle.getString("Age"));
        db_marital = (bundle.getString("Marital"));
        db_children = (bundle.getString("Children"));
        db_occupation = (bundle.getString("Occupation"));


        // Create a list of strings for the Spinner
        List<String> list = new ArrayList<String>();
        list.add("0-30k");
        list.add("30k-40k");
        list.add("40k-50k");
        list.add("50k-60k");
        list.add(">60k");


        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        income.setAdapter(dataadapter);

        income.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isSpinnerInitial=true;

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                db_income = income.getSelectedItem().toString();

                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();


            }

            public void onNothingSelected(AdapterView<?> paren) {

            }

        });


        // Create a list of strings for the Spinner
        List<String> list1 = new ArrayList<String>();
        list1.add("Fine Gael");
        list1.add("Sinn Féin");
        list1.add("Fianna Fáil");
        list1.add("Labour");
        list1.add("Independent");


        ArrayAdapter<String> dataadapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);

        dataadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        party.setAdapter(dataadapter1);

        party.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                db_party = party.getSelectedItem().toString();

                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();


            }

            public void onNothingSelected(AdapterView<?> paren) {

            }

        });

        // Click and move to the next activity
        buttonext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poll3.this, Poll4.class);

                intent.putExtra("Vote", db_vote);
                intent.putExtra("Gender", db_gender);
                intent.putExtra("Age", db_age);
                intent.putExtra("Marital", db_marital);
                intent.putExtra("Children", db_children);
                intent.putExtra("Occupation", db_occupation);
                intent.putExtra("Income", db_income);
                intent.putExtra("Party", db_party);
                intent.putExtra("Comment", comment.getText().toString());

                //put finish()to go back to the main screen
                finish();

                startActivity(intent);


            }
        });
    }
}