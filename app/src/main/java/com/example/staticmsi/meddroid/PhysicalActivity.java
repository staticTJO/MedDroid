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
public class PhysicalActivity extends Activity{


    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physical_assessment);


        Long pID = getIntent().getExtras().getLong("pID");
        this.p = (Patient.findById(pID));
        Long paID = getIntent().getExtras().getLong("paID");
        boolean paExist = getIntent().getExtras().getBoolean("paExist");

        if (paExist) {
            this.pa = (PatientAssessment.findById(paID));
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

        // skin
        EditText etPhysicalSkinConditionDescribe = (EditText) findViewById(R.id.etPhysicalSkinConditionDescribe);

        // sacrum
        CheckBox PhysicalSacremIntact = (CheckBox) findViewById(R.id.PhysicalSacremIntact);
        CheckBox PhysicalSacremMarked = (CheckBox) findViewById(R.id.PhysicalSacremMarked);
        CheckBox PhysicalSacremBroken = (CheckBox) findViewById(R.id.PhysicalSacremBroken);

        // heels
        CheckBox PhysicalHeelsIntactL = (CheckBox) findViewById(R.id.PhysicalHeelsIntactL);
        CheckBox PhysicalHeelsIntactR = (CheckBox) findViewById(R.id.PhysicalHeelsIntactR);
        CheckBox PhysicalHeelsMarkedL = (CheckBox) findViewById(R.id.PhysicalHeelsMarkedL);
        CheckBox PhysicalHeelsMarkedR = (CheckBox) findViewById(R.id.PhysicalHeelsMarkedR);
        CheckBox PhysicalHeelsBrokenL = (CheckBox) findViewById(R.id.PhysicalHeelsBrokenL);
        CheckBox PhysicalHeelsBrokenR = (CheckBox) findViewById(R.id.PhysicalHeelsBrokenR);

        // elbows
        CheckBox PhysicalElbowsIntactL = (CheckBox) findViewById(R.id.PhysicalElbowsIntactL);
        CheckBox PhysicalElbowsIntactR = (CheckBox) findViewById(R.id.PhysicalElbowsIntactR);
        CheckBox PhysicalElbowsMarkedL = (CheckBox) findViewById(R.id.PhysicalElbowsMarkedL);
        CheckBox PhysicalElbowsMarkedR = (CheckBox) findViewById(R.id.PhysicalElbowsMarkedR);
        CheckBox PhysicalElbowsBrokenL = (CheckBox) findViewById(R.id.PhysicalElbowsBrokenL);
        CheckBox PhysicalElbowsBrokenR = (CheckBox) findViewById(R.id.PhysicalElbowsBrokenR);

        // skin
        etPhysicalSkinConditionDescribe.setText(pa.getPhysical_SkinCondition());

        // sacrum
        PhysicalSacremIntact.setChecked(pa.isPhysical_Sacrum_Intact());
        PhysicalSacremMarked.setChecked(pa.isPhysical_Sacrum_Marked());
        PhysicalSacremBroken.setChecked(pa.isPhysical_Sacrum_broken());

        // heels
        PhysicalHeelsIntactL.setChecked(pa.isPhysical_Heels_Intact_L());
        PhysicalHeelsIntactR.setChecked(pa.isPhysical_Heels_Intact_R());
        PhysicalHeelsMarkedL.setChecked(pa.isPhysical_Heels_Marked_L());
        PhysicalHeelsMarkedR.setChecked(pa.isPhysical_Heels_Marked_R());
        PhysicalHeelsBrokenL.setChecked(pa.isPhysical_Heels_Broken_L());
        PhysicalHeelsBrokenR.setChecked(pa.isPhysical_Heels_Broken_R());

        // elbows
        PhysicalElbowsIntactL.setChecked(pa.isPhysical_Elbows_Elbows_L());
        PhysicalElbowsIntactR.setChecked(pa.isPhysical_Elbows_Elbows_R());
        PhysicalElbowsMarkedL.setChecked(pa.isPhysical_Elbows_Marked_L());
        PhysicalElbowsMarkedR.setChecked(pa.isPhysical_Elbows_Marked_R());
        PhysicalElbowsBrokenL.setChecked(pa.isPhysical_Elbows_Broken_L());
        PhysicalElbowsBrokenR.setChecked(pa.isPhysical_Elbows_Broken_R());
    }




    private void setEventListeners() {
        Button btnToResp = (Button) findViewById(R.id.btnToResp);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSaveExit = (Button) findViewById(R.id.btnSaveExit);



        btnSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             // skin
                EditText etPhysicalSkinConditionDescribe = (EditText) findViewById(R.id.etPhysicalSkinConditionDescribe);

             // sacrum
                CheckBox PhysicalSacremIntact =(CheckBox) findViewById(R.id.PhysicalSacremIntact);
                CheckBox PhysicalSacremMarked =(CheckBox) findViewById(R.id.PhysicalSacremMarked);
                CheckBox PhysicalSacremBroken =(CheckBox) findViewById(R.id.PhysicalSacremBroken);

             // heels
                CheckBox PhysicalHeelsIntactL =(CheckBox) findViewById(R.id.PhysicalHeelsIntactL);
                CheckBox PhysicalHeelsIntactR =(CheckBox) findViewById(R.id.PhysicalHeelsIntactR);
                CheckBox PhysicalHeelsMarkedL =(CheckBox) findViewById(R.id.PhysicalHeelsMarkedL);
                CheckBox PhysicalHeelsMarkedR =(CheckBox) findViewById(R.id.PhysicalHeelsMarkedR);
                CheckBox PhysicalHeelsBrokenL =(CheckBox) findViewById(R.id.PhysicalHeelsBrokenL);
                CheckBox PhysicalHeelsBrokenR =(CheckBox) findViewById(R.id.PhysicalHeelsBrokenR);

             // elbows
                CheckBox PhysicalElbowsIntactL =(CheckBox) findViewById(R.id.PhysicalElbowsIntactL);
                CheckBox PhysicalElbowsIntactR =(CheckBox) findViewById(R.id.PhysicalElbowsIntactR);
                CheckBox PhysicalElbowsMarkedL =(CheckBox) findViewById(R.id.PhysicalElbowsMarkedL);
                CheckBox PhysicalElbowsMarkedR =(CheckBox) findViewById(R.id.PhysicalElbowsMarkedR);
                CheckBox PhysicalElbowsBrokenL =(CheckBox) findViewById(R.id.PhysicalElbowsBrokenL);
                CheckBox PhysicalElbowsBrokenR =(CheckBox) findViewById(R.id.PhysicalElbowsBrokenR);

             // skin
                etPhysicalSkinConditionDescribe.setText(pa.getPhysical_SkinCondition());

             // sacrum
                PhysicalSacremIntact.setChecked(pa.isPhysical_Sacrum_Intact());
                PhysicalSacremMarked.setChecked(pa.isPhysical_Sacrum_Marked());
                PhysicalSacremBroken.setChecked(pa.isPhysical_Sacrum_broken());

             // heels
                PhysicalHeelsIntactL.setChecked(pa.isPhysical_Heels_Intact_L());
                PhysicalHeelsIntactR.setChecked(pa.isPhysical_Heels_Intact_R());
                PhysicalHeelsMarkedL.setChecked(pa.isPhysical_Heels_Marked_L());
                PhysicalHeelsMarkedR.setChecked(pa.isPhysical_Heels_Marked_R());
                PhysicalHeelsBrokenL.setChecked(pa.isPhysical_Heels_Broken_L());
                PhysicalHeelsBrokenR.setChecked(pa.isPhysical_Heels_Broken_R());

             // elbows
                PhysicalElbowsIntactL.setChecked(pa.isPhysical_Elbows_Elbows_L());
                PhysicalElbowsIntactR.setChecked(pa.isPhysical_Elbows_Elbows_R());
                PhysicalElbowsMarkedL.setChecked(pa.isPhysical_Elbows_Marked_L());
                PhysicalElbowsMarkedR.setChecked(pa.isPhysical_Elbows_Marked_R());
                PhysicalElbowsBrokenL.setChecked(pa.isPhysical_Elbows_Broken_L());
                PhysicalElbowsBrokenR.setChecked(pa.isPhysical_Elbows_Broken_R());

             // skin
                pa.setPhysical_SkinCondition(etPhysicalSkinConditionDescribe.getText().toString());

             // sacrum
                pa.setPhysical_Sacrum_Intact(PhysicalSacremIntact.isChecked());
                pa.setPhysical_Sacrum_Marked(PhysicalSacremMarked.isChecked());
                pa.setPhysical_Sacrum_broken(PhysicalSacremBroken.isChecked());

             // heels
                pa.setPhysical_Heels_Intact_L(PhysicalHeelsIntactL.isChecked());
                pa.setPhysical_Heels_Intact_R(PhysicalHeelsIntactR.isChecked());
                pa.setPhysical_Heels_Marked_L(PhysicalHeelsMarkedL.isChecked());
                pa.setPhysical_Heels_Marked_R(PhysicalHeelsMarkedR.isChecked());
                pa.setPhysical_Heels_Broken_L(PhysicalHeelsBrokenL.isChecked());
                pa.setPhysical_Heels_Broken_R(PhysicalHeelsBrokenR.isChecked());

             // elbows
                pa.setPhysical_Elbows_Elbows_L(PhysicalElbowsIntactL.isChecked());
                pa.setPhysical_Elbows_Elbows_R(PhysicalElbowsIntactR.isChecked());
                pa.setPhysical_Elbows_Marked_L(PhysicalElbowsMarkedL.isChecked());
                pa.setPhysical_Elbows_Marked_R(PhysicalElbowsMarkedR.isChecked());
                pa.setPhysical_Elbows_Broken_L(PhysicalElbowsBrokenL.isChecked());
                pa.setPhysical_Elbows_Broken_R(PhysicalElbowsBrokenR.isChecked());


                pa.update();
                finish();

            }
        });




        btnToResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             // skin
                EditText etPhysicalSkinConditionDescribe = (EditText) findViewById(R.id.etPhysicalSkinConditionDescribe);

             // sacrum
                CheckBox PhysicalSacremIntact =(CheckBox) findViewById(R.id.PhysicalSacremIntact);
                CheckBox PhysicalSacremMarked = (CheckBox) findViewById(R.id.PhysicalSacremMarked);
                CheckBox PhysicalSacremBroken = (CheckBox) findViewById(R.id.PhysicalSacremBroken);

             // heels
                CheckBox PhysicalHeelsIntactL =(CheckBox) findViewById(R.id.PhysicalHeelsIntactL);
                CheckBox PhysicalHeelsIntactR = (CheckBox) findViewById(R.id.PhysicalHeelsIntactR);
                CheckBox PhysicalHeelsMarkedL = (CheckBox) findViewById(R.id.PhysicalHeelsMarkedL);
                CheckBox PhysicalHeelsMarkedR =(CheckBox) findViewById(R.id.PhysicalHeelsMarkedR);
                CheckBox PhysicalHeelsBrokenL = (CheckBox) findViewById(R.id.PhysicalHeelsBrokenL);
                CheckBox PhysicalHeelsBrokenR = (CheckBox) findViewById(R.id.PhysicalHeelsBrokenR);

             // elbows
                CheckBox PhysicalElbowsIntactL =(CheckBox) findViewById(R.id.PhysicalElbowsIntactL);
                CheckBox PhysicalElbowsIntactR = (CheckBox) findViewById(R.id.PhysicalElbowsIntactR);
                CheckBox PhysicalElbowsMarkedL = (CheckBox) findViewById(R.id.PhysicalElbowsMarkedL);
                CheckBox PhysicalElbowsMarkedR =(CheckBox) findViewById(R.id.PhysicalElbowsMarkedR);
                CheckBox PhysicalElbowsBrokenL = (CheckBox) findViewById(R.id.PhysicalElbowsBrokenL);
                CheckBox PhysicalElbowsBrokenR = (CheckBox) findViewById(R.id.PhysicalElbowsBrokenR);

             // skin
                etPhysicalSkinConditionDescribe.setText(pa.getPhysical_SkinCondition());

             // sacrum
                PhysicalSacremIntact.setChecked(pa.isPhysical_Sacrum_Intact());
                PhysicalSacremMarked.setChecked(pa.isPhysical_Sacrum_Marked());
                PhysicalSacremBroken.setChecked(pa.isPhysical_Sacrum_broken());

             // heels
                PhysicalHeelsIntactL.setChecked(pa.isPhysical_Heels_Intact_L());
                PhysicalHeelsIntactR.setChecked(pa.isPhysical_Heels_Intact_R());
                PhysicalHeelsMarkedL.setChecked(pa.isPhysical_Heels_Marked_L());
                PhysicalHeelsMarkedR.setChecked(pa.isPhysical_Heels_Marked_R());
                PhysicalHeelsBrokenL.setChecked(pa.isPhysical_Heels_Broken_L());
                PhysicalHeelsBrokenR.setChecked(pa.isPhysical_Heels_Broken_R());

             // elbows
                PhysicalElbowsIntactL.setChecked(pa.isPhysical_Elbows_Elbows_L());
                PhysicalElbowsIntactR.setChecked(pa.isPhysical_Elbows_Elbows_R());
                PhysicalElbowsMarkedL.setChecked(pa.isPhysical_Elbows_Marked_L());
                PhysicalElbowsMarkedR.setChecked(pa.isPhysical_Elbows_Marked_R());
                PhysicalElbowsBrokenL.setChecked(pa.isPhysical_Elbows_Broken_L());
                PhysicalElbowsBrokenR.setChecked(pa.isPhysical_Elbows_Broken_R());

             // skin
                pa.setPhysical_SkinCondition(etPhysicalSkinConditionDescribe.getText().toString());

             // sacrum
                pa.setPhysical_Sacrum_Intact(PhysicalSacremIntact.isChecked());
                pa.setPhysical_Sacrum_Marked(PhysicalSacremMarked.isChecked());
                pa.setPhysical_Sacrum_broken(PhysicalSacremBroken.isChecked());

             // heels
                pa.setPhysical_Heels_Intact_L(PhysicalHeelsIntactL.isChecked());
                pa.setPhysical_Heels_Intact_R(PhysicalHeelsIntactR.isChecked());
                pa.setPhysical_Heels_Marked_L(PhysicalHeelsMarkedL.isChecked());
                pa.setPhysical_Heels_Marked_R(PhysicalHeelsMarkedR.isChecked());
                pa.setPhysical_Heels_Broken_L(PhysicalHeelsBrokenL.isChecked());
                pa.setPhysical_Heels_Broken_R(PhysicalHeelsBrokenR.isChecked());

             // elbows
                pa.setPhysical_Elbows_Elbows_L(PhysicalElbowsIntactL.isChecked());
                pa.setPhysical_Elbows_Elbows_R(PhysicalElbowsIntactR.isChecked());
                pa.setPhysical_Elbows_Marked_L(PhysicalElbowsMarkedL.isChecked());
                pa.setPhysical_Elbows_Marked_R(PhysicalElbowsMarkedR.isChecked());
                pa.setPhysical_Elbows_Broken_L(PhysicalElbowsBrokenL.isChecked());
                pa.setPhysical_Elbows_Broken_R(PhysicalElbowsBrokenR.isChecked());
//*************************************************



                pa.update();


                Intent intent = new Intent(PhysicalActivity.this, NeuroActivity.class);
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
