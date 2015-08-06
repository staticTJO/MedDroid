package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

/**
 * Created by Hammad Ali on 2015-08-06.
 */
public class GastroActivity extends Activity{
    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gastro_assesment);

        p = (Patient) getIntent().getExtras().getSerializable("p");
        boolean paExist = getIntent().getExtras().getBoolean("paExist");

        if (paExist) {
            this.pa = (PatientAssessment) getIntent().getExtras().getSerializable("pa");
        }

        start();

        setEventListeners();
    }
    private void start() {
        if (pa == null) {
            pa = new PatientAssessment();
            pa.setPatientFile(p);
            return;
        } else {
            fillFields();
        }
    }
    private void fillFields() {

    }
    private void setEventListeners() {
        Button btnToResp = (Button) findViewById(R.id.btnToResp);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSaveExit = (Button) findViewById(R.id.btnSaveExit);

        btnSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnToResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(GastroActivity.this, NeuroActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

