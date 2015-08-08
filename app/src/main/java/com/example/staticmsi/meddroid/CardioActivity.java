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
public class CardioActivity extends Activity{
    Patient p = null;
    PatientAssessment pa = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_assessment);


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
        EditText cardioECGLead = (EditText) findViewById(R.id.CardioECGLead);
        EditText cardioECGRate = (EditText) findViewById(R.id.CardioECGRate);
        EditText cardioECGPR = (EditText) findViewById(R.id.CardioECGPR);
        EditText cardioECGQRS = (EditText) findViewById(R.id.CardioECGQRS);
        EditText cardioECGQT = (EditText) findViewById(R.id.CardioECGQT);
        EditText cardioECGSTSegment = (EditText) findViewById(R.id.CardioECGST);
        EditText cardioECGWave = (EditText) findViewById(R.id.CardioECGWave);
        EditText cardioECGInterpretation = (EditText) findViewById(R.id.CardioECGInterpretation);
        CheckBox cardioSkinPink = (CheckBox) findViewById(R.id.CardioSkinPink);
        CheckBox cardioSkinPale = (CheckBox) findViewById(R.id.CardioSkinPale);
        CheckBox cardioSkinJaundiced = (CheckBox) findViewById(R.id.CardioSkinJaundiced);
        CheckBox cardioSkinFlushed = (CheckBox) findViewById(R.id.CardioSkinFlushed);
        CheckBox cardioSkinMottled = (CheckBox) findViewById(R.id.CardioSkinMottled);
        CheckBox cardioSkinCyanotic = (CheckBox) findViewById(R.id.CardioSkinCyanotic);
        CheckBox cardioSkinDiaphoretic = (CheckBox) findViewById(R.id.CardioSkinDiaphoretic);
        CheckBox cardioSkinCold = (CheckBox) findViewById(R.id.CardioSkinCold);
        CheckBox cardioSkinCool = (CheckBox) findViewById(R.id.CardioSkinCool);
        CheckBox cardioSkinHot = (CheckBox) findViewById(R.id.CardioSkinHot);
        CheckBox cardioSkinWarm = (CheckBox) findViewById(R.id.CardioSkinWarm);
        CheckBox cardioSkinDry = (CheckBox) findViewById(R.id.CardioSkinDry);
        CheckBox cardioSkinMoist = (CheckBox) findViewById(R.id.CardioSkinMoist);
        CheckBox cardioOedemaGeneralized = (CheckBox) findViewById(R.id.CardioOedemaGeneralized);
        EditText cardioOedemaLocalizedTo = (EditText) findViewById(R.id.CardioOedemaLocalizedTo);


        cardioECGLead.setText(pa.getCardio_ECG_Lead());
        cardioECGRate.setText(Float.toString(pa.getCardio_ECG_Rate()));
        cardioECGPR.setText(Float.toString(pa.getCardio_ECG_PR()));
        cardioECGQRS.setText(pa.getCardio_ECG_QRS());
        cardioECGQT.setText(pa.getCardio_ECG_QT());
        cardioECGSTSegment.setText(pa.getCardio_ECG_STSegment());
        cardioECGWave.setText(pa.getCardio_ECG_Wave());
        cardioECGInterpretation.setText(pa.getCardio_ECG_Interpretation());
        cardioSkinPink.setChecked(pa.isCardio_Skin_Pink());
        cardioSkinPale.setChecked(pa.isCardio_Skin_Pale());
        cardioSkinJaundiced.setChecked(pa.isCardio_Skin_Jaundiced());
        cardioSkinFlushed.setChecked(pa.isCardio_Skin_Flushed());
        cardioSkinMottled.setChecked(pa.isCardio_Skin_Mottled());
        cardioSkinCyanotic.setChecked(pa.isCardio_Skin_Cyanotic());
        cardioSkinDiaphoretic.setChecked(pa.isCardio_Skin_Diaphoretic());
        cardioSkinCold.setChecked(pa.isCardio_Skin_Cold());
        cardioSkinCool.setChecked(pa.isCardio_Skin_Cool());
        cardioSkinHot.setChecked(pa.isCardio_Skin_Hot());
        cardioSkinWarm.setChecked(pa.isCardio_Skin_Warm());
        cardioSkinDry.setChecked(pa.isCardio_Skin_Dry());
        cardioSkinMoist.setChecked(pa.isCardio_Skin_Moist());
        cardioOedemaGeneralized.setChecked(pa.isCardio_Oedema_Generalised());
        cardioOedemaLocalizedTo.setText(pa.getCardio_Oedema_LocalisedTo());






    }
    private void setEventListeners() {
        Button btnToResp = (Button) findViewById(R.id.btnToResp);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSaveExit = (Button) findViewById(R.id.btnSaveExit);

        btnSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cardioECGLead = (EditText) findViewById(R.id.CardioECGLead);
                EditText cardioECGRate = (EditText) findViewById(R.id.CardioECGRate);
                EditText cardioECGPR = (EditText) findViewById(R.id.CardioECGPR);
                EditText cardioECGQRS = (EditText) findViewById(R.id.CardioECGQRS);
                EditText cardioECGQT = (EditText) findViewById(R.id.CardioECGQT);
                EditText cardioECGSTSegment = (EditText) findViewById(R.id.CardioECGST);
                EditText cardioECGWave = (EditText) findViewById(R.id.CardioECGWave);
                EditText cardioECGInterpretation = (EditText) findViewById(R.id.CardioECGInterpretation);
                CheckBox cardioSkinPink = (CheckBox) findViewById(R.id.CardioSkinPink);
                CheckBox cardioSkinPale = (CheckBox) findViewById(R.id.CardioSkinPale);
                CheckBox cardioSkinJaundiced = (CheckBox) findViewById(R.id.CardioSkinJaundiced);
                CheckBox cardioSkinFlushed = (CheckBox) findViewById(R.id.CardioSkinFlushed);
                CheckBox cardioSkinMottled = (CheckBox) findViewById(R.id.CardioSkinMottled);
                CheckBox cardioSkinCyanotic = (CheckBox) findViewById(R.id.CardioSkinCyanotic);
                CheckBox cardioSkinDiaphoretic = (CheckBox) findViewById(R.id.CardioSkinDiaphoretic);
                CheckBox cardioSkinCold = (CheckBox) findViewById(R.id.CardioSkinCold);
                CheckBox cardioSkinCool = (CheckBox) findViewById(R.id.CardioSkinCool);
                CheckBox cardioSkinHot = (CheckBox) findViewById(R.id.CardioSkinHot);
                CheckBox cardioSkinWarm = (CheckBox) findViewById(R.id.CardioSkinWarm);
                CheckBox cardioSkinDry = (CheckBox) findViewById(R.id.CardioSkinDry);
                CheckBox cardioSkinMoist = (CheckBox) findViewById(R.id.CardioSkinMoist);
                CheckBox cardioOedemaGeneralized = (CheckBox) findViewById(R.id.CardioOedemaGeneralized);
                EditText cardioOedemaLocalizedTo = (EditText) findViewById(R.id.CardioOedemaLocalizedTo);

                pa.setCardio_ECG_Lead(Integer.parseInt(cardioECGLead.getText().toString()));
                pa.setCardio_ECG_Rate(Float.valueOf(cardioECGRate.getText().toString()));
                pa.setCardio_ECG_PR(Float.valueOf(cardioECGPR.getText().toString()));
                pa.setCardio_ECG_QRS(Integer.parseInt(cardioECGQRS.getText().toString()));
                pa.setCardio_ECG_QT(Integer.parseInt(cardioECGQT.getText().toString()));
                pa.setCardio_ECG_STSegment(Integer.parseInt(cardioECGSTSegment.getText().toString()));
                pa.setCardio_ECG_Wave(Integer.parseInt(cardioECGWave.getText().toString()));
                pa.setCardio_ECG_Interpretation(cardioECGInterpretation.getText().toString());
                pa.setCardio_Skin_Pink(cardioSkinPink.isChecked());
                pa.setCardio_Skin_Pale(cardioSkinPale.isChecked());
                pa.setCardio_Skin_Jaundiced(cardioSkinJaundiced.isChecked());
                pa.setCardio_Skin_Flushed(cardioSkinFlushed.isChecked());
                pa.setCardio_Skin_Mottled(cardioSkinMottled.isChecked());
                pa.setCardio_Skin_Cyanotic(cardioSkinCyanotic.isChecked());
                pa.setCardio_Skin_Diaphoretic(cardioSkinDiaphoretic.isChecked());
                pa.setCardio_Skin_Cold(cardioSkinCold.isChecked());
                pa.setCardio_Skin_Cool(cardioSkinCool.isChecked());
                pa.setCardio_Skin_Hot(cardioSkinHot.isChecked());
                pa.setCardio_Skin_Warm(cardioSkinWarm.isChecked());
                pa.setCardio_Skin_Dry(cardioSkinDry.isChecked());
                pa.setCardio_Skin_Moist(cardioSkinMoist.isChecked());
                pa.setCardio_Oedema_Generalised(cardioOedemaGeneralized.isChecked());
                pa.setCardio_Oedema_LocalisedTo(cardioOedemaLocalizedTo.getText().toString());

                pa.update();
                finish();

            }
        });


        btnToResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText cardioECGLead = (EditText) findViewById(R.id.CardioECGLead);
                EditText cardioECGRate = (EditText) findViewById(R.id.CardioECGRate);
                EditText cardioECGPR = (EditText) findViewById(R.id.CardioECGPR);
                EditText cardioECGQRS = (EditText) findViewById(R.id.CardioECGQRS);
                EditText cardioECGQT = (EditText) findViewById(R.id.CardioECGQT);
                EditText cardioECGSTSegment = (EditText) findViewById(R.id.CardioECGST);
                EditText cardioECGWave = (EditText) findViewById(R.id.CardioECGWave);
                EditText cardioECGInterpretation = (EditText) findViewById(R.id.CardioECGInterpretation);
                CheckBox cardioSkinPink = (CheckBox) findViewById(R.id.CardioSkinPink);
                CheckBox cardioSkinPale = (CheckBox) findViewById(R.id.CardioSkinPale);
                CheckBox cardioSkinJaundiced = (CheckBox) findViewById(R.id.CardioSkinJaundiced);
                CheckBox cardioSkinFlushed = (CheckBox) findViewById(R.id.CardioSkinFlushed);
                CheckBox cardioSkinMottled = (CheckBox) findViewById(R.id.CardioSkinMottled);
                CheckBox cardioSkinCyanotic = (CheckBox) findViewById(R.id.CardioSkinCyanotic);
                CheckBox cardioSkinDiaphoretic = (CheckBox) findViewById(R.id.CardioSkinDiaphoretic);
                CheckBox cardioSkinCold = (CheckBox) findViewById(R.id.CardioSkinCold);
                CheckBox cardioSkinCool = (CheckBox) findViewById(R.id.CardioSkinCool);
                CheckBox cardioSkinHot = (CheckBox) findViewById(R.id.CardioSkinHot);
                CheckBox cardioSkinWarm = (CheckBox) findViewById(R.id.CardioSkinWarm);
                CheckBox cardioSkinDry = (CheckBox) findViewById(R.id.CardioSkinDry);
                CheckBox cardioSkinMoist = (CheckBox) findViewById(R.id.CardioSkinMoist);
                CheckBox cardioOedemaGeneralized = (CheckBox) findViewById(R.id.CardioOedemaGeneralized);
                EditText cardioOedemaLocalizedTo = (EditText) findViewById(R.id.CardioOedemaLocalizedTo);

                pa.setCardio_ECG_Lead(Integer.parseInt(cardioECGLead.getText().toString()));
                pa.setCardio_ECG_Rate(Float.valueOf(cardioECGRate.getText().toString()));
                pa.setCardio_ECG_PR(Float.valueOf(cardioECGPR.getText().toString()));
                pa.setCardio_ECG_QRS(Integer.parseInt(cardioECGQRS.getText().toString()));
                pa.setCardio_ECG_QT(Integer.parseInt(cardioECGQT.getText().toString()));
                pa.setCardio_ECG_STSegment(Integer.parseInt(cardioECGSTSegment.getText().toString()));
                pa.setCardio_ECG_Wave(Integer.parseInt(cardioECGWave.getText().toString()));
                pa.setCardio_ECG_Interpretation(cardioECGInterpretation.getText().toString());
                pa.setCardio_Skin_Pink(cardioSkinPink.isChecked());
                pa.setCardio_Skin_Pale(cardioSkinPale.isChecked());
                pa.setCardio_Skin_Jaundiced(cardioSkinJaundiced.isChecked());
                pa.setCardio_Skin_Flushed(cardioSkinFlushed.isChecked());
                pa.setCardio_Skin_Mottled(cardioSkinMottled.isChecked());
                pa.setCardio_Skin_Cyanotic(cardioSkinCyanotic.isChecked());
                pa.setCardio_Skin_Diaphoretic(cardioSkinDiaphoretic.isChecked());
                pa.setCardio_Skin_Cold(cardioSkinCold.isChecked());
                pa.setCardio_Skin_Cool(cardioSkinCool.isChecked());
                pa.setCardio_Skin_Hot(cardioSkinHot.isChecked());
                pa.setCardio_Skin_Warm(cardioSkinWarm.isChecked());
                pa.setCardio_Skin_Dry(cardioSkinDry.isChecked());
                pa.setCardio_Skin_Moist(cardioSkinMoist.isChecked());
                pa.setCardio_Oedema_Generalised(cardioOedemaGeneralized.isChecked());
                pa.setCardio_Oedema_LocalisedTo(cardioOedemaLocalizedTo.getText().toString());
                pa.update();

                Intent intent = new Intent(CardioActivity.this, GastroActivity.class);
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
