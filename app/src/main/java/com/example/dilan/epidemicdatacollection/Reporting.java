package com.example.dilan.epidemicdatacollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Reporting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting);


        final EditText reportTitle = findViewById(R.id.reportTitle);
        final EditText reportDescription = findViewById(R.id.reportDescription);

        Button reportSubmit = findViewById(R.id.sendReport);

        reportSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = reportTitle.getText().toString();
                String description = reportDescription.getText().toString();




            }
        });




    }
}