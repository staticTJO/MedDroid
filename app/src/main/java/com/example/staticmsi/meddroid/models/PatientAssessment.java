package com.example.staticmsi.meddroid.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-26.
 */
public class PatientAssessment extends AbstractJsonModel {

    private Long id = null;

    private String status; // pending, done

    // Neurological
    private String neurological_Vision_Eye;

    private String neurological_Vision_Pupils_L;

    private String neurological_Vision_Pupils_R;

    private String neurological_Verbal_Speech;

    private String neurological_Verbal_GAG_Reflex; // present, absent

    private String neurological_Motor_Reaction_L;

    private String neurological_Motor_Reaction_R;

    private String neurological_Motor_Restraints; // upper, lower

    private String neurological_Pain_Level;

    private String neurological_Pain_Description;

    private String neurological_Mental_Description;

    // Respiratory
    private boolean respiratory_Airway_Maintains_Own;

    private boolean respiratory_Airway_BIPAP_CPAP;

    private boolean respiratory_ETT;

    private float respiratory_Size;

    private float respiratory_LengthAtTeeth;

    private float respiratory_LengthAtGums;

    private float respiratory_CuffPressure;

    private float respiratory_TracheostomySize;

    private boolean respiratory_OralMucosa_intact;

    private boolean respiratory_OralMucosa_other;

    private boolean respiratory_LipCondition_intact;

    private boolean respiratory_LipCondition_other;

    private boolean respiratory_Cough_Spontaneous;

    private boolean respiratory_Cough_SimulatedBySuctioning;

    private String respiratory_Cough; // Strong, Moderate, Week, Absent

    private String respiratory_Respirations; // Ventilated, N.I.V, Non-ventilated, Easy/Regular, Deep, Shallow, Laboured,

    // Intercostal use, Other
    private String respiratory_ChestExpansion; // Symetrical, Asymetrical, Paradoxical, Tracheal tug

    private String respiratory_Trechea; // Midline, Deviated left, Deviated right

    private String respiratory_OtherDescription;

    private boolean respiratory_Clear;

    private boolean respiratory_Decreased;

    private boolean respiratory_Wheezes;

    private boolean respiratory_FineCreps;

    private boolean respiratory_AbsentBreath;

    private boolean respiratory_Bronchial;

    private boolean respiratory_Inspiratory;

    private boolean respiratory_Expiratory;

    // Cardio
    private int cardio_ECG_Lead;

    private float cardio_ECG_Rate;

    private float cardio_ECG_PR;

    private int cardio_ECG_QRS;

    private int cardio_ECG_QT;

    private int cardio_ECG_STSegment;

    private int cardio_ECG_Wave;

    private String cardio_ECG_Interpretation;

    private boolean cardio_Skin_Pink;

    private boolean cardio_Skin_Pale;

    private boolean cardio_Skin_Jaundiced;

    private boolean cardio_Skin_Flushed;

    private boolean cardio_Skin_Mottled;

    private boolean cardio_Skin_Cyanotic;

    private boolean cardio_Skin_Diaphoretic;

    private boolean cardio_Skin_Cold;

    private boolean cardio_Skin_Cool;

    private boolean cardio_Skin_Hot;

    private boolean cardio_Skin_Warm;

    private boolean cardio_Skin_Dry;

    private boolean cardio_Skin_Moist;

    private boolean cardio_Oedema_Generalised;

    private String cardio_Oedema_LocalisedTo;

    // Gastro
    private boolean gastro_Adomen_Soft;

    private boolean gastro_Adomen_Firm;

    private boolean gastro_Adomen_Flat;

    private boolean gastro_Adomen_Rounded;

    private boolean gastro_Adomen_Obese;

    private boolean gastro_Adomen_Distended;

    private boolean gastro_Adomen_Guarding;

    private boolean gastro_Adomen_ReboundTenderness;

    private String gastro_BowlSounds; // Absent, Present, Normal, Increased, Decreased

    private boolean gastro_BowlSounds_Abs;

    private boolean gastro_BowlSounds_Pres;

    private boolean gastro_BowlSounds_Normal;

    private boolean gastro_BowlSounds_Increased;

    private boolean gastro_BowlSounds_Decreased;

    private boolean gastro_Diet_NBM;

    private boolean gastro_Diet_CF;

    private boolean gastro_Diet_FF;

    private boolean gastro_Diet;

    private boolean gastro_Diet_Diabetic;

    private boolean gastro_Diet_Cardiac;

    private boolean gastro_Diet_Tube_Feeds;

    private boolean gastro_Diet_Other;

    private boolean gastro_Diet_Special_Con;

    private String gastro_Diet_Speical_String;

    // NBM, CF, FF, Diet, Diabetic, Cardiac, Tube feeds, Special Consistency, Other
    private String gastro_FeedingTube_Type;

    private String gastro_FeedingTube_insituTo;

    private boolean gastro_FeedingTube_Gastric;

    private boolean gastro_FeedingTube_Duodenel;

    private boolean gastro_FeedingTube_Jeunal;

    private boolean gastro_FeedingTube_Intact;

    private boolean gastro_FeedingTube_Other;

    private boolean isgastro_FeedingTube_Verified;

    private String gastro_PlacementVerifiedBy;

    private boolean gastro_AdministeringFeeds;

    private boolean gastro_Clamped;

    private boolean gastro_Aspirated;

    private boolean gastro_StraightDrainage;

    private String gastro_DescriptionOfAspirate;

    private String gastro_OtherDescription;

    private int gastro_LeastBM1;

    private int gastro_LeastBM2;

    private boolean gastro_PriorToAdmission;

    private String gastro_StoolColour;

    private String gastro_Stoolcharacteristic;

    private boolean isgastor_Ostomy_Type;

    private String gastro_Ostomy_Type;

    private String gastro_AbdominalDrain_Type;

    private boolean isgastro_AbdominalDrain_Type;

    private String gastro_AppearanceOfStoma;

    private String gastro_Location;

    private String gastro_DrainageDescribe;

    // Genitourinary
    private boolean IsGenitourinary_Catheter_Type;

    private String Genitourinary_Catheter_Type;

    private float Genitourinary_Catheter_Size;

    private boolean IsGenitourinary_Discharge;

    private String Genitourinary_Catheter_UrineDescribe;

    private boolean Genitourinary_Catheter_Discharge;

    private String Genitourinary_Catheter_Describe;

    private boolean Genitourinary_Catheter_Menstruating;

    // Physical
    private String physical_SkinCondition;

    private boolean physical_Sacrum_Intact;

    private boolean physical_Sacrum_Marked;

    private boolean physical_Sacrum_broken;

    private boolean physical_Heels_Intact_L;

    private boolean physical_Heels_Intact_R;

    private boolean physical_Heels_Marked_L;

    private boolean physical_Heels_Marked_R;

    private boolean physical_Heels_Broken_L;

    private boolean physical_Heels_Broken_R;

    private boolean physical_Elbows_Elbows_L;

    private boolean physical_Elbows_Elbows_R;

    private boolean physical_Elbows_Marked_L;

    private boolean physical_Elbows_Marked_R;

    private boolean physical_Elbows_Broken_L;

    private boolean physical_Elbows_Broken_R;

    private boolean physical_PatientToBePositioned_30_45_DegreesHeadUp;

    private boolean physical_CalfCompressor;

    private boolean physical_TEDS;

    private Patient patientFile = null;

    private Long version = 0L;


    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNeurological_Vision_Eye() {
        return neurological_Vision_Eye;
    }

    public void setNeurological_Vision_Eye(String neurological_Vision_Eye) {
        this.neurological_Vision_Eye = neurological_Vision_Eye;
    }

    public String getNeurological_Vision_Pupils_L() {
        return neurological_Vision_Pupils_L;
    }

    public void setNeurological_Vision_Pupils_L(String neurological_Vision_Pupils_L) {
        this.neurological_Vision_Pupils_L = neurological_Vision_Pupils_L;
    }

    public String getNeurological_Vision_Pupils_R() {
        return neurological_Vision_Pupils_R;
    }

    public void setNeurological_Vision_Pupils_R(String neurological_Vision_Pupils_R) {
        this.neurological_Vision_Pupils_R = neurological_Vision_Pupils_R;
    }

    public String getNeurological_Verbal_Speech() {
        return neurological_Verbal_Speech;
    }

    public void setNeurological_Verbal_Speech(String neurological_Verbal_Speech) {
        this.neurological_Verbal_Speech = neurological_Verbal_Speech;
    }

    public String getNeurological_Verbal_GAG_Reflex() {
        return neurological_Verbal_GAG_Reflex;
    }

    public void setNeurological_Verbal_GAG_Reflex(String neurological_Verbal_GAG_Reflex) {
        this.neurological_Verbal_GAG_Reflex = neurological_Verbal_GAG_Reflex;
    }

    public String getNeurological_Motor_Reaction_L() {
        return neurological_Motor_Reaction_L;
    }

    public void setNeurological_Motor_Reaction_L(String neurological_Motor_Reaction_L) {
        this.neurological_Motor_Reaction_L = neurological_Motor_Reaction_L;
    }

    public String getNeurological_Motor_Reaction_R() {
        return neurological_Motor_Reaction_R;
    }

    public void setNeurological_Motor_Reaction_R(String neurological_Motor_Reaction_R) {
        this.neurological_Motor_Reaction_R = neurological_Motor_Reaction_R;
    }

    public String getNeurological_Motor_Restraints() {
        return neurological_Motor_Restraints;
    }

    public void setNeurological_Motor_Restraints(String neurological_Motor_Restraints) {
        this.neurological_Motor_Restraints = neurological_Motor_Restraints;
    }

    public String getNeurological_Pain_Level() {
        return neurological_Pain_Level;
    }

    public void setNeurological_Pain_Level(String neurological_Pain_Level) {
        this.neurological_Pain_Level = neurological_Pain_Level;
    }

    public String getNeurological_Pain_Description() {
        return neurological_Pain_Description;
    }

    public void setNeurological_Pain_Description(String neurological_Pain_Description) {
        this.neurological_Pain_Description = neurological_Pain_Description;
    }

    public String getNeurological_Mental_Description() {
        return neurological_Mental_Description;
    }

    public void setNeurological_Mental_Description(String neurological_Mental_Description) {
        this.neurological_Mental_Description = neurological_Mental_Description;
    }

    public boolean isRespiratory_Airway_Maintains_Own() {
        return respiratory_Airway_Maintains_Own;
    }

    public void setRespiratory_Airway_Maintains_Own(boolean respiratory_Airway_Maintains_Own) {
        this.respiratory_Airway_Maintains_Own = respiratory_Airway_Maintains_Own;
    }

    public boolean isRespiratory_Airway_BIPAP_CPAP() {
        return respiratory_Airway_BIPAP_CPAP;
    }

    public void setRespiratory_Airway_BIPAP_CPAP(boolean respiratory_Airway_BIPAP_CPAP) {
        this.respiratory_Airway_BIPAP_CPAP = respiratory_Airway_BIPAP_CPAP;
    }

    public boolean isRespiratory_ETT() {
        return respiratory_ETT;
    }

    public void setRespiratory_ETT(boolean respiratory_ETT) {
        this.respiratory_ETT = respiratory_ETT;
    }

    public float getRespiratory_Size() {
        return respiratory_Size;
    }

    public void setRespiratory_Size(float respiratory_Size) {
        this.respiratory_Size = respiratory_Size;
    }

    public float getRespiratory_LengthAtTeeth() {
        return respiratory_LengthAtTeeth;
    }

    public void setRespiratory_LengthAtTeeth(float respiratory_LengthAtTeeth) {
        this.respiratory_LengthAtTeeth = respiratory_LengthAtTeeth;
    }

    public float getRespiratory_LengthAtGums() {
        return respiratory_LengthAtGums;
    }

    public void setRespiratory_LengthAtGums(float respiratory_LengthAtGums) {
        this.respiratory_LengthAtGums = respiratory_LengthAtGums;
    }

    public float getRespiratory_CuffPressure() {
        return respiratory_CuffPressure;
    }

    public void setRespiratory_CuffPressure(float respiratory_CuffPressure) {
        this.respiratory_CuffPressure = respiratory_CuffPressure;
    }

    public float getRespiratory_TracheostomySize() {
        return respiratory_TracheostomySize;
    }

    public void setRespiratory_TracheostomySize(float respiratory_TracheostomySize) {
        this.respiratory_TracheostomySize = respiratory_TracheostomySize;
    }

    public boolean isRespiratory_OralMucosa_intact() {
        return respiratory_OralMucosa_intact;
    }

    public void setRespiratory_OralMucosa_intact(boolean respiratory_OralMucosa_intact) {
        this.respiratory_OralMucosa_intact = respiratory_OralMucosa_intact;
    }

    public boolean isRespiratory_OralMucosa_other() {
        return respiratory_OralMucosa_other;
    }

    public void setRespiratory_OralMucosa_other(boolean respiratory_OralMucosa_other) {
        this.respiratory_OralMucosa_other = respiratory_OralMucosa_other;
    }

    public boolean isRespiratory_LipCondition_intact() {
        return respiratory_LipCondition_intact;
    }

    public void setRespiratory_LipCondition_intact(boolean respiratory_LipCondition_intact) {
        this.respiratory_LipCondition_intact = respiratory_LipCondition_intact;
    }

    public boolean isRespiratory_LipCondition_other() {
        return respiratory_LipCondition_other;
    }

    public void setRespiratory_LipCondition_other(boolean respiratory_LipCondition_other) {
        this.respiratory_LipCondition_other = respiratory_LipCondition_other;
    }

    public boolean isRespiratory_Cough_Spontaneous() {
        return respiratory_Cough_Spontaneous;
    }

    public void setRespiratory_Cough_Spontaneous(boolean respiratory_Cough_Spontaneous) {
        this.respiratory_Cough_Spontaneous = respiratory_Cough_Spontaneous;
    }

    public boolean isRespiratory_Cough_SimulatedBySuctioning() {
        return respiratory_Cough_SimulatedBySuctioning;
    }

    public void setRespiratory_Cough_SimulatedBySuctioning(boolean respiratory_Cough_SimulatedBySuctioning) {
        this.respiratory_Cough_SimulatedBySuctioning = respiratory_Cough_SimulatedBySuctioning;
    }

    public String getRespiratory_Cough() {
        return respiratory_Cough;
    }

    public void setRespiratory_Cough(String respiratory_Cough) {
        this.respiratory_Cough = respiratory_Cough;
    }

    public String getRespiratory_Respirations() {
        return respiratory_Respirations;
    }

    public void setRespiratory_Respirations(String respiratory_Respirations) {
        this.respiratory_Respirations = respiratory_Respirations;
    }

    public String getRespiratory_ChestExpansion() {
        return respiratory_ChestExpansion;
    }

    public void setRespiratory_ChestExpansion(String respiratory_ChestExpansion) {
        this.respiratory_ChestExpansion = respiratory_ChestExpansion;
    }

    public String getRespiratory_Trechea() {
        return respiratory_Trechea;
    }

    public void setRespiratory_Trechea(String respiratory_Trechea) {
        this.respiratory_Trechea = respiratory_Trechea;
    }

    public String getRespiratory_OtherDescription() {
        return respiratory_OtherDescription;
    }

    public void setRespiratory_OtherDescription(String respiratory_OtherDescription) {
        this.respiratory_OtherDescription = respiratory_OtherDescription;
    }

    public boolean isRespiratory_Clear() {
        return respiratory_Clear;
    }

    public void setRespiratory_Clear(boolean respiratory_Clear) {
        this.respiratory_Clear = respiratory_Clear;
    }

    public boolean isRespiratory_Decreased() {
        return respiratory_Decreased;
    }

    public void setRespiratory_Decreased(boolean respiratory_Decreased) {
        this.respiratory_Decreased = respiratory_Decreased;
    }

    public boolean isRespiratory_Wheezes() {
        return respiratory_Wheezes;
    }

    public void setRespiratory_Wheezes(boolean respiratory_Wheezes) {
        this.respiratory_Wheezes = respiratory_Wheezes;
    }

    public boolean isRespiratory_FineCreps() {
        return respiratory_FineCreps;
    }

    public void setRespiratory_FineCreps(boolean respiratory_FineCreps) {
        this.respiratory_FineCreps = respiratory_FineCreps;
    }

    public boolean isRespiratory_AbsentBreath() {
        return respiratory_AbsentBreath;
    }

    public void setRespiratory_AbsentBreath(boolean respiratory_AbsentBreath) {
        this.respiratory_AbsentBreath = respiratory_AbsentBreath;
    }

    public boolean isRespiratory_Bronchial() {
        return respiratory_Bronchial;
    }

    public void setRespiratory_Bronchial(boolean respiratory_Bronchial) {
        this.respiratory_Bronchial = respiratory_Bronchial;
    }

    public boolean isRespiratory_Inspiratory() {
        return respiratory_Inspiratory;
    }

    public void setRespiratory_Inspiratory(boolean respiratory_Inspiratory) {
        this.respiratory_Inspiratory = respiratory_Inspiratory;
    }

    public boolean isRespiratory_Expiratory() {
        return respiratory_Expiratory;
    }

    public void setRespiratory_Expiratory(boolean respiratory_Expiratory) {
        this.respiratory_Expiratory = respiratory_Expiratory;
    }

    public int getCardio_ECG_Lead() {
        return cardio_ECG_Lead;
    }

    public void setCardio_ECG_Lead(int cardio_ECG_Lead) {
        this.cardio_ECG_Lead = cardio_ECG_Lead;
    }

    public float getCardio_ECG_Rate() {
        return cardio_ECG_Rate;
    }

    public void setCardio_ECG_Rate(float cardio_ECG_Rate) {
        this.cardio_ECG_Rate = cardio_ECG_Rate;
    }

    public float getCardio_ECG_PR() {
        return cardio_ECG_PR;
    }

    public void setCardio_ECG_PR(float cardio_ECG_PR) {
        this.cardio_ECG_PR = cardio_ECG_PR;
    }

    public int getCardio_ECG_QRS() {
        return cardio_ECG_QRS;
    }

    public void setCardio_ECG_QRS(int cardio_ECG_QRS) {
        this.cardio_ECG_QRS = cardio_ECG_QRS;
    }

    public int getCardio_ECG_QT() {
        return cardio_ECG_QT;
    }

    public void setCardio_ECG_QT(int cardio_ECG_QT) {
        this.cardio_ECG_QT = cardio_ECG_QT;
    }

    public int getCardio_ECG_STSegment() {
        return cardio_ECG_STSegment;
    }

    public void setCardio_ECG_STSegment(int cardio_ECG_STSegment) {
        this.cardio_ECG_STSegment = cardio_ECG_STSegment;
    }

    public int getCardio_ECG_Wave() {
        return cardio_ECG_Wave;
    }

    public void setCardio_ECG_Wave(int cardio_ECG_Wave) {
        this.cardio_ECG_Wave = cardio_ECG_Wave;
    }

    public String getCardio_ECG_Interpretation() {
        return cardio_ECG_Interpretation;
    }

    public void setCardio_ECG_Interpretation(String cardio_ECG_Interpretation) {
        this.cardio_ECG_Interpretation = cardio_ECG_Interpretation;
    }

    public boolean isCardio_Skin_Pink() {
        return cardio_Skin_Pink;
    }

    public void setCardio_Skin_Pink(boolean cardio_Skin_Pink) {
        this.cardio_Skin_Pink = cardio_Skin_Pink;
    }

    public boolean isCardio_Skin_Pale() {
        return cardio_Skin_Pale;
    }

    public void setCardio_Skin_Pale(boolean cardio_Skin_Pale) {
        this.cardio_Skin_Pale = cardio_Skin_Pale;
    }

    public boolean isCardio_Skin_Jaundiced() {
        return cardio_Skin_Jaundiced;
    }

    public void setCardio_Skin_Jaundiced(boolean cardio_Skin_Jaundiced) {
        this.cardio_Skin_Jaundiced = cardio_Skin_Jaundiced;
    }

    public boolean isCardio_Skin_Flushed() {
        return cardio_Skin_Flushed;
    }

    public void setCardio_Skin_Flushed(boolean cardio_Skin_Flushed) {
        this.cardio_Skin_Flushed = cardio_Skin_Flushed;
    }

    public boolean isCardio_Skin_Mottled() {
        return cardio_Skin_Mottled;
    }

    public void setCardio_Skin_Mottled(boolean cardio_Skin_Mottled) {
        this.cardio_Skin_Mottled = cardio_Skin_Mottled;
    }

    public boolean isCardio_Skin_Cyanotic() {
        return cardio_Skin_Cyanotic;
    }

    public void setCardio_Skin_Cyanotic(boolean cardio_Skin_Cyanotic) {
        this.cardio_Skin_Cyanotic = cardio_Skin_Cyanotic;
    }

    public boolean isCardio_Skin_Diaphoretic() {
        return cardio_Skin_Diaphoretic;
    }

    public void setCardio_Skin_Diaphoretic(boolean cardio_Skin_Diaphoretic) {
        this.cardio_Skin_Diaphoretic = cardio_Skin_Diaphoretic;
    }

    public boolean isCardio_Skin_Cold() {
        return cardio_Skin_Cold;
    }

    public void setCardio_Skin_Cold(boolean cardio_Skin_Cold) {
        this.cardio_Skin_Cold = cardio_Skin_Cold;
    }

    public boolean isCardio_Skin_Cool() {
        return cardio_Skin_Cool;
    }

    public void setCardio_Skin_Cool(boolean cardio_Skin_Cool) {
        this.cardio_Skin_Cool = cardio_Skin_Cool;
    }

    public boolean isCardio_Skin_Hot() {
        return cardio_Skin_Hot;
    }

    public void setCardio_Skin_Hot(boolean cardio_Skin_Hot) {
        this.cardio_Skin_Hot = cardio_Skin_Hot;
    }

    public boolean isCardio_Skin_Warm() {
        return cardio_Skin_Warm;
    }

    public void setCardio_Skin_Warm(boolean cardio_Skin_Warm) {
        this.cardio_Skin_Warm = cardio_Skin_Warm;
    }

    public boolean isCardio_Skin_Dry() {
        return cardio_Skin_Dry;
    }

    public void setCardio_Skin_Dry(boolean cardio_Skin_Dry) {
        this.cardio_Skin_Dry = cardio_Skin_Dry;
    }

    public boolean isCardio_Skin_Moist() {
        return cardio_Skin_Moist;
    }

    public void setCardio_Skin_Moist(boolean cardio_Skin_Moist) {
        this.cardio_Skin_Moist = cardio_Skin_Moist;
    }

    public boolean isCardio_Oedema_Generalised() {
        return cardio_Oedema_Generalised;
    }

    public void setCardio_Oedema_Generalised(boolean cardio_Oedema_Generalised) {
        this.cardio_Oedema_Generalised = cardio_Oedema_Generalised;
    }

    public String getCardio_Oedema_LocalisedTo() {
        return cardio_Oedema_LocalisedTo;
    }

    public void setCardio_Oedema_LocalisedTo(String cardio_Oedema_LocalisedTo) {
        this.cardio_Oedema_LocalisedTo = cardio_Oedema_LocalisedTo;
    }

    public boolean isGastro_Adomen_Soft() {
        return gastro_Adomen_Soft;
    }

    public void setGastro_Adomen_Soft(boolean gastro_Adomen_Soft) {
        this.gastro_Adomen_Soft = gastro_Adomen_Soft;
    }

    public boolean isGastro_Adomen_Firm() {
        return gastro_Adomen_Firm;
    }

    public void setGastro_Adomen_Firm(boolean gastro_Adomen_Firm) {
        this.gastro_Adomen_Firm = gastro_Adomen_Firm;
    }

    public boolean isGastro_Adomen_Flat() {
        return gastro_Adomen_Flat;
    }

    public void setGastro_Adomen_Flat(boolean gastro_Adomen_Flat) {
        this.gastro_Adomen_Flat = gastro_Adomen_Flat;
    }

    public boolean isGastro_Adomen_Rounded() {
        return gastro_Adomen_Rounded;
    }

    public void setGastro_Adomen_Rounded(boolean gastro_Adomen_Rounded) {
        this.gastro_Adomen_Rounded = gastro_Adomen_Rounded;
    }

    public boolean isGastro_Adomen_Obese() {
        return gastro_Adomen_Obese;
    }

    public void setGastro_Adomen_Obese(boolean gastro_Adomen_Obese) {
        this.gastro_Adomen_Obese = gastro_Adomen_Obese;
    }

    public boolean isGastro_Adomen_Distended() {
        return gastro_Adomen_Distended;
    }

    public void setGastro_Adomen_Distended(boolean gastro_Adomen_Distended) {
        this.gastro_Adomen_Distended = gastro_Adomen_Distended;
    }

    public boolean isGastro_Adomen_Guarding() {
        return gastro_Adomen_Guarding;
    }

    public void setGastro_Adomen_Guarding(boolean gastro_Adomen_Guarding) {
        this.gastro_Adomen_Guarding = gastro_Adomen_Guarding;
    }

    public boolean isGastro_Adomen_ReboundTenderness() {
        return gastro_Adomen_ReboundTenderness;
    }

    public void setGastro_Adomen_ReboundTenderness(boolean gastro_Adomen_ReboundTenderness) {
        this.gastro_Adomen_ReboundTenderness = gastro_Adomen_ReboundTenderness;
    }

    public String getGastro_BowlSounds() {
        return gastro_BowlSounds;
    }

    public void setGastro_BowlSounds(String gastro_BowlSounds) {
        this.gastro_BowlSounds = gastro_BowlSounds;
    }

    public boolean isGastro_BowlSounds_Abs() {
        return gastro_BowlSounds_Abs;
    }

    public void setGastro_BowlSounds_Abs(boolean gastro_BowlSounds_Abs) {
        this.gastro_BowlSounds_Abs = gastro_BowlSounds_Abs;
    }

    public boolean isGastro_BowlSounds_Pres() {
        return gastro_BowlSounds_Pres;
    }

    public void setGastro_BowlSounds_Pres(boolean gastro_BowlSounds_Pres) {
        this.gastro_BowlSounds_Pres = gastro_BowlSounds_Pres;
    }

    public boolean isGastro_BowlSounds_Normal() {
        return gastro_BowlSounds_Normal;
    }

    public void setGastro_BowlSounds_Normal(boolean gastro_BowlSounds_Normal) {
        this.gastro_BowlSounds_Normal = gastro_BowlSounds_Normal;
    }

    public boolean isGastro_BowlSounds_Increased() {
        return gastro_BowlSounds_Increased;
    }

    public void setGastro_BowlSounds_Increased(boolean gastro_BowlSounds_Increased) {
        this.gastro_BowlSounds_Increased = gastro_BowlSounds_Increased;
    }

    public boolean isGastro_BowlSounds_Decreased() {
        return gastro_BowlSounds_Decreased;
    }

    public void setGastro_BowlSounds_Decreased(boolean gastro_BowlSounds_Decreased) {
        this.gastro_BowlSounds_Decreased = gastro_BowlSounds_Decreased;
    }

    public boolean isGastro_Diet_NBM() {
        return gastro_Diet_NBM;
    }

    public void setGastro_Diet_NBM(boolean gastro_Diet_NBM) {
        this.gastro_Diet_NBM = gastro_Diet_NBM;
    }

    public boolean isGastro_Diet_CF() {
        return gastro_Diet_CF;
    }

    public void setGastro_Diet_CF(boolean gastro_Diet_CF) {
        this.gastro_Diet_CF = gastro_Diet_CF;
    }

    public boolean isGastro_Diet_FF() {
        return gastro_Diet_FF;
    }

    public void setGastro_Diet_FF(boolean gastro_Diet_FF) {
        this.gastro_Diet_FF = gastro_Diet_FF;
    }

    public boolean isGastro_Diet() {
        return gastro_Diet;
    }

    public void setGastro_Diet(boolean gastro_Diet) {
        this.gastro_Diet = gastro_Diet;
    }

    public boolean isGastro_Diet_Diabetic() {
        return gastro_Diet_Diabetic;
    }

    public void setGastro_Diet_Diabetic(boolean gastro_Diet_Diabetic) {
        this.gastro_Diet_Diabetic = gastro_Diet_Diabetic;
    }

    public boolean isGastro_Diet_Cardiac() {
        return gastro_Diet_Cardiac;
    }

    public void setGastro_Diet_Cardiac(boolean gastro_Diet_Cardiac) {
        this.gastro_Diet_Cardiac = gastro_Diet_Cardiac;
    }

    public boolean isGastro_Diet_Tube_Feeds() {
        return gastro_Diet_Tube_Feeds;
    }

    public void setGastro_Diet_Tube_Feeds(boolean gastro_Diet_Tube_Feeds) {
        this.gastro_Diet_Tube_Feeds = gastro_Diet_Tube_Feeds;
    }

    public boolean isGastro_Diet_Other() {
        return gastro_Diet_Other;
    }

    public void setGastro_Diet_Other(boolean gastro_Diet_Other) {
        this.gastro_Diet_Other = gastro_Diet_Other;
    }

    public boolean isGastro_Diet_Special_Con() {
        return gastro_Diet_Special_Con;
    }

    public void setGastro_Diet_Special_Con(boolean gastro_Diet_Special_Con) {
        this.gastro_Diet_Special_Con = gastro_Diet_Special_Con;
    }

    public String getGastro_Diet_Speical_String() {
        return gastro_Diet_Speical_String;
    }

    public void setGastro_Diet_Speical_String(String gastro_Diet_Speical_String) {
        this.gastro_Diet_Speical_String = gastro_Diet_Speical_String;
    }

    public String getGastro_FeedingTube_Type() {
        return gastro_FeedingTube_Type;
    }

    public void setGastro_FeedingTube_Type(String gastro_FeedingTube_Type) {
        this.gastro_FeedingTube_Type = gastro_FeedingTube_Type;
    }

    public String getGastro_FeedingTube_insituTo() {
        return gastro_FeedingTube_insituTo;
    }

    public void setGastro_FeedingTube_insituTo(String gastro_FeedingTube_insituTo) {
        this.gastro_FeedingTube_insituTo = gastro_FeedingTube_insituTo;
    }

    public boolean isGastro_FeedingTube_Gastric() {
        return gastro_FeedingTube_Gastric;
    }

    public void setGastro_FeedingTube_Gastric(boolean gastro_FeedingTube_Gastric) {
        this.gastro_FeedingTube_Gastric = gastro_FeedingTube_Gastric;
    }

    public boolean isGastro_FeedingTube_Duodenel() {
        return gastro_FeedingTube_Duodenel;
    }

    public void setGastro_FeedingTube_Duodenel(boolean gastro_FeedingTube_Duodenel) {
        this.gastro_FeedingTube_Duodenel = gastro_FeedingTube_Duodenel;
    }

    public boolean isGastro_FeedingTube_Jeunal() {
        return gastro_FeedingTube_Jeunal;
    }

    public void setGastro_FeedingTube_Jeunal(boolean gastro_FeedingTube_Jeunal) {
        this.gastro_FeedingTube_Jeunal = gastro_FeedingTube_Jeunal;
    }

    public boolean isGastro_FeedingTube_Intact() {
        return gastro_FeedingTube_Intact;
    }

    public void setGastro_FeedingTube_Intact(boolean gastro_FeedingTube_Intact) {
        this.gastro_FeedingTube_Intact = gastro_FeedingTube_Intact;
    }

    public boolean isGastro_FeedingTube_Other() {
        return gastro_FeedingTube_Other;
    }

    public void setGastro_FeedingTube_Other(boolean gastro_FeedingTube_Other) {
        this.gastro_FeedingTube_Other = gastro_FeedingTube_Other;
    }

    public boolean isgastro_FeedingTube_Verified() {
        return isgastro_FeedingTube_Verified;
    }

    public void setIsgastro_FeedingTube_Verified(boolean isgastro_FeedingTube_Verified) {
        this.isgastro_FeedingTube_Verified = isgastro_FeedingTube_Verified;
    }

    public String getGastro_PlacementVerifiedBy() {
        return gastro_PlacementVerifiedBy;
    }

    public void setGastro_PlacementVerifiedBy(String gastro_PlacementVerifiedBy) {
        this.gastro_PlacementVerifiedBy = gastro_PlacementVerifiedBy;
    }

    public boolean isGastro_AdministeringFeeds() {
        return gastro_AdministeringFeeds;
    }

    public void setGastro_AdministeringFeeds(boolean gastro_AdministeringFeeds) {
        this.gastro_AdministeringFeeds = gastro_AdministeringFeeds;
    }

    public boolean isGastro_Clamped() {
        return gastro_Clamped;
    }

    public void setGastro_Clamped(boolean gastro_Clamped) {
        this.gastro_Clamped = gastro_Clamped;
    }

    public boolean isGastro_Aspirated() {
        return gastro_Aspirated;
    }

    public void setGastro_Aspirated(boolean gastro_Aspirated) {
        this.gastro_Aspirated = gastro_Aspirated;
    }

    public boolean isGastro_StraightDrainage() {
        return gastro_StraightDrainage;
    }

    public void setGastro_StraightDrainage(boolean gastro_StraightDrainage) {
        this.gastro_StraightDrainage = gastro_StraightDrainage;
    }

    public String getGastro_DescriptionOfAspirate() {
        return gastro_DescriptionOfAspirate;
    }

    public void setGastro_DescriptionOfAspirate(String gastro_DescriptionOfAspirate) {
        this.gastro_DescriptionOfAspirate = gastro_DescriptionOfAspirate;
    }

    public String getGastro_OtherDescription() {
        return gastro_OtherDescription;
    }

    public void setGastro_OtherDescription(String gastro_OtherDescription) {
        this.gastro_OtherDescription = gastro_OtherDescription;
    }

    public int getGastro_LeastBM1() {
        return gastro_LeastBM1;
    }

    public void setGastro_LeastBM1(int gastro_LeastBM1) {
        this.gastro_LeastBM1 = gastro_LeastBM1;
    }

    public int getGastro_LeastBM2() {
        return gastro_LeastBM2;
    }

    public void setGastro_LeastBM2(int gastro_LeastBM2) {
        this.gastro_LeastBM2 = gastro_LeastBM2;
    }

    public boolean isGastro_PriorToAdmission() {
        return gastro_PriorToAdmission;
    }

    public void setGastro_PriorToAdmission(boolean gastro_PriorToAdmission) {
        this.gastro_PriorToAdmission = gastro_PriorToAdmission;
    }

    public String getGastro_StoolColour() {
        return gastro_StoolColour;
    }

    public void setGastro_StoolColour(String gastro_StoolColour) {
        this.gastro_StoolColour = gastro_StoolColour;
    }

    public String getGastro_Stoolcharacteristic() {
        return gastro_Stoolcharacteristic;
    }

    public void setGastro_Stoolcharacteristic(String gastro_Stoolcharacteristic) {
        this.gastro_Stoolcharacteristic = gastro_Stoolcharacteristic;
    }

    public boolean isgastor_Ostomy_Type() {
        return isgastor_Ostomy_Type;
    }

    public void setIsgastor_Ostomy_Type(boolean isgastor_Ostomy_Type) {
        this.isgastor_Ostomy_Type = isgastor_Ostomy_Type;
    }

    public String getGastro_Ostomy_Type() {
        return gastro_Ostomy_Type;
    }

    public void setGastro_Ostomy_Type(String gastro_Ostomy_Type) {
        this.gastro_Ostomy_Type = gastro_Ostomy_Type;
    }

    public String getGastro_AbdominalDrain_Type() {
        return gastro_AbdominalDrain_Type;
    }

    public void setGastro_AbdominalDrain_Type(String gastro_AbdominalDrain_Type) {
        this.gastro_AbdominalDrain_Type = gastro_AbdominalDrain_Type;
    }

    public boolean isgastro_AbdominalDrain_Type() {
        return isgastro_AbdominalDrain_Type;
    }

    public void setIsgastro_AbdominalDrain_Type(boolean isgastro_AbdominalDrain_Type) {
        this.isgastro_AbdominalDrain_Type = isgastro_AbdominalDrain_Type;
    }

    public String getGastro_AppearanceOfStoma() {
        return gastro_AppearanceOfStoma;
    }

    public void setGastro_AppearanceOfStoma(String gastro_AppearanceOfStoma) {
        this.gastro_AppearanceOfStoma = gastro_AppearanceOfStoma;
    }

    public String getGastro_Location() {
        return gastro_Location;
    }

    public void setGastro_Location(String gastro_Location) {
        this.gastro_Location = gastro_Location;
    }

    public String getGastro_DrainageDescribe() {
        return gastro_DrainageDescribe;
    }

    public void setGastro_DrainageDescribe(String gastro_DrainageDescribe) {
        this.gastro_DrainageDescribe = gastro_DrainageDescribe;
    }

    public boolean isGenitourinary_Catheter_Type() {
        return IsGenitourinary_Catheter_Type;
    }

    public void setIsGenitourinary_Catheter_Type(boolean isGenitourinary_Catheter_Type) {
        IsGenitourinary_Catheter_Type = isGenitourinary_Catheter_Type;
    }

    public String getGenitourinary_Catheter_Type() {
        return Genitourinary_Catheter_Type;
    }

    public void setGenitourinary_Catheter_Type(String genitourinary_Catheter_Type) {
        Genitourinary_Catheter_Type = genitourinary_Catheter_Type;
    }

    public float getGenitourinary_Catheter_Size() {
        return Genitourinary_Catheter_Size;
    }

    public void setGenitourinary_Catheter_Size(float genitourinary_Catheter_Size) {
        Genitourinary_Catheter_Size = genitourinary_Catheter_Size;
    }

    public boolean isGenitourinary_Discharge() {
        return IsGenitourinary_Discharge;
    }

    public void setIsGenitourinary_Discharge(boolean isGenitourinary_Discharge) {
        IsGenitourinary_Discharge = isGenitourinary_Discharge;
    }

    public String getGenitourinary_Catheter_UrineDescribe() {
        return Genitourinary_Catheter_UrineDescribe;
    }

    public void setGenitourinary_Catheter_UrineDescribe(String genitourinary_Catheter_UrineDescribe) {
        Genitourinary_Catheter_UrineDescribe = genitourinary_Catheter_UrineDescribe;
    }

    public boolean isGenitourinary_Catheter_Discharge() {
        return Genitourinary_Catheter_Discharge;
    }

    public void setGenitourinary_Catheter_Discharge(boolean genitourinary_Catheter_Discharge) {
        Genitourinary_Catheter_Discharge = genitourinary_Catheter_Discharge;
    }

    public String getGenitourinary_Catheter_Describe() {
        return Genitourinary_Catheter_Describe;
    }

    public void setGenitourinary_Catheter_Describe(String genitourinary_Catheter_Describe) {
        Genitourinary_Catheter_Describe = genitourinary_Catheter_Describe;
    }

    public boolean isGenitourinary_Catheter_Menstruating() {
        return Genitourinary_Catheter_Menstruating;
    }

    public void setGenitourinary_Catheter_Menstruating(boolean genitourinary_Catheter_Menstruating) {
        Genitourinary_Catheter_Menstruating = genitourinary_Catheter_Menstruating;
    }

    public String getPhysical_SkinCondition() {
        return physical_SkinCondition;
    }

    public void setPhysical_SkinCondition(String physical_SkinCondition) {
        this.physical_SkinCondition = physical_SkinCondition;
    }

    public boolean isPhysical_Sacrum_Intact() {
        return physical_Sacrum_Intact;
    }

    public void setPhysical_Sacrum_Intact(boolean physical_Sacrum_Intact) {
        this.physical_Sacrum_Intact = physical_Sacrum_Intact;
    }

    public boolean isPhysical_Sacrum_Marked() {
        return physical_Sacrum_Marked;
    }

    public void setPhysical_Sacrum_Marked(boolean physical_Sacrum_Marked) {
        this.physical_Sacrum_Marked = physical_Sacrum_Marked;
    }

    public boolean isPhysical_Sacrum_broken() {
        return physical_Sacrum_broken;
    }

    public void setPhysical_Sacrum_broken(boolean physical_Sacrum_broken) {
        this.physical_Sacrum_broken = physical_Sacrum_broken;
    }

    public boolean isPhysical_Heels_Intact_L() {
        return physical_Heels_Intact_L;
    }

    public void setPhysical_Heels_Intact_L(boolean physical_Heels_Intact_L) {
        this.physical_Heels_Intact_L = physical_Heels_Intact_L;
    }

    public boolean isPhysical_Heels_Intact_R() {
        return physical_Heels_Intact_R;
    }

    public void setPhysical_Heels_Intact_R(boolean physical_Heels_Intact_R) {
        this.physical_Heels_Intact_R = physical_Heels_Intact_R;
    }

    public boolean isPhysical_Heels_Marked_L() {
        return physical_Heels_Marked_L;
    }

    public void setPhysical_Heels_Marked_L(boolean physical_Heels_Marked_L) {
        this.physical_Heels_Marked_L = physical_Heels_Marked_L;
    }

    public boolean isPhysical_Heels_Marked_R() {
        return physical_Heels_Marked_R;
    }

    public void setPhysical_Heels_Marked_R(boolean physical_Heels_Marked_R) {
        this.physical_Heels_Marked_R = physical_Heels_Marked_R;
    }

    public boolean isPhysical_Heels_Broken_L() {
        return physical_Heels_Broken_L;
    }

    public void setPhysical_Heels_Broken_L(boolean physical_Heels_Broken_L) {
        this.physical_Heels_Broken_L = physical_Heels_Broken_L;
    }

    public boolean isPhysical_Heels_Broken_R() {
        return physical_Heels_Broken_R;
    }

    public void setPhysical_Heels_Broken_R(boolean physical_Heels_Broken_R) {
        this.physical_Heels_Broken_R = physical_Heels_Broken_R;
    }

    public boolean isPhysical_Elbows_Elbows_L() {
        return physical_Elbows_Elbows_L;
    }

    public void setPhysical_Elbows_Elbows_L(boolean physical_Elbows_Elbows_L) {
        this.physical_Elbows_Elbows_L = physical_Elbows_Elbows_L;
    }

    public boolean isPhysical_Elbows_Elbows_R() {
        return physical_Elbows_Elbows_R;
    }

    public void setPhysical_Elbows_Elbows_R(boolean physical_Elbows_Elbows_R) {
        this.physical_Elbows_Elbows_R = physical_Elbows_Elbows_R;
    }

    public boolean isPhysical_Elbows_Marked_L() {
        return physical_Elbows_Marked_L;
    }

    public void setPhysical_Elbows_Marked_L(boolean physical_Elbows_Marked_L) {
        this.physical_Elbows_Marked_L = physical_Elbows_Marked_L;
    }

    public boolean isPhysical_Elbows_Marked_R() {
        return physical_Elbows_Marked_R;
    }

    public void setPhysical_Elbows_Marked_R(boolean physical_Elbows_Marked_R) {
        this.physical_Elbows_Marked_R = physical_Elbows_Marked_R;
    }

    public boolean isPhysical_Elbows_Broken_L() {
        return physical_Elbows_Broken_L;
    }

    public void setPhysical_Elbows_Broken_L(boolean physical_Elbows_Broken_L) {
        this.physical_Elbows_Broken_L = physical_Elbows_Broken_L;
    }

    public boolean isPhysical_Elbows_Broken_R() {
        return physical_Elbows_Broken_R;
    }

    public void setPhysical_Elbows_Broken_R(boolean physical_Elbows_Broken_R) {
        this.physical_Elbows_Broken_R = physical_Elbows_Broken_R;
    }

    public boolean isPhysical_PatientToBePositioned_30_45_DegreesHeadUp() {
        return physical_PatientToBePositioned_30_45_DegreesHeadUp;
    }

    public void setPhysical_PatientToBePositioned_30_45_DegreesHeadUp(boolean physical_PatientToBePositioned_30_45_DegreesHeadUp) {
        this.physical_PatientToBePositioned_30_45_DegreesHeadUp = physical_PatientToBePositioned_30_45_DegreesHeadUp;
    }

    public boolean isPhysical_CalfCompressor() {
        return physical_CalfCompressor;
    }

    public void setPhysical_CalfCompressor(boolean physical_CalfCompressor) {
        this.physical_CalfCompressor = physical_CalfCompressor;
    }

    public boolean isPhysical_TEDS() {
        return physical_TEDS;
    }

    public void setPhysical_TEDS(boolean physical_TEDS) {
        this.physical_TEDS = physical_TEDS;
    }

    public Patient getPatientFile() {
        return patientFile;
    }

    public void setPatientFile(Patient patientFile) {
        this.patientFile = patientFile;
    }


    @Override
    public String toString() {
        String idTemp;

        if (id == null)
            idTemp = "null";
        else
            idTemp = id.toString();

        return "PatientAssessment{" +
                "id=" + idTemp +
                ", status='" + status + '\'' +
                ", neurological_Vision_Eye='" + neurological_Vision_Eye + '\'' +
                ", neurological_Vision_Pupils_L='" + neurological_Vision_Pupils_L + '\'' +
                ", neurological_Vision_Pupils_R='" + neurological_Vision_Pupils_R + '\'' +
                ", neurological_Verbal_Speech='" + neurological_Verbal_Speech + '\'' +
                ", neurological_Verbal_GAG_Reflex='" + neurological_Verbal_GAG_Reflex + '\'' +
                ", neurological_Motor_Reaction_L='" + neurological_Motor_Reaction_L + '\'' +
                ", neurological_Motor_Reaction_R='" + neurological_Motor_Reaction_R + '\'' +
                ", neurological_Motor_Restraints='" + neurological_Motor_Restraints + '\'' +
                ", neurological_Pain_Level='" + neurological_Pain_Level + '\'' +
                ", neurological_Pain_Description='" + neurological_Pain_Description + '\'' +
                ", neurological_Mental_Description='" + neurological_Mental_Description + '\'' +
                ", respiratory_Airway_Maintains_Own=" + respiratory_Airway_Maintains_Own +
                ", respiratory_Airway_BIPAP_CPAP=" + respiratory_Airway_BIPAP_CPAP +
                ", respiratory_ETT=" + respiratory_ETT +
                ", respiratory_Size=" + respiratory_Size +
                ", respiratory_LengthAtTeeth=" + respiratory_LengthAtTeeth +
                ", respiratory_LengthAtGums=" + respiratory_LengthAtGums +
                ", respiratory_CuffPressure=" + respiratory_CuffPressure +
                ", respiratory_TracheostomySize=" + respiratory_TracheostomySize +
                ", respiratory_OralMucosa_intact=" + respiratory_OralMucosa_intact +
                ", respiratory_OralMucosa_other=" + respiratory_OralMucosa_other +
                ", respiratory_LipCondition_intact=" + respiratory_LipCondition_intact +
                ", respiratory_LipCondition_other=" + respiratory_LipCondition_other +
                ", respiratory_Cough_Spontaneous=" + respiratory_Cough_Spontaneous +
                ", respiratory_Cough_SimulatedBySuctioning=" + respiratory_Cough_SimulatedBySuctioning +
                ", respiratory_Cough='" + respiratory_Cough + '\'' +
                ", respiratory_Respirations='" + respiratory_Respirations + '\'' +
                ", respiratory_ChestExpansion='" + respiratory_ChestExpansion + '\'' +
                ", respiratory_Trechea='" + respiratory_Trechea + '\'' +
                ", respiratory_OtherDescription='" + respiratory_OtherDescription + '\'' +
                ", respiratory_Clear=" + respiratory_Clear +
                ", respiratory_Decreased=" + respiratory_Decreased +
                ", respiratory_Wheezes=" + respiratory_Wheezes +
                ", respiratory_FineCreps=" + respiratory_FineCreps +
                ", respiratory_AbsentBreath=" + respiratory_AbsentBreath +
                ", respiratory_Bronchial=" + respiratory_Bronchial +
                ", respiratory_Inspiratory=" + respiratory_Inspiratory +
                ", respiratory_Expiratory=" + respiratory_Expiratory +
                ", cardio_ECG_Lead=" + cardio_ECG_Lead +
                ", cardio_ECG_Rate=" + cardio_ECG_Rate +
                ", cardio_ECG_PR=" + cardio_ECG_PR +
                ", cardio_ECG_QRS=" + cardio_ECG_QRS +
                ", cardio_ECG_QT=" + cardio_ECG_QT +
                ", cardio_ECG_STSegment=" + cardio_ECG_STSegment +
                ", cardio_ECG_Wave=" + cardio_ECG_Wave +
                ", cardio_ECG_Interpretation='" + cardio_ECG_Interpretation + '\'' +
                ", cardio_Skin_Pink=" + cardio_Skin_Pink +
                ", cardio_Skin_Pale=" + cardio_Skin_Pale +
                ", cardio_Skin_Jaundiced=" + cardio_Skin_Jaundiced +
                ", cardio_Skin_Flushed=" + cardio_Skin_Flushed +
                ", cardio_Skin_Mottled=" + cardio_Skin_Mottled +
                ", cardio_Skin_Cyanotic=" + cardio_Skin_Cyanotic +
                ", cardio_Skin_Diaphoretic=" + cardio_Skin_Diaphoretic +
                ", cardio_Skin_Cold=" + cardio_Skin_Cold +
                ", cardio_Skin_Cool=" + cardio_Skin_Cool +
                ", cardio_Skin_Hot=" + cardio_Skin_Hot +
                ", cardio_Skin_Warm=" + cardio_Skin_Warm +
                ", cardio_Skin_Dry=" + cardio_Skin_Dry +
                ", cardio_Skin_Moist=" + cardio_Skin_Moist +
                ", cardio_Oedema_Generalised=" + cardio_Oedema_Generalised +
                ", cardio_Oedema_LocalisedTo='" + cardio_Oedema_LocalisedTo + '\'' +
                ", gastro_Adomen_Soft=" + gastro_Adomen_Soft +
                ", gastro_Adomen_Firm=" + gastro_Adomen_Firm +
                ", gastro_Adomen_Flat=" + gastro_Adomen_Flat +
                ", gastro_Adomen_Rounded=" + gastro_Adomen_Rounded +
                ", gastro_Adomen_Obese=" + gastro_Adomen_Obese +
                ", gastro_Adomen_Distended=" + gastro_Adomen_Distended +
                ", gastro_Adomen_Guarding=" + gastro_Adomen_Guarding +
                ", gastro_Adomen_ReboundTenderness=" + gastro_Adomen_ReboundTenderness +
                ", gastro_BowlSounds='" + gastro_BowlSounds + '\'' +
                ", gastro_BowlSounds_Abs=" + gastro_BowlSounds_Abs +
                ", gastro_BowlSounds_Pres=" + gastro_BowlSounds_Pres +
                ", gastro_BowlSounds_Normal=" + gastro_BowlSounds_Normal +
                ", gastro_BowlSounds_Increased=" + gastro_BowlSounds_Increased +
                ", gastro_BowlSounds_Decreased=" + gastro_BowlSounds_Decreased +
                ", gastro_Diet_NBM=" + gastro_Diet_NBM +
                ", gastro_Diet_CF=" + gastro_Diet_CF +
                ", gastro_Diet_FF=" + gastro_Diet_FF +
                ", gastro_Diet=" + gastro_Diet +
                ", gastro_Diet_Diabetic=" + gastro_Diet_Diabetic +
                ", gastro_Diet_Cardiac=" + gastro_Diet_Cardiac +
                ", gastro_Diet_Tube_Feeds=" + gastro_Diet_Tube_Feeds +
                ", gastro_Diet_Other=" + gastro_Diet_Other +
                ", gastro_Diet_Special_Con=" + gastro_Diet_Special_Con +
                ", gastro_Diet_Speical_String='" + gastro_Diet_Speical_String + '\'' +
                ", gastro_FeedingTube_Type='" + gastro_FeedingTube_Type + '\'' +
                ", gastro_FeedingTube_insituTo='" + gastro_FeedingTube_insituTo + '\'' +
                ", gastro_FeedingTube_Gastric=" + gastro_FeedingTube_Gastric +
                ", gastro_FeedingTube_Duodenel=" + gastro_FeedingTube_Duodenel +
                ", gastro_FeedingTube_Jeunal=" + gastro_FeedingTube_Jeunal +
                ", gastro_FeedingTube_Intact=" + gastro_FeedingTube_Intact +
                ", gastro_FeedingTube_Other=" + gastro_FeedingTube_Other +
                ", isgastro_FeedingTube_Verified=" + isgastro_FeedingTube_Verified +
                ", gastro_PlacementVerifiedBy='" + gastro_PlacementVerifiedBy + '\'' +
                ", gastro_AdministeringFeeds=" + gastro_AdministeringFeeds +
                ", gastro_Clamped=" + gastro_Clamped +
                ", gastro_Aspirated=" + gastro_Aspirated +
                ", gastro_StraightDrainage=" + gastro_StraightDrainage +
                ", gastro_DescriptionOfAspirate='" + gastro_DescriptionOfAspirate + '\'' +
                ", gastro_OtherDescription='" + gastro_OtherDescription + '\'' +
                ", gastro_LeastBM1=" + gastro_LeastBM1 +
                ", gastro_LeastBM2=" + gastro_LeastBM2 +
                ", gastro_PriorToAdmission=" + gastro_PriorToAdmission +
                ", gastro_StoolColour='" + gastro_StoolColour + '\'' +
                ", gastro_Stoolcharacteristic='" + gastro_Stoolcharacteristic + '\'' +
                ", isgastor_Ostomy_Type=" + isgastor_Ostomy_Type +
                ", gastro_Ostomy_Type='" + gastro_Ostomy_Type + '\'' +
                ", gastro_AbdominalDrain_Type='" + gastro_AbdominalDrain_Type + '\'' +
                ", isgastro_AbdominalDrain_Type=" + isgastro_AbdominalDrain_Type +
                ", gastro_AppearanceOfStoma='" + gastro_AppearanceOfStoma + '\'' +
                ", gastro_Location='" + gastro_Location + '\'' +
                ", gastro_DrainageDescribe='" + gastro_DrainageDescribe + '\'' +
                ", IsGenitourinary_Catheter_Type=" + IsGenitourinary_Catheter_Type +
                ", Genitourinary_Catheter_Type='" + Genitourinary_Catheter_Type + '\'' +
                ", Genitourinary_Catheter_Size=" + Genitourinary_Catheter_Size +
                ", IsGenitourinary_Discharge=" + IsGenitourinary_Discharge +
                ", Genitourinary_Catheter_UrineDescribe='" + Genitourinary_Catheter_UrineDescribe + '\'' +
                ", Genitourinary_Catheter_Discharge=" + Genitourinary_Catheter_Discharge +
                ", Genitourinary_Catheter_Describe='" + Genitourinary_Catheter_Describe + '\'' +
                ", Genitourinary_Catheter_Menstruating=" + Genitourinary_Catheter_Menstruating +
                ", physical_SkinCondition='" + physical_SkinCondition + '\'' +
                ", physical_Sacrum_Intact=" + physical_Sacrum_Intact +
                ", physical_Sacrum_Marked=" + physical_Sacrum_Marked +
                ", physical_Sacrum_broken=" + physical_Sacrum_broken +
                ", physical_Heels_Intact_L=" + physical_Heels_Intact_L +
                ", physical_Heels_Intact_R=" + physical_Heels_Intact_R +
                ", physical_Heels_Marked_L=" + physical_Heels_Marked_L +
                ", physical_Heels_Marked_R=" + physical_Heels_Marked_R +
                ", physical_Heels_Broken_L=" + physical_Heels_Broken_L +
                ", physical_Heels_Broken_R=" + physical_Heels_Broken_R +
                ", physical_Elbows_Elbows_L=" + physical_Elbows_Elbows_L +
                ", physical_Elbows_Elbows_R=" + physical_Elbows_Elbows_R +
                ", physical_Elbows_Marked_L=" + physical_Elbows_Marked_L +
                ", physical_Elbows_Marked_R=" + physical_Elbows_Marked_R +
                ", physical_Elbows_Broken_L=" + physical_Elbows_Broken_L +
                ", physical_Elbows_Broken_R=" + physical_Elbows_Broken_R +
                ", physical_PatientToBePositioned_30_45_DegreesHeadUp=" + physical_PatientToBePositioned_30_45_DegreesHeadUp +
                ", physical_CalfCompressor=" + physical_CalfCompressor +
                ", physical_TEDS=" + physical_TEDS +
                ", patientFile=" + patientFile +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return getId();
    }

    @Override
    protected String getPath() {
        return "/patientassessments/";
    }


    public static PatientAssessment fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (PatientAssessment) new PatientAssessment().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        PatientAssessment pa = new PatientAssessment();

        try {
            if (jsonObject.has("id"))
                pa.id = jsonObject.getLong("id");

            pa.status= jsonObject.getString("status");
            pa.neurological_Vision_Eye = jsonObject.getString("neurological_Vision_Eye");
            pa.neurological_Vision_Pupils_L = jsonObject.getString("neurological_Vision_Pupils_L");
            pa.neurological_Vision_Pupils_R = jsonObject.getString("neurological_Vision_Pupils_R");
            pa.neurological_Verbal_Speech = jsonObject.getString("neurological_Verbal_Speech");
            pa.neurological_Verbal_GAG_Reflex = jsonObject.getString("neurological_Verbal_GAG_Reflex");
            pa.neurological_Motor_Reaction_L = jsonObject.getString("neurological_Motor_Reaction_L");
            pa.neurological_Motor_Reaction_R = jsonObject.getString("neurological_Motor_Reaction_R");
            pa.neurological_Motor_Restraints = jsonObject.getString("neurological_Motor_Restraints");
            pa.neurological_Pain_Level = jsonObject.getString("neurological_Pain_Level");
            pa.neurological_Pain_Description = jsonObject.getString("neurological_Pain_Description");
            pa.neurological_Mental_Description = jsonObject.getString("neurological_Mental_Description");
            pa.respiratory_Airway_Maintains_Own = jsonObject.getBoolean("respiratory_Airway_Maintains_Own");
            pa.respiratory_Airway_BIPAP_CPAP = jsonObject.getBoolean("respiratory_Airway_BIPAP_CPAP");
            pa.respiratory_ETT = jsonObject.getBoolean("respiratory_ETT");
            pa.respiratory_Size = (float) jsonObject.getDouble("respiratory_Size");
            pa.respiratory_LengthAtTeeth = (float) jsonObject.getDouble("respiratory_LengthAtTeeth");
            pa.respiratory_LengthAtGums = (float) jsonObject.getDouble("respiratory_LengthAtGums");
            pa.respiratory_CuffPressure = (float) jsonObject.getDouble("respiratory_CuffPressure");
            pa.respiratory_TracheostomySize = (float) jsonObject.getDouble("respiratory_TracheostomySize");
            pa.respiratory_OralMucosa_intact = jsonObject.getBoolean("respiratory_OralMucosa_intact");
            pa.respiratory_OralMucosa_other = jsonObject.getBoolean("respiratory_OralMucosa_other");
            pa.respiratory_LipCondition_intact = jsonObject.getBoolean("respiratory_LipCondition_intact");
            pa.respiratory_LipCondition_other = jsonObject.getBoolean("respiratory_LipCondition_other");
            pa.respiratory_Cough_Spontaneous = jsonObject.getBoolean("respiratory_Cough_Spontaneous");
            pa.respiratory_Cough_SimulatedBySuctioning = jsonObject.getBoolean("respiratory_Cough_SimulatedBySuctioning");
            pa.respiratory_Cough = jsonObject.getString("respiratory_Cough");
            pa.respiratory_Respirations = jsonObject.getString("respiratory_Respirations");
            pa.respiratory_ChestExpansion = jsonObject.getString("respiratory_ChestExpansion");
            pa.respiratory_Trechea = jsonObject.getString("respiratory_Trechea");
            pa.respiratory_OtherDescription = jsonObject.getString("respiratory_OtherDescription");
            pa.respiratory_Clear = jsonObject.getBoolean("respiratory_Clear");
            pa.respiratory_Decreased = jsonObject.getBoolean("respiratory_Decreased");
            pa.respiratory_Wheezes = jsonObject.getBoolean("respiratory_Wheezes");
            pa.respiratory_FineCreps = jsonObject.getBoolean("respiratory_FineCreps");
            pa.respiratory_AbsentBreath = jsonObject.getBoolean("respiratory_AbsentBreath");
            pa.respiratory_Bronchial = jsonObject.getBoolean("respiratory_Bronchial");
            pa.respiratory_Inspiratory = jsonObject.getBoolean("respiratory_Inspiratory");
            pa.respiratory_Expiratory = jsonObject.getBoolean("respiratory_Expiratory");

            pa.cardio_ECG_Lead = jsonObject.getInt("cardio_ECG_Lead");
            pa.cardio_ECG_Rate = (float) jsonObject.getDouble("cardio_ECG_Rate");
            pa.cardio_ECG_PR = (float) jsonObject.getDouble("cardio_ECG_PR");
            pa.cardio_ECG_QRS = jsonObject.getInt("cardio_ECG_QRS");
            pa.cardio_ECG_QT = jsonObject.getInt("cardio_ECG_QT");
            pa.cardio_ECG_STSegment = jsonObject.getInt("cardio_ECG_STSegment");
            pa.cardio_ECG_Wave = jsonObject.getInt("cardio_ECG_Wave");
            pa.cardio_ECG_Interpretation = jsonObject.getString("cardio_ECG_Interpretation");

            pa.cardio_Skin_Pink = jsonObject.getBoolean("cardio_Skin_Pink");
            pa.cardio_Skin_Pale = jsonObject.getBoolean("cardio_Skin_Pale");
            pa.cardio_Skin_Jaundiced = jsonObject.getBoolean("cardio_Skin_Jaundiced");
            pa.cardio_Skin_Flushed = jsonObject.getBoolean("cardio_Skin_Flushed");
            pa.cardio_Skin_Mottled = jsonObject.getBoolean("cardio_Skin_Mottled");
            pa.cardio_Skin_Cyanotic = jsonObject.getBoolean("cardio_Skin_Cyanotic");
            pa.cardio_Skin_Diaphoretic = jsonObject.getBoolean("cardio_Skin_Diaphoretic");
            pa.cardio_Skin_Cold = jsonObject.getBoolean("cardio_Skin_Cold");
            pa.cardio_Skin_Cool = jsonObject.getBoolean("cardio_Skin_Cool");
            pa.cardio_Skin_Hot = jsonObject.getBoolean("cardio_Skin_Hot");
            pa.cardio_Skin_Warm = jsonObject.getBoolean("cardio_Skin_Warm");
            pa.cardio_Skin_Dry = jsonObject.getBoolean("cardio_Skin_Dry");
            pa.cardio_Skin_Moist = jsonObject.getBoolean("cardio_Skin_Moist");
            pa.cardio_Oedema_Generalised = jsonObject.getBoolean("cardio_Oedema_Generalised");
            pa.cardio_Oedema_LocalisedTo = jsonObject.getString("cardio_Oedema_LocalisedTo");

            pa.gastro_Adomen_Soft = jsonObject.getBoolean("gastro_Adomen_Soft");
            pa.gastro_Adomen_Firm = jsonObject.getBoolean("gastro_Adomen_Firm");
            pa.gastro_Adomen_Flat = jsonObject.getBoolean("gastro_Adomen_Flat");
            pa.gastro_Adomen_Rounded = jsonObject.getBoolean("gastro_Adomen_Rounded");
            pa.gastro_Adomen_Obese = jsonObject.getBoolean("gastro_Adomen_Obese");
            pa.gastro_Adomen_Distended = jsonObject.getBoolean("gastro_Adomen_Distended");
            pa.gastro_Adomen_Guarding = jsonObject.getBoolean("gastro_Adomen_Guarding");
            pa.gastro_Adomen_ReboundTenderness = jsonObject.getBoolean("gastro_Adomen_ReboundTenderness");
            pa.gastro_BowlSounds = jsonObject.getString("gastro_BowlSounds");
            pa.gastro_BowlSounds_Abs = jsonObject.getBoolean("gastro_BowlSounds_Abs");
            pa.gastro_BowlSounds_Pres = jsonObject.getBoolean("gastro_BowlSounds_Pres");
            pa.gastro_BowlSounds_Normal = jsonObject.getBoolean("gastro_BowlSounds_Normal");
            pa.gastro_BowlSounds_Increased = jsonObject.getBoolean("gastro_BowlSounds_Increased");
            pa.gastro_BowlSounds_Decreased = jsonObject.getBoolean("gastro_BowlSounds_Decreased");
            pa.gastro_Diet_NBM = jsonObject.getBoolean("gastro_Diet_NBM");
            pa.gastro_Diet_CF = jsonObject.getBoolean("gastro_Diet_CF");
            pa.gastro_Diet_FF = jsonObject.getBoolean("gastro_Diet_FF");
            pa.gastro_Diet = jsonObject.getBoolean("gastro_Diet");
            pa.gastro_Diet_Diabetic = jsonObject.getBoolean("gastro_Diet_Diabetic");
            pa.gastro_Diet_Cardiac = jsonObject.getBoolean("gastro_Diet_Cardiac");
            pa.gastro_Diet_Tube_Feeds = jsonObject.getBoolean("gastro_Diet_Tube_Feeds");
            pa.gastro_Diet_Other = jsonObject.getBoolean("gastro_Diet_Other");
            pa.gastro_Diet_Special_Con = jsonObject.getBoolean("gastro_Diet_Special_Con");
            pa.gastro_Diet_Speical_String = jsonObject.getString("gastro_Diet_Speical_String");
            pa.gastro_FeedingTube_Type = jsonObject.getString("gastro_FeedingTube_Type");
            pa.gastro_FeedingTube_insituTo = jsonObject.getString("gastro_FeedingTube_insituTo");
            pa.gastro_FeedingTube_Gastric = jsonObject.getBoolean("gastro_FeedingTube_Gastric");
            pa.gastro_FeedingTube_Duodenel = jsonObject.getBoolean("gastro_FeedingTube_Duodenel");
            pa.gastro_FeedingTube_Jeunal = jsonObject.getBoolean("gastro_FeedingTube_Jeunal");
            pa.gastro_FeedingTube_Intact = jsonObject.getBoolean("gastro_FeedingTube_Intact");
            pa.gastro_FeedingTube_Other = jsonObject.getBoolean("gastro_FeedingTube_Other");
            pa.isgastro_FeedingTube_Verified = jsonObject.getBoolean("isgastro_FeedingTube_Verified");
            pa.gastro_PlacementVerifiedBy = jsonObject.getString("gastro_PlacementVerifiedBy");
            pa.gastro_AdministeringFeeds = jsonObject.getBoolean("gastro_AdministeringFeeds");
            pa.gastro_Clamped = jsonObject.getBoolean("gastro_Clamped");
            pa.gastro_Aspirated = jsonObject.getBoolean("gastro_Aspirated");
            pa.gastro_StraightDrainage = jsonObject.getBoolean("gastro_StraightDrainage");
            pa.gastro_DescriptionOfAspirate = jsonObject.getString("gastro_DescriptionOfAspirate");
            pa.gastro_OtherDescription = jsonObject.getString("gastro_OtherDescription");
            pa.gastro_LeastBM1 = jsonObject.getInt("gastro_LeastBM1");
            pa.gastro_LeastBM2 = jsonObject.getInt("gastro_LeastBM2");
            pa.gastro_PriorToAdmission = jsonObject.getBoolean("gastro_PriorToAdmission");
            pa.gastro_StoolColour = jsonObject.getString("gastro_StoolColour");
            pa.gastro_Stoolcharacteristic = jsonObject.getString("gastro_Stoolcharacteristic");
            pa.isgastor_Ostomy_Type = jsonObject.getBoolean("isgastor_Ostomy_Type");
            pa.gastro_Ostomy_Type = jsonObject.getString("gastro_Ostomy_Type");
            pa.gastro_AbdominalDrain_Type = jsonObject.getString("gastro_AbdominalDrain_Type");
            pa.isgastro_AbdominalDrain_Type = jsonObject.getBoolean("isgastro_AbdominalDrain_Type");
            pa.gastro_AppearanceOfStoma = jsonObject.getString("gastro_AppearanceOfStoma");
            pa.gastro_Location = jsonObject.getString("gastro_Location");
            pa.gastro_DrainageDescribe = jsonObject.getString("gastro_DrainageDescribe");

            // Genitourinary
            pa.IsGenitourinary_Catheter_Type = jsonObject.getBoolean("IsGenitourinary_Catheter_Type");
            pa.Genitourinary_Catheter_Type = jsonObject.getString("Genitourinary_Catheter_Type");
            pa.Genitourinary_Catheter_Size = (float) jsonObject.getDouble("Genitourinary_Catheter_Size");
            pa.IsGenitourinary_Discharge = jsonObject.getBoolean("IsGenitourinary_Discharge");
            pa.Genitourinary_Catheter_UrineDescribe = jsonObject.getString("Genitourinary_Catheter_UrineDescribe");
            pa.Genitourinary_Catheter_Discharge = jsonObject.getBoolean("Genitourinary_Catheter_Discharge");
            pa.Genitourinary_Catheter_Describe = jsonObject.getString("Genitourinary_Catheter_Describe");
            pa.Genitourinary_Catheter_Menstruating = jsonObject.getBoolean("Genitourinary_Catheter_Menstruating");

            // Physical
            pa.physical_SkinCondition = jsonObject.getString("physical_SkinCondition");
            pa.physical_Sacrum_Intact = jsonObject.getBoolean("physical_Sacrum_Intact");
            pa.physical_Sacrum_Marked = jsonObject.getBoolean("physical_Sacrum_Marked");
            pa.physical_Sacrum_broken = jsonObject.getBoolean("physical_Sacrum_broken");
            pa.physical_Heels_Intact_L = jsonObject.getBoolean("physical_Heels_Intact_L");
            pa.physical_Heels_Intact_R = jsonObject.getBoolean("physical_Heels_Intact_R");
            pa.physical_Heels_Marked_L = jsonObject.getBoolean("physical_Heels_Marked_L");
            pa.physical_Heels_Marked_R = jsonObject.getBoolean("physical_Heels_Marked_R");
            pa.physical_Heels_Broken_L = jsonObject.getBoolean("physical_Heels_Broken_L");
            pa.physical_Heels_Broken_R = jsonObject.getBoolean("physical_Heels_Broken_R");
            pa.physical_Elbows_Elbows_L = jsonObject.getBoolean("physical_Elbows_Elbows_L");
            pa.physical_Elbows_Elbows_R = jsonObject.getBoolean("physical_Elbows_Elbows_R");
            pa.physical_Elbows_Marked_L = jsonObject.getBoolean("physical_Elbows_Marked_L");
            pa.physical_Elbows_Marked_R = jsonObject.getBoolean("physical_Elbows_Marked_R");
            pa.physical_Elbows_Broken_L = jsonObject.getBoolean("physical_Elbows_Broken_L");
            pa.physical_Elbows_Broken_R = jsonObject.getBoolean("physical_Elbows_Broken_R");
            pa.physical_PatientToBePositioned_30_45_DegreesHeadUp = jsonObject.getBoolean("physical_PatientToBePositioned_30_45_DegreesHeadUp");
            pa.physical_CalfCompressor = jsonObject.getBoolean("physical_CalfCompressor");
            pa.physical_TEDS = jsonObject.getBoolean("physical_TEDS");


            if (jsonObject.has("patientFile"))
                pa.patientFile = Patient.fromJson(jsonObject.getString("patientFile"));

            if (jsonObject.has("version"))
                pa.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pa;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("status", this.status);
            jsonObject.put("neurological_Vision_Eye", this.neurological_Vision_Eye);
            jsonObject.put("neurological_Vision_Pupils_L", this.neurological_Vision_Pupils_L);
            jsonObject.put("neurological_Vision_Pupils_R", this.neurological_Vision_Pupils_R);
            jsonObject.put("neurological_Verbal_Speech", this.neurological_Verbal_Speech);
            jsonObject.put("neurological_Verbal_GAG_Reflex", this.neurological_Verbal_GAG_Reflex);
            jsonObject.put("neurological_Motor_Reaction_L", this.neurological_Motor_Reaction_L);
            jsonObject.put("neurological_Motor_Reaction_R", this.neurological_Motor_Reaction_R);
            jsonObject.put("neurological_Motor_Restraints", this.neurological_Motor_Restraints);
            jsonObject.put("neurological_Pain_Level", this.neurological_Pain_Level);
            jsonObject.put("neurological_Pain_Description", this.neurological_Pain_Description);
            jsonObject.put("neurological_Mental_Description", this.neurological_Mental_Description);
            jsonObject.put("respiratory_Airway_Maintains_Own", this.respiratory_Airway_Maintains_Own);
            jsonObject.put("respiratory_Airway_BIPAP_CPAP", this.respiratory_Airway_BIPAP_CPAP);
            jsonObject.put("respiratory_ETT", this.respiratory_ETT);
            jsonObject.put("respiratory_Size", this.respiratory_Size);
            jsonObject.put("respiratory_LengthAtTeeth", this.respiratory_LengthAtTeeth);
            jsonObject.put("respiratory_LengthAtGums", this.respiratory_LengthAtGums);
            jsonObject.put("respiratory_CuffPressure", this.respiratory_CuffPressure);
            jsonObject.put("respiratory_TracheostomySize", this.respiratory_TracheostomySize);
            jsonObject.put("respiratory_OralMucosa_intact", this.respiratory_OralMucosa_intact);
            jsonObject.put("respiratory_OralMucosa_other", this.respiratory_OralMucosa_other);
            jsonObject.put("respiratory_LipCondition_intact", this.respiratory_LipCondition_intact);
            jsonObject.put("respiratory_LipCondition_other", this.respiratory_LipCondition_other);
            jsonObject.put("respiratory_Cough_Spontaneous", this.respiratory_Cough_Spontaneous);
            jsonObject.put("respiratory_Cough_SimulatedBySuctioning", this.respiratory_Cough_SimulatedBySuctioning);
            jsonObject.put("respiratory_Cough", this.respiratory_Cough);
            jsonObject.put("respiratory_Respirations", this.respiratory_Respirations);
            jsonObject.put("respiratory_ChestExpansion", this.respiratory_ChestExpansion);
            jsonObject.put("respiratory_Trechea", this.respiratory_Trechea);
            jsonObject.put("respiratory_OtherDescription", this.respiratory_OtherDescription);
            jsonObject.put("respiratory_Clear", this.respiratory_Clear);
            jsonObject.put("respiratory_Decreased", this.respiratory_Decreased);
            jsonObject.put("respiratory_Wheezes", this.respiratory_Wheezes);
            jsonObject.put("respiratory_FineCreps", this.respiratory_FineCreps);
            jsonObject.put("respiratory_AbsentBreath", this.respiratory_AbsentBreath);
            jsonObject.put("respiratory_Bronchial", this.respiratory_Bronchial);
            jsonObject.put("respiratory_Inspiratory", this.respiratory_Inspiratory);
            jsonObject.put("respiratory_Expiratory", this.respiratory_Expiratory);

            jsonObject.put("cardio_ECG_Lead", this.cardio_ECG_Lead);
            jsonObject.put("cardio_ECG_Rate", this.cardio_ECG_Rate);
            jsonObject.put("cardio_ECG_PR", this.cardio_ECG_PR);
            jsonObject.put("cardio_ECG_QRS", this.cardio_ECG_QRS);
            jsonObject.put("cardio_ECG_QT", this.cardio_ECG_QT);
            jsonObject.put("cardio_ECG_STSegment", this.cardio_ECG_STSegment);
            jsonObject.put("cardio_ECG_Wave", this.cardio_ECG_Wave);
            jsonObject.put("cardio_ECG_Interpretation", this.cardio_ECG_Interpretation);

            jsonObject.put("cardio_Skin_Pink", this.cardio_Skin_Pink);
            jsonObject.put("cardio_Skin_Pale", this.cardio_Skin_Pale);
            jsonObject.put("cardio_Skin_Jaundiced", this.cardio_Skin_Jaundiced);
            jsonObject.put("cardio_Skin_Flushed", this.cardio_Skin_Flushed);
            jsonObject.put("cardio_Skin_Mottled", this.cardio_Skin_Mottled);
            jsonObject.put("cardio_Skin_Cyanotic", this.cardio_Skin_Cyanotic);
            jsonObject.put("cardio_Skin_Diaphoretic", this.cardio_Skin_Diaphoretic);
            jsonObject.put("cardio_Skin_Cold", this.cardio_Skin_Cold);
            jsonObject.put("cardio_Skin_Cool", this.cardio_Skin_Cool);
            jsonObject.put("cardio_Skin_Hot", this.cardio_Skin_Hot);
            jsonObject.put("cardio_Skin_Warm", this.cardio_Skin_Warm);
            jsonObject.put("cardio_Skin_Dry", this.cardio_Skin_Dry);
            jsonObject.put("cardio_Skin_Moist", this.cardio_Skin_Moist);
            jsonObject.put("cardio_Oedema_Generalised", this.cardio_Oedema_Generalised);
            jsonObject.put("cardio_Oedema_LocalisedTo", this.cardio_Oedema_LocalisedTo);

            jsonObject.put("gastro_Adomen_Soft", this.gastro_Adomen_Soft);
            jsonObject.put("gastro_Adomen_Firm", this.gastro_Adomen_Firm);
            jsonObject.put("gastro_Adomen_Flat", this.gastro_Adomen_Flat);
            jsonObject.put("gastro_Adomen_Rounded", this.gastro_Adomen_Rounded);
            jsonObject.put("gastro_Adomen_Obese", this.gastro_Adomen_Obese);
            jsonObject.put("gastro_Adomen_Distended", this.gastro_Adomen_Distended);
            jsonObject.put("gastro_Adomen_Guarding", this.gastro_Adomen_Guarding);
            jsonObject.put("gastro_Adomen_ReboundTenderness", this.gastro_Adomen_ReboundTenderness);
            jsonObject.put("gastro_BowlSounds", this.gastro_BowlSounds);
            jsonObject.put("gastro_BowlSounds_Abs", this.gastro_BowlSounds_Abs);
            jsonObject.put("gastro_BowlSounds_Pres", this.gastro_BowlSounds_Pres);
            jsonObject.put("gastro_BowlSounds_Normal", this.gastro_BowlSounds_Normal);
            jsonObject.put("gastro_BowlSounds_Increased", this.gastro_BowlSounds_Increased);
            jsonObject.put("gastro_BowlSounds_Decreased", this.gastro_BowlSounds_Decreased);
            jsonObject.put("gastro_Diet_NBM", this.gastro_Diet_NBM);
            jsonObject.put("gastro_Diet_CF", this.gastro_Diet_CF);
            jsonObject.put("gastro_Diet_FF", this.gastro_Diet_FF);
            jsonObject.put("gastro_Diet", this.gastro_Diet);
            jsonObject.put("gastro_Diet_Diabetic", this.gastro_Diet_Diabetic);
            jsonObject.put("gastro_Diet_Cardiac", this.gastro_Diet_Cardiac);
            jsonObject.put("gastro_Diet_Tube_Feeds", this.gastro_Diet_Tube_Feeds);
            jsonObject.put("gastro_Diet_Other", this.gastro_Diet_Other);
            jsonObject.put("gastro_Diet_Special_Con", this.gastro_Diet_Special_Con);
            jsonObject.put("gastro_Diet_Speical_String", this.gastro_Diet_Speical_String);
            jsonObject.put("gastro_FeedingTube_Type", this.gastro_FeedingTube_Type);
            jsonObject.put("gastro_FeedingTube_insituTo", this.gastro_FeedingTube_insituTo);
            jsonObject.put("gastro_FeedingTube_Gastric", this.gastro_FeedingTube_Gastric);
            jsonObject.put("gastro_FeedingTube_Duodenel", this.gastro_FeedingTube_Duodenel);
            jsonObject.put("gastro_FeedingTube_Jeunal", this.gastro_FeedingTube_Jeunal);
            jsonObject.put("gastro_FeedingTube_Intact", this.gastro_FeedingTube_Intact);
            jsonObject.put("gastro_FeedingTube_Other", this.gastro_FeedingTube_Other);
            jsonObject.put("isgastro_FeedingTube_Verified", this.isgastro_FeedingTube_Verified);
            jsonObject.put("gastro_PlacementVerifiedBy", this.gastro_PlacementVerifiedBy);
            jsonObject.put("gastro_AdministeringFeeds", this.gastro_AdministeringFeeds);
            jsonObject.put("gastro_Clamped", this.gastro_Clamped);
            jsonObject.put("gastro_Aspirated", this.gastro_Aspirated);
            jsonObject.put("gastro_StraightDrainage", this.gastro_StraightDrainage);
            jsonObject.put("gastro_DescriptionOfAspirate", this.gastro_DescriptionOfAspirate);
            jsonObject.put("gastro_OtherDescription", this.gastro_OtherDescription);
            jsonObject.put("gastro_LeastBM1", this.gastro_LeastBM1);
            jsonObject.put("gastro_LeastBM2", this.gastro_LeastBM2);
            jsonObject.put("gastro_PriorToAdmission", this.gastro_PriorToAdmission);
            jsonObject.put("gastro_StoolColour", this.gastro_StoolColour);
            jsonObject.put("gastro_Stoolcharacteristic", this.gastro_Stoolcharacteristic);
            jsonObject.put("isgastor_Ostomy_Type", this.isgastor_Ostomy_Type);
            jsonObject.put("gastro_Ostomy_Type", this.gastro_Ostomy_Type);
            jsonObject.put("gastro_AbdominalDrain_Type", this.gastro_AbdominalDrain_Type);
            jsonObject.put("isgastro_AbdominalDrain_Type", this.isgastro_AbdominalDrain_Type);
            jsonObject.put("gastro_AppearanceOfStoma", this.gastro_AppearanceOfStoma);
            jsonObject.put("gastro_Location", this.gastro_Location);
            jsonObject.put("gastro_DrainageDescribe", this.gastro_DrainageDescribe);

            // Genitourinary
            jsonObject.put("IsGenitourinary_Catheter_Type", this.IsGenitourinary_Catheter_Type);
            jsonObject.put("Genitourinary_Catheter_Type", this.Genitourinary_Catheter_Type);
            jsonObject.put("Genitourinary_Catheter_Size", this.Genitourinary_Catheter_Size);
            jsonObject.put("IsGenitourinary_Discharge", this.IsGenitourinary_Discharge);
            jsonObject.put("Genitourinary_Catheter_UrineDescribe", this.Genitourinary_Catheter_UrineDescribe);
            jsonObject.put("Genitourinary_Catheter_Discharge", this.Genitourinary_Catheter_Discharge);
            jsonObject.put("Genitourinary_Catheter_Describe", this.Genitourinary_Catheter_Describe);
            jsonObject.put("Genitourinary_Catheter_Menstruating", this.Genitourinary_Catheter_Menstruating);

            // Physical
            jsonObject.put("physical_SkinCondition", this.physical_SkinCondition);
            jsonObject.put("physical_Sacrum_Intact", this.physical_Sacrum_Intact);
            jsonObject.put("physical_Sacrum_Marked", this.physical_Sacrum_Marked);
            jsonObject.put("physical_Sacrum_broken", this.physical_Sacrum_broken);
            jsonObject.put("physical_Heels_Intact_L", this.physical_Heels_Intact_L);
            jsonObject.put("physical_Heels_Intact_R", this.physical_Heels_Intact_R);
            jsonObject.put("physical_Heels_Marked_L", this.physical_Heels_Marked_L);
            jsonObject.put("physical_Heels_Marked_R", this.physical_Heels_Marked_R);
            jsonObject.put("physical_Heels_Broken_L", this.physical_Heels_Broken_L);
            jsonObject.put("physical_Heels_Broken_R", this.physical_Heels_Broken_R);
            jsonObject.put("physical_Elbows_Elbows_L", this.physical_Elbows_Elbows_L);
            jsonObject.put("physical_Elbows_Elbows_R", this.physical_Elbows_Elbows_R);
            jsonObject.put("physical_Elbows_Marked_L", this.physical_Elbows_Marked_L);
            jsonObject.put("physical_Elbows_Marked_R", this.physical_Elbows_Marked_R);
            jsonObject.put("physical_Elbows_Broken_L", this.physical_Elbows_Broken_L);
            jsonObject.put("physical_Elbows_Broken_R", this.physical_Elbows_Broken_R);
            jsonObject.put("physical_PatientToBePositioned_30_45_DegreesHeadUp", this.physical_PatientToBePositioned_30_45_DegreesHeadUp);
            jsonObject.put("physical_CalfCompressor", this.physical_CalfCompressor);
            jsonObject.put("physical_TEDS", this.physical_TEDS);

            if (id != null)
                jsonObject.put("id", this.id);


            if (patientFile != null)
                jsonObject.put("patientFile", new JSONObject(patientFile.toJson(true)));

            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static PatientAssessment findById(Long id) {
        return (PatientAssessment) new PatientAssessment().superFindById(id);
    }


    public static List<PatientAssessment> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new PatientAssessment().superFindAll();
        List<PatientAssessment> patientAssessments = new ArrayList<PatientAssessment>();

        for (AbstractJsonModel jm : abstractJsonModels)
            patientAssessments.add((PatientAssessment) jm);

        return patientAssessments;
    }

}
