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
public class GastroActivity extends Activity {
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
        setBtnToGen();
        setEventListeners();
    }

    class BtnToGenOnClick implements View.OnClickListener {

        Long paId = null;
        GastroActivity ga;

        public BtnToGenOnClick(GastroActivity ga, Long paId) {
            this.ga = ga;
            this.paId = paId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(GastroActivity.this, GenitoryActivity.class);

            if (paId != null) {
                intent.putExtra("paExist", true);
                intent.putExtra("paId", paId);
            } else {
                intent.putExtra("paExist", false);
            }

            CheckBox gastroAbDrainType = (CheckBox) findViewById(R.id.gastroabdrainType);
            EditText gastroAbDrainDesc = (EditText) findViewById(R.id.gastroabdraindesc);
            EditText gastroabdrainTypeDesc = (EditText) findViewById(R.id.gastroabdrainTypeDesc);

            CheckBox gastroabsSoft = (CheckBox) findViewById(R.id.gastroabsSoft);
            CheckBox gastroabsFirm = (CheckBox) findViewById(R.id.gastroabsFirm);
            CheckBox gastroabsFlat = (CheckBox) findViewById(R.id.gastroabsFlat);
            CheckBox gastroabsRounded = (CheckBox) findViewById(R.id.gastroabsRounded);
            CheckBox gastroabsObese = (CheckBox) findViewById(R.id.gastroabsObese);
            CheckBox gastroabsDistended = (CheckBox) findViewById(R.id.gastroabsDistended);

            CheckBox gastrobowelAbsent= (CheckBox) findViewById(R.id.gastrobowelAbsent);
            CheckBox gastrobowelPresent = (CheckBox) findViewById(R.id.gastrobowelPresent);
            CheckBox gastrobowelNormal = (CheckBox) findViewById(R.id.gastrobowelNormal);
            CheckBox gastrobowelIncreased = (CheckBox) findViewById(R.id.gastrobowelIncreased);
            CheckBox gastrobowelDecreased = (CheckBox) findViewById(R.id.gastrobowelDecreased);

            CheckBox gastroDietNBM = (CheckBox) findViewById(R.id.gastroDietNBM);
            CheckBox gastroDietCF = (CheckBox) findViewById(R.id.gastroDietCF);
            CheckBox gastroDietFF= (CheckBox) findViewById(R.id.gastroDietFF);
            CheckBox gastroDietD = (CheckBox) findViewById(R.id.gastroDietD);
            CheckBox gastroDietDiabetic = (CheckBox) findViewById(R.id.gastroDietDiabetic);
            CheckBox gastroDietCardiac = (CheckBox) findViewById(R.id.gastroDietCardiac);
            CheckBox gastroDietTubeFeeds = (CheckBox) findViewById(R.id.gastroDietTubeFeeds);
            CheckBox gastrodietSpecialC = (CheckBox) findViewById(R.id.gastrodietSpecialC);
            EditText gastroSpecialDesc = (EditText) findViewById(R.id.gastroSpecialDesc);
            CheckBox gastrodietother = (CheckBox) findViewById(R.id.gastrodietother);

            EditText gastroFTType = (EditText) findViewById(R.id.gastroFTType);
            EditText gastroFTInstitu = (EditText) findViewById(R.id.gastroFTInstitu);

            CheckBox gastroFTGastric = (CheckBox) findViewById(R.id.gastroFTGastric);
            CheckBox gastroFTDuodenal = (CheckBox) findViewById(R.id.gastroFTDuodenal);
            CheckBox gastroFTJejunal= (CheckBox) findViewById(R.id.gastroFTJejunal);
            CheckBox gastroFTintact = (CheckBox) findViewById(R.id.gastroFTintact);
            CheckBox gastroFTOther = (CheckBox) findViewById(R.id.gastroFTOther);
            CheckBox gastroFTVerified = (CheckBox) findViewById(R.id.gastroFTVerified);
            EditText gastroFTVerifiedDesc = (EditText) findViewById(R.id.gastroFTVerifiedDesc);

            CheckBox gastroFTAdminFeeds = (CheckBox) findViewById(R.id.gastroFTAdminFeeds);
            CheckBox gastroFTClamped = (CheckBox) findViewById(R.id.gastroFTClamped);
            CheckBox gastroFTAspirated= (CheckBox) findViewById(R.id.gastroFTAspirated);
            CheckBox gastroFTStraightDrainage = (CheckBox) findViewById(R.id.gastroFTStraightDrainage);

            EditText gastroFTDescAspirate = (EditText) findViewById(R.id.gastroFTDescAspirate);
            EditText gastroFTOtherDesc = (EditText) findViewById(R.id.gastroFTOtherDesc);

            // Not in DB //CheckBox gastrostomyType = (CheckBox) findViewById(R.id.gastrostomyType);
            EditText gastrostomyTypeDesc = (EditText) findViewById(R.id.gastrostomyTypeDesc);
            EditText gastrostomyStomaDesc = (EditText) findViewById(R.id.gastrostomyStomaDesc);

            EditText gastrostoolLastBM = (EditText) findViewById(R.id.gastrostoolLastBM);
            EditText gastrostoolLastBMPt2 = (EditText) findViewById(R.id.gastrostoolLastBMPt2);
            CheckBox gastrostoolpriortoAdmission = (CheckBox) findViewById(R.id.gastrostoolpriortoAdmission);
            EditText gastrostoolColor = (EditText) findViewById(R.id.gastrostoolColor);
            EditText gastrostoolchar = (EditText) findViewById(R.id.gastrostoolchar);

            pa.setGastro_AbdominalDrain_Type(gastroabdrainTypeDesc.getText().toString());
            pa.setGastro_DrainageDescribe(gastroAbDrainDesc.getText().toString());
            pa.setIsgastro_AbdominalDrain_Type(gastroAbDrainType.isChecked());
            pa.setGastro_Adomen_Soft(gastroabsSoft.isChecked());
            pa.setGastro_Adomen_Soft(gastroabsFirm.isChecked());
            pa.setGastro_Adomen_Flat(gastroabsFlat.isChecked());
            pa.setGastro_Adomen_Rounded(gastroabsRounded.isChecked());
            pa.setGastro_Adomen_Obese(gastroabsObese.isChecked());
            pa.setGastro_Adomen_Distended(gastroabsDistended.isChecked());
            pa.setGastro_BowlSounds_Abs(gastrobowelAbsent.isChecked());
            pa.setGastro_BowlSounds_Pres(gastrobowelPresent.isChecked());
            pa.setGastro_BowlSounds_Normal(gastrobowelNormal.isChecked());
            pa.setGastro_BowlSounds_Increased(gastrobowelIncreased.isChecked());
            pa.setGastro_BowlSounds_Decreased(gastrobowelDecreased.isChecked());
            pa.setGastro_Diet_NBM(gastroDietNBM.isChecked());
            pa.setGastro_Diet_CF(gastroDietCF.isChecked());
            pa.setGastro_Diet_FF(gastroDietFF.isChecked());
            pa.setGastro_Diet(gastroDietD.isChecked());
            pa.setGastro_Diet_Diabetic(gastroDietDiabetic.isChecked());
            pa.setGastro_Diet_Cardiac(gastroDietCardiac.isChecked());
            pa.setGastro_Diet_Tube_Feeds(gastroDietTubeFeeds.isChecked());
            pa.setGastro_Diet_Special_Con(gastrodietSpecialC.isChecked());
            pa.setGastro_Diet_Speical_String(gastroSpecialDesc.getText().toString());
            pa.setGastro_Diet_Other(gastrodietother.isChecked());
            pa.setGastro_FeedingTube_Type(gastroFTType.getText().toString());
            pa.setGastro_FeedingTube_insituTo(gastroFTInstitu.getText().toString());
            pa.setGastro_FeedingTube_Gastric(gastroFTGastric.isChecked());
            pa.setGastro_FeedingTube_Duodenel(gastroFTDuodenal.isChecked());
            pa.setGastro_FeedingTube_Jeunal(gastroFTJejunal.isChecked());
            pa.setGastro_FeedingTube_Intact(gastroFTintact.isChecked());
            pa.setGastro_FeedingTube_Other(gastroFTOther.isChecked());
            pa.setIsgastro_FeedingTube_Verified(gastroFTVerified.isChecked());
            pa.setGastro_PlacementVerifiedBy(gastroFTVerifiedDesc.getText().toString());
            pa.setGastro_AdministeringFeeds(gastroFTAdminFeeds.isChecked());
            pa.setGastro_Clamped(gastroFTClamped.isChecked());
            pa.setGastro_Aspirated(gastroFTAspirated.isChecked());
            pa.setGastro_StraightDrainage(gastroFTStraightDrainage.isChecked());
            pa.setGastro_DescriptionOfAspirate(gastroFTDescAspirate.getText().toString());
            pa.setGastro_OtherDescription(gastroFTOtherDesc.getText().toString());
            pa.setGastro_Ostomy_Type(gastrostomyTypeDesc.getText().toString());
            pa.setGastro_AppearanceOfStoma(gastrostomyStomaDesc.getText().toString());
            pa.setGastro_LeastBM1(Integer.valueOf(gastrostoolLastBM.getText().toString()));
            pa.setGastro_LeastBM2(Integer.valueOf(gastrostoolLastBMPt2.getText().toString()));
            pa.setGastro_PriorToAdmission(gastrostoolpriortoAdmission.isChecked());
            pa.setGastro_StoolColour(gastrostoolColor.getText().toString());
            pa.setGastro_Stoolcharacteristic(gastrostoolchar.getText().toString());
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
        CheckBox gastroAbDrainType = (CheckBox) findViewById(R.id.gastroabdrainType);
        EditText gastroAbDrainDesc = (EditText) findViewById(R.id.gastroabdraindesc);
        EditText gastroabdrainTypeDesc = (EditText) findViewById(R.id.gastroabdrainTypeDesc);

        CheckBox gastroabsSoft = (CheckBox) findViewById(R.id.gastroabsSoft);
        CheckBox gastroabsFirm = (CheckBox) findViewById(R.id.gastroabsFirm);
        CheckBox gastroabsFlat = (CheckBox) findViewById(R.id.gastroabsFlat);
        CheckBox gastroabsRounded = (CheckBox) findViewById(R.id.gastroabsRounded);
        CheckBox gastroabsObese = (CheckBox) findViewById(R.id.gastroabsObese);
        CheckBox gastroabsDistended = (CheckBox) findViewById(R.id.gastroabsDistended);

        CheckBox gastrobowelAbsent= (CheckBox) findViewById(R.id.gastrobowelAbsent);
        CheckBox gastrobowelPresent = (CheckBox) findViewById(R.id.gastrobowelPresent);
        CheckBox gastrobowelNormal = (CheckBox) findViewById(R.id.gastrobowelNormal);
        CheckBox gastrobowelIncreased = (CheckBox) findViewById(R.id.gastrobowelIncreased);
        CheckBox gastrobowelDecreased = (CheckBox) findViewById(R.id.gastrobowelDecreased);

        CheckBox gastroDietNBM = (CheckBox) findViewById(R.id.gastroDietNBM);
        CheckBox gastroDietCF = (CheckBox) findViewById(R.id.gastroDietCF);
        CheckBox gastroDietFF= (CheckBox) findViewById(R.id.gastroDietFF);
        CheckBox gastroDietD = (CheckBox) findViewById(R.id.gastroDietD);
        CheckBox gastroDietDiabetic = (CheckBox) findViewById(R.id.gastroDietDiabetic);
        CheckBox gastroDietCardiac = (CheckBox) findViewById(R.id.gastroDietCardiac);
        CheckBox gastroDietTubeFeeds = (CheckBox) findViewById(R.id.gastroDietTubeFeeds);
        CheckBox gastrodietSpecialC = (CheckBox) findViewById(R.id.gastrodietSpecialC);
        EditText gastroSpecialDesc = (EditText) findViewById(R.id.gastroSpecialDesc);
        CheckBox gastrodietother = (CheckBox) findViewById(R.id.gastrodietother);

        EditText gastroFTType = (EditText) findViewById(R.id.gastroFTType);
        EditText gastroFTInstitu = (EditText) findViewById(R.id.gastroFTInstitu);

        CheckBox gastroFTGastric = (CheckBox) findViewById(R.id.gastroFTGastric);
        CheckBox gastroFTDuodenal = (CheckBox) findViewById(R.id.gastroFTDuodenal);
        CheckBox gastroFTJejunal= (CheckBox) findViewById(R.id.gastroFTJejunal);
        CheckBox gastroFTintact = (CheckBox) findViewById(R.id.gastroFTintact);
        CheckBox gastroFTOther = (CheckBox) findViewById(R.id.gastroFTOther);
        CheckBox gastroFTVerified = (CheckBox) findViewById(R.id.gastroFTVerified);
        EditText gastroFTVerifiedDesc = (EditText) findViewById(R.id.gastroFTVerifiedDesc);

        CheckBox gastroFTAdminFeeds = (CheckBox) findViewById(R.id.gastroFTAdminFeeds);
        CheckBox gastroFTClamped = (CheckBox) findViewById(R.id.gastroFTClamped);
        CheckBox gastroFTAspirated= (CheckBox) findViewById(R.id.gastroFTAspirated);
        CheckBox gastroFTStraightDrainage = (CheckBox) findViewById(R.id.gastroFTStraightDrainage);

        EditText gastroFTDescAspirate = (EditText) findViewById(R.id.gastroFTDescAspirate);
        EditText gastroFTOtherDesc = (EditText) findViewById(R.id.gastroFTOtherDesc);

        CheckBox gastrostomyType = (CheckBox) findViewById(R.id.gastrostomyType);
        EditText gastrostomyTypeDesc = (EditText) findViewById(R.id.gastrostomyTypeDesc);
        EditText gastrostomyStomaDesc = (EditText) findViewById(R.id.gastrostomyStomaDesc);

        EditText gastrostoolLastBM = (EditText) findViewById(R.id.gastrostoolLastBM);
        EditText gastrostoolLastBMPt2 = (EditText) findViewById(R.id.gastrostoolLastBMPt2);
        CheckBox gastrostoolpriortoAdmission = (CheckBox) findViewById(R.id.gastrostoolpriortoAdmission);
        EditText gastrostoolColor = (EditText) findViewById(R.id.gastrostoolColor);
        EditText gastrostoolchar = (EditText) findViewById(R.id.gastrostoolchar);


        gastroAbDrainType.setChecked(pa.isgastro_AbdominalDrain_Type());
        gastroAbDrainDesc.setText(pa.getGastro_DrainageDescribe());
        gastroabdrainTypeDesc.setText(pa.getGastro_AbdominalDrain_Type());
        gastroabsSoft.setChecked(pa.isGastro_Adomen_Soft());
        gastroabsFirm.setChecked(pa.isGastro_Adomen_Firm());
        gastroabsFlat.setChecked(pa.isGastro_Adomen_Flat());
        gastroabsRounded.setChecked(pa.isGastro_Adomen_Rounded());
        gastroabsObese.setChecked(pa.isGastro_Adomen_Obese());
        gastroabsDistended.setChecked(pa.isGastro_Adomen_Distended());
        gastrobowelAbsent.setChecked(pa.isGastro_BowlSounds_Abs());
        gastrobowelDecreased.setChecked(pa.isGastro_BowlSounds_Decreased());
        gastrobowelIncreased.setChecked(pa.isGastro_BowlSounds_Increased());
        gastrobowelNormal.setChecked(pa.isGastro_BowlSounds_Normal());
        gastrobowelPresent.setChecked(pa.isGastro_BowlSounds_Pres());
        gastroDietNBM.setChecked(pa.isGastro_Diet_NBM());
        gastroDietCF.setChecked(pa.isGastro_Diet_CF());
        gastroDietFF.setChecked(pa.isGastro_Diet_FF());
        gastroDietD.setChecked(pa.isGastro_Diet());
        gastroDietDiabetic.setChecked(pa.isGastro_Diet_Diabetic());
        gastroDietCardiac.setChecked(pa.isGastro_Diet_Cardiac());
        gastroDietTubeFeeds.setChecked(pa.isGastro_Diet_Tube_Feeds());
        gastrodietSpecialC.setChecked(pa.isGastro_Diet_Special_Con());
        gastroSpecialDesc.setText(pa.getGastro_Diet_Speical_String());
        gastrodietother.setChecked(pa.isGastro_Diet_Other());
        gastroFTType.setText(pa.getGastro_FeedingTube_Type());
        gastroFTInstitu.setText(pa.getGastro_FeedingTube_insituTo());
        gastroFTGastric.setChecked(pa.isGastro_FeedingTube_Gastric());
        gastroFTDuodenal.setChecked(pa.isGastro_FeedingTube_Duodenel());
        gastroFTJejunal.setChecked(pa.isGastro_FeedingTube_Jeunal());
        gastroFTintact.setChecked(pa.isGastro_FeedingTube_Intact());
        gastroFTOther.setChecked(pa.isGastro_FeedingTube_Other());
        gastroFTVerified.setChecked(pa.isgastro_FeedingTube_Verified());
        gastroFTVerifiedDesc.setText(pa.getGastro_PlacementVerifiedBy());
        gastroFTAdminFeeds.setChecked(pa.isGastro_AdministeringFeeds());
        gastroFTClamped.setChecked(pa.isGastro_Clamped());
        gastroFTAspirated.setChecked(pa.isGastro_Aspirated());
        gastroFTStraightDrainage.setChecked(pa.isGastro_StraightDrainage());
        gastroFTDescAspirate.setText(pa.getGastro_DescriptionOfAspirate());
        gastroFTOtherDesc.setText(pa.getGastro_OtherDescription());
        gastrostomyType.setChecked(pa.isgastor_Ostomy_Type());
        gastrostomyTypeDesc.setText(pa.getGastro_Ostomy_Type());
        gastrostomyStomaDesc.setText(pa.getGastro_AppearanceOfStoma());
        gastrostoolLastBM.setText(pa.getGastro_LeastBM1());
        gastrostoolLastBMPt2.setText(pa.getGastro_LeastBM2());
        gastrostoolpriortoAdmission.setChecked(pa.isGastro_PriorToAdmission());
        gastrostoolColor.setText(pa.getGastro_StoolColour());
        gastrostoolchar.setText(pa.getGastro_Stoolcharacteristic());
    }

    private void setEventListeners() {
        Button btnCancelGastro = (Button) findViewById(R.id.btnCancelGastro);
        Button btnSaveExitGastro = (Button) findViewById(R.id.btnSaveExitGastro);

        btnSaveExitGastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox gastroAbDrainType = (CheckBox) findViewById(R.id.gastroabdrainType);
                EditText gastroAbDrainDesc = (EditText) findViewById(R.id.gastroabdraindesc);
                EditText gastroabdrainTypeDesc = (EditText) findViewById(R.id.gastroabdrainTypeDesc);

                CheckBox gastroabsSoft = (CheckBox) findViewById(R.id.gastroabsSoft);
                CheckBox gastroabsFirm = (CheckBox) findViewById(R.id.gastroabsFirm);
                CheckBox gastroabsFlat = (CheckBox) findViewById(R.id.gastroabsFlat);
                CheckBox gastroabsRounded = (CheckBox) findViewById(R.id.gastroabsRounded);
                CheckBox gastroabsObese = (CheckBox) findViewById(R.id.gastroabsObese);
                CheckBox gastroabsDistended = (CheckBox) findViewById(R.id.gastroabsDistended);

                CheckBox gastrobowelAbsent= (CheckBox) findViewById(R.id.gastrobowelAbsent);
                CheckBox gastrobowelPresent = (CheckBox) findViewById(R.id.gastrobowelPresent);
                CheckBox gastrobowelNormal = (CheckBox) findViewById(R.id.gastrobowelNormal);
                CheckBox gastrobowelIncreased = (CheckBox) findViewById(R.id.gastrobowelIncreased);
                CheckBox gastrobowelDecreased = (CheckBox) findViewById(R.id.gastrobowelDecreased);

                CheckBox gastroDietNBM = (CheckBox) findViewById(R.id.gastroDietNBM);
                CheckBox gastroDietCF = (CheckBox) findViewById(R.id.gastroDietCF);
                CheckBox gastroDietFF= (CheckBox) findViewById(R.id.gastroDietFF);
                CheckBox gastroDietD = (CheckBox) findViewById(R.id.gastroDietD);
                CheckBox gastroDietDiabetic = (CheckBox) findViewById(R.id.gastroDietDiabetic);
                CheckBox gastroDietCardiac = (CheckBox) findViewById(R.id.gastroDietCardiac);
                CheckBox gastroDietTubeFeeds = (CheckBox) findViewById(R.id.gastroDietTubeFeeds);
                CheckBox gastrodietSpecialC = (CheckBox) findViewById(R.id.gastrodietSpecialC);
                EditText gastroSpecialDesc = (EditText) findViewById(R.id.gastroSpecialDesc);
                CheckBox gastrodietother = (CheckBox) findViewById(R.id.gastrodietother);

                EditText gastroFTType = (EditText) findViewById(R.id.gastroFTType);
                EditText gastroFTInstitu = (EditText) findViewById(R.id.gastroFTInstitu);

                CheckBox gastroFTGastric = (CheckBox) findViewById(R.id.gastroFTGastric);
                CheckBox gastroFTDuodenal = (CheckBox) findViewById(R.id.gastroFTDuodenal);
                CheckBox gastroFTJejunal= (CheckBox) findViewById(R.id.gastroFTJejunal);
                CheckBox gastroFTintact = (CheckBox) findViewById(R.id.gastroFTintact);
                CheckBox gastroFTOther = (CheckBox) findViewById(R.id.gastroFTOther);
                CheckBox gastroFTVerified = (CheckBox) findViewById(R.id.gastroFTVerified);
                EditText gastroFTVerifiedDesc = (EditText) findViewById(R.id.gastroFTVerifiedDesc);

                CheckBox gastroFTAdminFeeds = (CheckBox) findViewById(R.id.gastroFTAdminFeeds);
                CheckBox gastroFTClamped = (CheckBox) findViewById(R.id.gastroFTClamped);
                CheckBox gastroFTAspirated= (CheckBox) findViewById(R.id.gastroFTAspirated);
                CheckBox gastroFTStraightDrainage = (CheckBox) findViewById(R.id.gastroFTStraightDrainage);

                EditText gastroFTDescAspirate = (EditText) findViewById(R.id.gastroFTDescAspirate);
                EditText gastroFTOtherDesc = (EditText) findViewById(R.id.gastroFTOtherDesc);

                // Not in DB //CheckBox gastrostomyType = (CheckBox) findViewById(R.id.gastrostomyType);
                EditText gastrostomyTypeDesc = (EditText) findViewById(R.id.gastrostomyTypeDesc);
                EditText gastrostomyStomaDesc = (EditText) findViewById(R.id.gastrostomyStomaDesc);

                EditText gastrostoolLastBM = (EditText) findViewById(R.id.gastrostoolLastBM);
                EditText gastrostoolLastBMPt2 = (EditText) findViewById(R.id.gastrostoolLastBMPt2);
                CheckBox gastrostoolpriortoAdmission = (CheckBox) findViewById(R.id.gastrostoolpriortoAdmission);
                EditText gastrostoolColor = (EditText) findViewById(R.id.gastrostoolColor);
                EditText gastrostoolchar = (EditText) findViewById(R.id.gastrostoolchar);

                pa.setGastro_AbdominalDrain_Type(gastroabdrainTypeDesc.getText().toString());
                pa.setGastro_DrainageDescribe(gastroAbDrainDesc.getText().toString());
                pa.setIsgastro_AbdominalDrain_Type(gastroAbDrainType.isChecked());
                pa.setGastro_Adomen_Soft(gastroabsSoft.isChecked());
                pa.setGastro_Adomen_Soft(gastroabsFirm.isChecked());
                pa.setGastro_Adomen_Flat(gastroabsFlat.isChecked());
                pa.setGastro_Adomen_Rounded(gastroabsRounded.isChecked());
                pa.setGastro_Adomen_Obese(gastroabsObese.isChecked());
                pa.setGastro_Adomen_Distended(gastroabsDistended.isChecked());
                pa.setGastro_BowlSounds_Abs(gastrobowelAbsent.isChecked());
                pa.setGastro_BowlSounds_Pres(gastrobowelPresent.isChecked());
                pa.setGastro_BowlSounds_Normal(gastrobowelNormal.isChecked());
                pa.setGastro_BowlSounds_Increased(gastrobowelIncreased.isChecked());
                pa.setGastro_BowlSounds_Decreased(gastrobowelDecreased.isChecked());
                pa.setGastro_Diet_NBM(gastroDietNBM.isChecked());
                pa.setGastro_Diet_CF(gastroDietCF.isChecked());
                pa.setGastro_Diet_FF(gastroDietFF.isChecked());
                pa.setGastro_Diet(gastroDietD.isChecked());
                pa.setGastro_Diet_Diabetic(gastroDietDiabetic.isChecked());
                pa.setGastro_Diet_Cardiac(gastroDietCardiac.isChecked());
                pa.setGastro_Diet_Tube_Feeds(gastroDietTubeFeeds.isChecked());
                pa.setGastro_Diet_Special_Con(gastrodietSpecialC.isChecked());
                pa.setGastro_Diet_Speical_String(gastroSpecialDesc.getText().toString());
                pa.setGastro_Diet_Other(gastrodietother.isChecked());
                pa.setGastro_FeedingTube_Type(gastroFTType.getText().toString());
                pa.setGastro_FeedingTube_insituTo(gastroFTInstitu.getText().toString());
                pa.setGastro_FeedingTube_Gastric(gastroFTGastric.isChecked());
                pa.setGastro_FeedingTube_Duodenel(gastroFTDuodenal.isChecked());
                pa.setGastro_FeedingTube_Jeunal(gastroFTJejunal.isChecked());
                pa.setGastro_FeedingTube_Intact(gastroFTintact.isChecked());
                pa.setGastro_FeedingTube_Other(gastroFTOther.isChecked());
                pa.setIsgastro_FeedingTube_Verified(gastroFTVerified.isChecked());
                pa.setGastro_PlacementVerifiedBy(gastroFTVerifiedDesc.getText().toString());
                pa.setGastro_AdministeringFeeds(gastroFTAdminFeeds.isChecked());
                pa.setGastro_Clamped(gastroFTClamped.isChecked());
                pa.setGastro_Aspirated(gastroFTAspirated.isChecked());
                pa.setGastro_StraightDrainage(gastroFTStraightDrainage.isChecked());
                pa.setGastro_DescriptionOfAspirate(gastroFTDescAspirate.getText().toString());
                pa.setGastro_OtherDescription(gastroFTOtherDesc.getText().toString());
                pa.setGastro_Ostomy_Type(gastrostomyTypeDesc.getText().toString());
                pa.setGastro_AppearanceOfStoma(gastrostomyStomaDesc.getText().toString());
                pa.setGastro_LeastBM1(Integer.valueOf(gastrostoolLastBM.getText().toString()));
                pa.setGastro_LeastBM2(Integer.valueOf(gastrostoolLastBMPt2.getText().toString()));
                pa.setGastro_PriorToAdmission(gastrostoolpriortoAdmission.isChecked());
                pa.setGastro_StoolColour(gastrostoolColor.getText().toString());
                pa.setGastro_Stoolcharacteristic(gastrostoolchar.getText().toString());
                pa.update();
                finish();
            }
        });

        btnCancelGastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setBtnToGen() {

        Button b = (Button) findViewById(R.id.btnToGastro);

        b.setOnClickListener(new BtnToGenOnClick(this, this.pa.getId()));
    }


}

