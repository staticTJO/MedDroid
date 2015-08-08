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
        setContentView(R.layout.gastro_assessment);

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
        Button btnToGeni = (Button) findViewById(R.id.btnToGeni);
        Button btnCancelGastro = (Button) findViewById(R.id.btnCancelGastro);
        Button btnSaveExitGastro = (Button) findViewById(R.id.btnSaveExitGastro);

        btnSaveExitGastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnToGeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(GastroActivity.this, GenitoryActivity.class);
                startActivity(intent);
            }
        });

        btnCancelGastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

