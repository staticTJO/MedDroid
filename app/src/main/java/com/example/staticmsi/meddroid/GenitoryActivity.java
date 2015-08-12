package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

/**
 * Created by Hammad Ali on 2015-08-06.
 */
public class GenitoryActivity extends Activity{
    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genital_assessment);

        p = (Patient) getIntent().getExtras().getSerializable("p");
        boolean paExist = getIntent().getExtras().getBoolean("paExist");

        if (paExist) {
            this.pa = (PatientAssessment) getIntent().getExtras().getSerializable("pa");
        }

        start();
        setBtnToPhysical();
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

        CheckBox catheterType = (CheckBox) findViewById(R.id.GenitourinaryCatheterType);
        EditText catheterTypeDescribe = (EditText) findViewById(R.id.GenitourinaryCatheterTypeText);
        EditText catheterSize = (EditText) findViewById(R.id.GenitourinaryCatheterSize);
        CheckBox catheterDischarge = (CheckBox) findViewById(R.id.GenitourinaryIsDischarge);
        EditText catheterUrineDescribe = (EditText) findViewById(R.id.GenitourinaryUrineDesc);
        CheckBox catheterIsMentruating = (CheckBox) findViewById(R.id.IsMentrating);

        catheterType.setChecked(pa.isGenitourinary_Catheter_Type());
        catheterTypeDescribe.setText(pa.getGenitourinary_Catheter_Type());
        catheterSize.setText(Float.toString(pa.getGenitourinary_Catheter_Size()));
        catheterDischarge.setChecked(pa.isGenitourinary_Catheter_Discharge());
        catheterUrineDescribe.setText(pa.getGenitourinary_Catheter_UrineDescribe());
        catheterIsMentruating.setChecked(pa.isGenitourinary_Catheter_Menstruating());

    }

    private void setEventListeners() {

        Button btnCancelGeni = (Button) findViewById(R.id.btnCancelGeni);
        Button bntSaveExitGeni = (Button) findViewById(R.id.bntSaveExitGeni);

        bntSaveExitGeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox catheterType = (CheckBox) findViewById(R.id.GenitourinaryCatheterType);
                EditText catheterTypeDescribe = (EditText) findViewById(R.id.GenitourinaryCatheterTypeText);
                EditText catheterSize = (EditText) findViewById(R.id.GenitourinaryCatheterSize);
                CheckBox catheterDischarge = (CheckBox) findViewById(R.id.GenitourinaryIsDischarge);
                EditText catheterUrineDescribe = (EditText) findViewById(R.id.GenitourinaryUrineDesc);
                CheckBox catheterIsMentruating = (CheckBox) findViewById(R.id.IsMentrating);

                pa.setIsGenitourinary_Catheter_Type(catheterType.isChecked());
                pa.setGenitourinary_Catheter_Type(catheterTypeDescribe.getText().toString());
                pa.setGenitourinary_Catheter_Size(Float.valueOf(catheterSize.getText().toString()));
                pa.setIsGenitourinary_Discharge(catheterDischarge.isChecked());
                pa.setGenitourinary_Catheter_UrineDescribe(catheterUrineDescribe.getText().toString());
                pa.setIsGenitourinary_Catheter_Type(catheterIsMentruating.isChecked());
                pa.update();
                finish();

            }
        });


        btnCancelGeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setBtnToPhysical() {

        Button b = (Button) findViewById(R.id.btnToPhysical);

        b.setOnClickListener(new BtnToPhysicalOnClick(this, this.pa.getId()));
    }

    class BtnToPhysicalOnClick implements View.OnClickListener {

        Long paId = null;
        GenitoryActivity ge;

        public BtnToPhysicalOnClick(GenitoryActivity ge, Long paId) {
            this.ge = ge;
            this.paId = paId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(GenitoryActivity.this, PhysicalActivity.class);

            if (paId != null) {
                intent.putExtra("paExist", true);
                intent.putExtra("paId", paId);
            } else {
                intent.putExtra("paExist", false);
            }

            CheckBox catheterType = (CheckBox) findViewById(R.id.GenitourinaryCatheterType);
            EditText catheterTypeDescribe = (EditText) findViewById(R.id.GenitourinaryCatheterTypeText);
            EditText catheterSize = (EditText) findViewById(R.id.GenitourinaryCatheterSize);
            CheckBox catheterDischarge = (CheckBox) findViewById(R.id.GenitourinaryIsDischarge);
            EditText catheterUrineDescribe = (EditText) findViewById(R.id.GenitourinaryUrineDesc);
            CheckBox catheterIsMentruating = (CheckBox) findViewById(R.id.IsMentrating);

            pa.setIsGenitourinary_Catheter_Type(catheterType.isChecked());
            pa.setGenitourinary_Catheter_Type(catheterTypeDescribe.getText().toString());
            pa.setGenitourinary_Catheter_Size(Float.valueOf(catheterSize.getText().toString()));
            pa.setIsGenitourinary_Discharge(catheterDischarge.isChecked());
            pa.setGenitourinary_Catheter_UrineDescribe(catheterUrineDescribe.getText().toString());
            pa.setIsGenitourinary_Catheter_Type(catheterIsMentruating.isChecked());


            pa.update();
            startActivity(intent);

        }

    }

}

