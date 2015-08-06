package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

import java.text.DecimalFormat;

/**
 * Created by hamadalmarri on 2015-08-03.
 */
public class RespActivity extends Activity {


    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respiratoryassessment);

        p = (Patient) getIntent().getExtras().getSerializable("p");
        boolean paExist = getIntent().getExtras().getBoolean("paExist");

        if (paExist) {
            this.pa = (PatientAssessment) getIntent().getExtras().getSerializable("pa");
        }

        start();
//
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

        CheckBox RespiratoryAirwayMaintainsOwn = (CheckBox) findViewById(R.id.RespiratoryAirwayMaintainsOwn);
        CheckBox BiPAPCPAP = (CheckBox) findViewById(R.id.RespiratoryAirwayBIPAPCPAP);
        CheckBox RespiratoryETT = (CheckBox) findViewById(R.id.RespiratoryETT);
        EditText RespiratorySize = (EditText) findViewById(R.id.RespiratorySize);
        EditText RespiratoryLengthAtTeeth = (EditText) findViewById(R.id.RespiratoryLengthAtTeeth);
        EditText RespiratoryLengthAtGums = (EditText) findViewById(R.id.RespiratoryLengthAtGums);
        EditText RespiratoryCuffPressure = (EditText) findViewById(R.id.RespiratoryCuffPressure);
        EditText RespiratoryTracheostomySize = (EditText) findViewById(R.id.RespiratoryTracheostomySize);
        EditText RespiratoryChestExpansion = (EditText) findViewById(R.id.RespiratoryChestExpansion);

        CheckBox RespiratoryCoughSimulatedBySuctioning =(CheckBox) findViewById(R.id.RespiratoryCoughSimulatedBySuctioning);
        CheckBox RespiratoryCoughSpontaneous = (CheckBox) findViewById(R.id.RespiratoryCoughSpontaneous);
        EditText RespiratoryCoughNotes = (EditText) findViewById(R.id.RespiratoryCoughNotes);

        CheckBox RespiratoryLipConditionIntact = (CheckBox) findViewById(R.id.RespiratoryLipConditionIntact);
        CheckBox RespiratoryLipConditionOther = (CheckBox) findViewById(R.id. RespiratoryLipConditionOther);
        CheckBox RespiratoryOralMucosaIntact = (CheckBox) findViewById(R.id. RespiratoryOralMucosaIntact);
        CheckBox RespiratoryOralMucosaOther = (CheckBox) findViewById(R.id.RespiratoryOralMucosaOther);

        CheckBox RespiratoryRespirationsClear  = (CheckBox) findViewById(R.id.RespiratoryRespirationsClear);
        CheckBox RespiratoryRespirationsDecreased  = (CheckBox) findViewById(R.id.RespiratoryRespirationsDecreased);
        CheckBox RespiratoryRespirationsWheezes = (CheckBox) findViewById(R.id.RespiratoryRespirationsWheezes);
        CheckBox RespiratoryRespirationsFineCreps = (CheckBox) findViewById(R.id.RespiratoryRespirationsFineCreps);
        CheckBox RespiratoryRespirationsAbsentBreath = (CheckBox) findViewById(R.id.RespiratoryRespirationsAbsentBreath);
        CheckBox RespiratoryRespirationsBronchial = (CheckBox) findViewById(R.id.RespiratoryRespirationsBronchial);
        CheckBox RespiratoryRespirationsInspiratory = (CheckBox) findViewById(R.id.RespiratoryRespirationsInspiratory);
        CheckBox RespiratoryRespirationsExpiratory = (CheckBox) findViewById(R.id.RespiratoryRespirationsExpiratory);
        EditText RespiratoryRespirationsOther = (EditText) findViewById(R.id.RespiratoryRespirationsOther);
        EditText RespiratoryTrachealStomaDescribe = (EditText) findViewById(R.id.RespiratoryTrachealStomaDescribe);

        RespiratoryAirwayMaintainsOwn.setChecked(pa.isRespiratory_Airway_Maintains_Own());
        BiPAPCPAP.setChecked(pa.isRespiratory_Airway_BIPAP_CPAP());
        RespiratoryETT.setChecked(pa.isRespiratory_ETT());
        RespiratorySize.setText(Float.toString(pa.getRespiratory_Size()));
        RespiratoryLengthAtGums.setText(Float.toString(pa.getRespiratory_LengthAtGums()));// apparently setText only takes parameters int n shit.
        RespiratoryLengthAtTeeth.setText(Float.toString(pa.getRespiratory_LengthAtTeeth()));
        RespiratoryCuffPressure.setText(Float.toString(pa.getRespiratory_CuffPressure()));
        RespiratoryCuffPressure.setText(Float.toString(pa.getRespiratory_CuffPressure()));
        RespiratoryTracheostomySize.setText(Float.toString(pa.getRespiratory_TracheostomySize()));
        RespiratoryChestExpansion.setText(pa.getRespiratory_ChestExpansion());
        RespiratoryCoughSimulatedBySuctioning.setChecked(pa.isRespiratory_Cough_SimulatedBySuctioning());
        RespiratoryCoughSpontaneous.setChecked(pa.isRespiratory_Cough_Spontaneous());
        RespiratoryCoughNotes.setText(pa.getRespiratory_Cough());

        RespiratoryLipConditionIntact.setChecked(pa.isRespiratory_LipCondition_intact());
        RespiratoryLipConditionOther.setChecked(pa.isRespiratory_LipCondition_other());
        RespiratoryOralMucosaIntact.setChecked(pa.isRespiratory_OralMucosa_intact());
        RespiratoryOralMucosaOther.setChecked(pa.isRespiratory_OralMucosa_other());

        RespiratoryRespirationsClear.setChecked(pa.isRespiratory_Clear());
        RespiratoryRespirationsDecreased.setChecked(pa.isRespiratory_Decreased());
        RespiratoryRespirationsWheezes.setChecked(pa.isRespiratory_Wheezes());
        RespiratoryRespirationsFineCreps.setChecked(pa.isRespiratory_FineCreps());
        RespiratoryRespirationsAbsentBreath.setChecked(pa.isRespiratory_AbsentBreath());
        RespiratoryRespirationsBronchial.setChecked(pa.isRespiratory_Bronchial());
        RespiratoryRespirationsInspiratory.setChecked(pa.isRespiratory_Inspiratory());
        RespiratoryRespirationsExpiratory.setChecked(pa.isRespiratory_Expiratory());

        RespiratoryRespirationsOther.setText(pa.getRespiratory_OtherDescription());
        RespiratoryTrachealStomaDescribe.setText(pa.getRespiratory_Trechea());




    }

    private void setEventListeners() {
        Button btnToResp = (Button) findViewById(R.id.btnToResp);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSaveExit = (Button) findViewById(R.id.btnSaveExit);

        btnSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox RespiratoryAirwayMaintainsOwn = (CheckBox) findViewById(R.id.RespiratoryAirwayMaintainsOwn);
                CheckBox BiPAPCPAP = (CheckBox) findViewById(R.id.RespiratoryAirwayBIPAPCPAP);
                CheckBox RespiratoryETT = (CheckBox) findViewById(R.id.RespiratoryETT);
                EditText RespiratorySize = (EditText) findViewById(R.id.RespiratorySize);
                EditText RespiratoryLengthAtTeeth = (EditText) findViewById(R.id.RespiratoryLengthAtTeeth);
                EditText RespiratoryLengthAtGums = (EditText) findViewById(R.id.RespiratoryLengthAtGums);
                EditText RespiratoryCuffPressure = (EditText) findViewById(R.id.RespiratoryCuffPressure);
                EditText RespiratoryTracheostomySize = (EditText) findViewById(R.id.RespiratoryTracheostomySize);
                EditText RespiratoryChestExpansion = (EditText) findViewById(R.id.RespiratoryChestExpansion);

                CheckBox RespiratoryCoughSimulatedBySuctioning =(CheckBox) findViewById(R.id.RespiratoryCoughSimulatedBySuctioning);
                CheckBox RespiratoryCoughSpontaneous = (CheckBox) findViewById(R.id.RespiratoryCoughSpontaneous);
                EditText RespiratoryCoughNotes = (EditText) findViewById(R.id.RespiratoryCoughNotes);

                CheckBox RespiratoryLipConditionIntact = (CheckBox) findViewById(R.id.RespiratoryLipConditionIntact);
                CheckBox RespiratoryLipConditionOther = (CheckBox) findViewById(R.id. RespiratoryLipConditionOther);
                CheckBox RespiratoryOralMucosaIntact = (CheckBox) findViewById(R.id. RespiratoryOralMucosaIntact);
                CheckBox RespiratoryOralMucosaOther = (CheckBox) findViewById(R.id.RespiratoryOralMucosaOther);

                CheckBox RespiratoryRespirationsClear  = (CheckBox) findViewById(R.id.RespiratoryRespirationsClear);
                CheckBox RespiratoryRespirationsDecreased  = (CheckBox) findViewById(R.id.RespiratoryRespirationsDecreased);
                CheckBox RespiratoryRespirationsWheezes = (CheckBox) findViewById(R.id.RespiratoryRespirationsWheezes);
                CheckBox RespiratoryRespirationsFineCreps = (CheckBox) findViewById(R.id.RespiratoryRespirationsFineCreps);
                CheckBox RespiratoryRespirationsAbsentBreath = (CheckBox) findViewById(R.id.RespiratoryRespirationsAbsentBreath);
                CheckBox RespiratoryRespirationsBronchial = (CheckBox) findViewById(R.id.RespiratoryRespirationsBronchial);
                CheckBox RespiratoryRespirationsInspiratory = (CheckBox) findViewById(R.id.RespiratoryRespirationsInspiratory);
                CheckBox RespiratoryRespirationsExpiratory = (CheckBox) findViewById(R.id.RespiratoryRespirationsExpiratory);

                EditText RespiratoryRespirationsOther = (EditText) findViewById(R.id.RespiratoryRespirationsOther);
                EditText RespiratoryTrachealStomaDescribe = (EditText) findViewById(R.id.RespiratoryTrachealStomaDescribe);

                RespiratoryAirwayMaintainsOwn.setChecked(pa.isRespiratory_Airway_Maintains_Own());
                BiPAPCPAP.setChecked(pa.isRespiratory_Airway_BIPAP_CPAP());
                RespiratoryETT.setChecked(pa.isRespiratory_ETT());
                RespiratorySize.setText(Float.toString(pa.getRespiratory_Size()));
                RespiratoryLengthAtGums.setText(Float.toString(pa.getRespiratory_LengthAtGums()));// apparently setText only takes parameters int n shit.
                RespiratoryLengthAtTeeth.setText(Float.toString(pa.getRespiratory_LengthAtTeeth()));
                RespiratoryCuffPressure.setText(Float.toString(pa.getRespiratory_CuffPressure()));
                RespiratoryTracheostomySize.setText(Float.toString(pa.getRespiratory_TracheostomySize()));
                RespiratoryChestExpansion.setText(pa.getRespiratory_ChestExpansion());
                RespiratoryCoughSimulatedBySuctioning.setChecked(pa.isRespiratory_Cough_SimulatedBySuctioning());
                RespiratoryCoughSpontaneous.setChecked(pa.isRespiratory_Cough_Spontaneous());
                RespiratoryCoughNotes.setText(pa.getRespiratory_Cough());

                RespiratoryLipConditionIntact.setChecked(pa.isRespiratory_LipCondition_intact());
                RespiratoryLipConditionOther.setChecked(pa.isRespiratory_LipCondition_other());
                RespiratoryOralMucosaIntact.setChecked(pa.isRespiratory_OralMucosa_intact());
                RespiratoryOralMucosaOther.setChecked(pa.isRespiratory_OralMucosa_other());

                RespiratoryRespirationsClear.setChecked(pa.isRespiratory_Clear());
                RespiratoryRespirationsDecreased.setChecked(pa.isRespiratory_Decreased());
                RespiratoryRespirationsWheezes.setChecked(pa.isRespiratory_Wheezes());
                RespiratoryRespirationsFineCreps.setChecked(pa.isRespiratory_FineCreps());
                RespiratoryRespirationsAbsentBreath.setChecked(pa.isRespiratory_AbsentBreath());
                RespiratoryRespirationsBronchial.setChecked(pa.isRespiratory_Bronchial());
                RespiratoryRespirationsInspiratory.setChecked(pa.isRespiratory_Inspiratory());
                RespiratoryRespirationsExpiratory.setChecked(pa.isRespiratory_Expiratory());

                RespiratoryRespirationsOther.setText(pa.getRespiratory_OtherDescription());
                RespiratoryTrachealStomaDescribe.setText(pa.getRespiratory_Trechea());

                // Unsure about check boxes should work tho.
                pa.setRespiratory_Airway_Maintains_Own(RespiratoryAirwayMaintainsOwn.isChecked());
                pa.setRespiratory_Airway_BIPAP_CPAP(BiPAPCPAP.isChecked());
                pa.setRespiratory_ETT(RespiratoryETT.isChecked());

                // Really.. java.. thank god for conversion functions
                pa.setRespiratory_Size(Float.valueOf(RespiratorySize.getText().toString()));
                pa.setRespiratory_LengthAtGums(Float.valueOf(RespiratoryLengthAtGums.getText().toString()));
                pa.setRespiratory_LengthAtTeeth(Float.valueOf(RespiratoryLengthAtTeeth.getText().toString()));
                pa.setRespiratory_CuffPressure(Float.valueOf(RespiratoryCuffPressure.getText().toString()));
                pa.setRespiratory_TracheostomySize(Float.valueOf(RespiratoryTracheostomySize.getText().toString()));
                pa.setRespiratory_ChestExpansion(RespiratoryChestExpansion.getText().toString());
                pa.setRespiratory_Cough_SimulatedBySuctioning(RespiratoryCoughSimulatedBySuctioning.isChecked());
                pa.setRespiratory_Cough_Spontaneous(RespiratoryCoughSpontaneous.isChecked());
                pa.setRespiratory_Cough(RespiratoryCoughNotes.getText().toString());


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
