package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.content.Intent;
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


        Long pID = getIntent().getExtras().getLong("pID");
        this.p = (Patient.findById(pID));
        Long paID = getIntent().getExtras().getLong("paID");
        boolean paExist = getIntent().getExtras().getBoolean("paExist");

        if (paExist) {
            this.pa = (PatientAssessment.findById(paID));
        }

        start();
        setButtonToCardio();
        setEventListeners();
    }


    class BtnToCardioOnClick implements View.OnClickListener {

        Long paId = null;
        RespActivity ra;

        public BtnToCardioOnClick (RespActivity ra, Long paId) {
            this.ra = ra;
            this.paId = paId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RespActivity.this,CardioActivity.class);

            if (paId != null) {
                intent.putExtra("paExist", true);
                intent.putExtra("paId", paId);
            } else {
                intent.putExtra("paExist", false);
            }

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


            // Unsure about check boxes should work tho.
            pa.setRespiratory_Airway_Maintains_Own(RespiratoryAirwayMaintainsOwn.isChecked());
            pa.setRespiratory_Airway_BIPAP_CPAP(BiPAPCPAP.isChecked());
            pa.setRespiratory_ETT(RespiratoryETT.isChecked());
            // Really.. java.. thank god for conversion functions
//            pa.setRespiratory_Size(Float.valueOf(RespiratorySize.getText().toString()));
//            pa.setRespiratory_LengthAtGums(Float.valueOf(RespiratoryLengthAtGums.getText().toString())); // error here converting string to float. Is breaking the activity.
//            pa.setRespiratory_LengthAtTeeth(Float.valueOf(RespiratoryLengthAtTeeth.getText().toString()));
//            pa.setRespiratory_CuffPressure(Float.valueOf(RespiratoryCuffPressure.getText().toString()));
//            pa.setRespiratory_TracheostomySize(Float.valueOf(RespiratoryTracheostomySize.getText().toString()));
            pa.setRespiratory_ChestExpansion(RespiratoryChestExpansion.getText().toString());
            pa.setRespiratory_Cough_SimulatedBySuctioning(RespiratoryCoughSimulatedBySuctioning.isChecked());
            pa.setRespiratory_Cough_Spontaneous(RespiratoryCoughSpontaneous.isChecked());
            pa.setRespiratory_Cough(RespiratoryCoughNotes.getText().toString());
            pa.setRespiratory_LipCondition_intact(RespiratoryLipConditionIntact.isChecked());
            pa.setRespiratory_LipCondition_other(RespiratoryLipConditionOther.isChecked());
            pa.setRespiratory_OralMucosa_intact(RespiratoryOralMucosaIntact.isChecked());
            pa.setRespiratory_OralMucosa_other(RespiratoryOralMucosaOther.isChecked());
            pa.setRespiratory_Clear(RespiratoryRespirationsClear.isChecked());
            pa.setRespiratory_Decreased(RespiratoryRespirationsDecreased.isChecked());
            pa.setRespiratory_Wheezes(RespiratoryRespirationsWheezes.isChecked());
            pa.setRespiratory_FineCreps(RespiratoryRespirationsFineCreps.isChecked());
            pa.setRespiratory_AbsentBreath(RespiratoryRespirationsAbsentBreath.isChecked());
            pa.setRespiratory_Bronchial(RespiratoryRespirationsBronchial.isChecked());
            pa.setRespiratory_Inspiratory(RespiratoryRespirationsInspiratory.isChecked());
            pa.setRespiratory_Expiratory(RespiratoryRespirationsExpiratory.isChecked());
            pa.setRespiratory_OtherDescription(RespiratoryRespirationsOther.getText().toString());
            pa.setRespiratory_Trechea(RespiratoryTrachealStomaDescribe.getText().toString());

            pa.update();
            startActivity(intent);
        }

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
        Button btnCancel = (Button) findViewById(R.id.btncancelres);
        Button btnSaveExit = (Button) findViewById(R.id.btnseres);

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


                // Unsure about check boxes should work tho.
                pa.setRespiratory_Airway_Maintains_Own(RespiratoryAirwayMaintainsOwn.isChecked());
                pa.setRespiratory_Airway_BIPAP_CPAP(BiPAPCPAP.isChecked());
                pa.setRespiratory_ETT(RespiratoryETT.isChecked());
                // Really.. java.. thank god for conversion functions
//                pa.setRespiratory_Size(Float.valueOf(RespiratorySize.getText().toString()));
//                pa.setRespiratory_LengthAtGums(Float.valueOf(RespiratoryLengthAtGums.getText().toString())); // error here converting string to float. Is breaking the activity.
//                pa.setRespiratory_LengthAtTeeth(Float.valueOf(RespiratoryLengthAtTeeth.getText().toString()));
//                pa.setRespiratory_CuffPressure(Float.valueOf(RespiratoryCuffPressure.getText().toString()));
//                pa.setRespiratory_TracheostomySize(Float.valueOf(RespiratoryTracheostomySize.getText().toString()));
                pa.setRespiratory_ChestExpansion(RespiratoryChestExpansion.getText().toString());
                pa.setRespiratory_Cough_SimulatedBySuctioning(RespiratoryCoughSimulatedBySuctioning.isChecked());
                pa.setRespiratory_Cough_Spontaneous(RespiratoryCoughSpontaneous.isChecked());
                pa.setRespiratory_Cough(RespiratoryCoughNotes.getText().toString());
                pa.setRespiratory_LipCondition_intact(RespiratoryLipConditionIntact.isChecked());
                pa.setRespiratory_LipCondition_other(RespiratoryLipConditionOther.isChecked());
                pa.setRespiratory_OralMucosa_intact(RespiratoryOralMucosaIntact.isChecked());
                pa.setRespiratory_OralMucosa_other(RespiratoryOralMucosaOther.isChecked());
                pa.setRespiratory_Clear(RespiratoryRespirationsClear.isChecked());
                pa.setRespiratory_Decreased(RespiratoryRespirationsDecreased.isChecked());
                pa.setRespiratory_Wheezes(RespiratoryRespirationsWheezes.isChecked());
                pa.setRespiratory_FineCreps(RespiratoryRespirationsFineCreps.isChecked());
                pa.setRespiratory_AbsentBreath(RespiratoryRespirationsAbsentBreath.isChecked());
                pa.setRespiratory_Bronchial(RespiratoryRespirationsBronchial.isChecked());
                pa.setRespiratory_Inspiratory(RespiratoryRespirationsInspiratory.isChecked());
                pa.setRespiratory_Expiratory(RespiratoryRespirationsExpiratory.isChecked());
                pa.setRespiratory_OtherDescription(RespiratoryRespirationsOther.getText().toString());
                pa.setRespiratory_Trechea(RespiratoryTrachealStomaDescribe.getText().toString());


                pa.update();
                finish();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    private void setButtonToCardio() {
        Button b = (Button) findViewById(R.id.btntocardio);

        b.setOnClickListener(new BtnToCardioOnClick(this, this.pa.getId()));
    }


}
