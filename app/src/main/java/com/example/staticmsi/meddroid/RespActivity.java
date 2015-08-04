package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

/**
 * Created by hamadalmarri on 2015-08-03.
 */
public class RespActivity extends Activity {


    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respiratoryres);

//        p = (Patient) getIntent().getExtras().getSerializable("p");
//        boolean paExist = getIntent().getExtras().getBoolean("paExist");
//
//        if (paExist) {
//            this.pa = (PatientAssessment) getIntent().getExtras().getSerializable("pa");
//        }
//
//        start();
//
//        setEventListeners();
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
        EditText etVisionEye = (EditText) findViewById(R.id.etVisionEye);
        EditText etPuplisL = (EditText) findViewById(R.id.etPuplisL);
        EditText etPuplisR = (EditText) findViewById(R.id.etPuplisR);
        EditText etGagRef = (EditText) findViewById(R.id.etGagRef);

//        EditText etMotor = (EditText) findViewById(R.id.etMotor);
        EditText etReactionL = (EditText) findViewById(R.id.etReactionL);
        EditText etReactionR = (EditText) findViewById(R.id.etReactionR);
        EditText etRestraints = (EditText) findViewById(R.id.etRestraints);

        EditText etPainLevel = (EditText) findViewById(R.id.etPainLevel);
        EditText etPainDesc = (EditText) findViewById(R.id.etPainDesc);

        EditText etMentalDesc = (EditText) findViewById(R.id.etMentalDesc);


        etVisionEye.setText(pa.getNeurological_Vision_Eye());
        etPuplisL.setText(pa.getNeurological_Vision_Pupils_L());
        etPuplisR.setText(pa.getNeurological_Vision_Pupils_R());

        etGagRef.setText(pa.getNeurological_Verbal_GAG_Reflex());

        etReactionL.setText(pa.getNeurological_Motor_Reaction_L());
        etReactionR.setText(pa.getNeurological_Motor_Reaction_R());
        etRestraints.setText(pa.getNeurological_Motor_Restraints());

        etPainLevel.setText(pa.getNeurological_Pain_Level());
        etPainDesc.setText(pa.getNeurological_Pain_Description());

        etMentalDesc.setText(pa.getNeurological_Mental_Description());

    }

    private void setEventListeners() {
        Button btnToResp = (Button) findViewById(R.id.btnToResp);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSaveExit = (Button) findViewById(R.id.btnSaveExit);

        btnSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etVisionEye = (EditText) findViewById(R.id.etVisionEye);
                EditText etPuplisL = (EditText) findViewById(R.id.etPuplisL);
                EditText etPuplisR = (EditText) findViewById(R.id.etPuplisR);
                EditText etGagRef = (EditText) findViewById(R.id.etGagRef);

                EditText etReactionL = (EditText) findViewById(R.id.etReactionL);
                EditText etReactionR = (EditText) findViewById(R.id.etReactionR);
                EditText etRestraints = (EditText) findViewById(R.id.etRestraints);

                EditText etPainLevel = (EditText) findViewById(R.id.etPainLevel);
                EditText etPainDesc = (EditText) findViewById(R.id.etPainDesc);

                EditText etMentalDesc = (EditText) findViewById(R.id.etMentalDesc);


                pa.setNeurological_Vision_Eye(etVisionEye.getText().toString());
                pa.setNeurological_Vision_Pupils_L(etPuplisL.getText().toString());
                pa.setNeurological_Vision_Pupils_R(etPuplisR.getText().toString());
                pa.setNeurological_Verbal_GAG_Reflex(etGagRef.getText().toString());

                pa.setNeurological_Motor_Reaction_L(etReactionL.getText().toString());
                pa.setNeurological_Motor_Reaction_R(etReactionR.getText().toString());
                pa.setNeurological_Motor_Restraints(etRestraints.getText().toString());

                pa.setNeurological_Pain_Level(etPainLevel.getText().toString());
                pa.setNeurological_Pain_Description(etPainDesc.getText().toString());

                pa.setNeurological_Mental_Description(etMentalDesc.getText().toString());

                pa.update();
                finish();
            }
        });


        btnToResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etVisionEye = (EditText) findViewById(R.id.etVisionEye);
                EditText etPuplisL = (EditText) findViewById(R.id.etPuplisL);
                EditText etPuplisR = (EditText) findViewById(R.id.etPuplisR);
                EditText etGagRef = (EditText) findViewById(R.id.etGagRef);

                EditText etReactionL = (EditText) findViewById(R.id.etReactionL);
                EditText etReactionR = (EditText) findViewById(R.id.etReactionR);
                EditText etRestraints = (EditText) findViewById(R.id.etRestraints);

                EditText etPainLevel = (EditText) findViewById(R.id.etPainLevel);
                EditText etPainDesc = (EditText) findViewById(R.id.etPainDesc);

                EditText etMentalDesc = (EditText) findViewById(R.id.etMentalDesc);


                pa.setNeurological_Vision_Eye(etVisionEye.getText().toString());
                pa.setNeurological_Vision_Pupils_L(etPuplisL.getText().toString());
                pa.setNeurological_Vision_Pupils_R(etPuplisR.getText().toString());
                pa.setNeurological_Verbal_GAG_Reflex(etGagRef.getText().toString());

                pa.setNeurological_Motor_Reaction_L(etReactionL.getText().toString());
                pa.setNeurological_Motor_Reaction_R(etReactionR.getText().toString());
                pa.setNeurological_Motor_Restraints(etRestraints.getText().toString());

                pa.setNeurological_Pain_Level(etPainLevel.getText().toString());
                pa.setNeurological_Pain_Description(etPainDesc.getText().toString());

                pa.setNeurological_Mental_Description(etMentalDesc.getText().toString());

                pa.update();

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
