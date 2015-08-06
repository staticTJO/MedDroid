package com.example.staticmsi.meddroid.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-27.
 */
public class ReportEntry extends AbstractJsonModel {

    private Long id = null;
    private float bodyTemperature;
    private int heartRate;
    private int respitory;
    private int bloodPressureSystolic;
    private int bloodPressureDiastolic;
    private PatientReport report;
    private Nurse nurse;
    private int painLevel;
    private String other;
    private Long version = 0L;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public float getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getRespitory() {
        return respitory;
    }

    public void setRespitory(int respitory) {
        this.respitory = respitory;
    }

    public int getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(int bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public int getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(int bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public PatientReport getReport() {
        return report;
    }

    public void setReport(PatientReport report) {
        this.report = report;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }


    @Override
    public String toString() {
        String idTemp;

        if (id == null)
            idTemp = "null";
        else
            idTemp = id.toString();


        return "ReportEntry{" +
                "id=" + idTemp +
                ", bodyTemperature=" + bodyTemperature +
                ", heartRate=" + heartRate +
                ", respitory=" + respitory +
                ", bloodPressureSystolic=" + bloodPressureSystolic +
                ", bloodPressureDiastolic=" + bloodPressureDiastolic +
                ", report=" + report +
                ", nurse=" + nurse +
                ", painLevel=" + painLevel +
                ", other='" + other + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return id;
    }

    @Override
    protected String getPath() {
        return "/reportentrys/";
    }


    public static ReportEntry fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (ReportEntry) new ReportEntry().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        ReportEntry re = new ReportEntry();

        try {
            if (jsonObject.has("id"))
                re.id = jsonObject.getLong("id");

            re.bodyTemperature = (float) jsonObject.getDouble("bodyTemperature");
            re.heartRate = jsonObject.getInt("heartRate");
            re.respitory = jsonObject.getInt("respitory");
            re.bloodPressureSystolic = jsonObject.getInt("bloodPressureSystolic");
            re.bloodPressureDiastolic = jsonObject.getInt("bloodPressureDiastolic");

            if (jsonObject.has("report"))
                re.report = PatientReport.fromJson(jsonObject.getString("report"));

            if (jsonObject.has("nurse"))
                re.nurse = Nurse.fromJson(jsonObject.getString("nurse"));

            re.painLevel = jsonObject.getInt("painLevel");
            re.other = jsonObject.getString("other");


            if (jsonObject.has("version"))
                re.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return re;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {

            if (id != null)
                jsonObject.put("id", this.id);


            jsonObject.put("bodyTemperature", this.bodyTemperature);
            jsonObject.put("heartRate", this.heartRate);
            jsonObject.put("respitory", this.respitory);
            jsonObject.put("bloodPressureSystolic", this.bloodPressureSystolic);
            jsonObject.put("bloodPressureDiastolic", this.bloodPressureDiastolic);
            jsonObject.put("painLevel", this.painLevel);
            jsonObject.put("other", this.other);

            if (report != null)
                jsonObject.put("report", new JSONObject(report.toJson(true)));

            if (nurse != null)
                jsonObject.put("nurse", new JSONObject(nurse.toJson(true)));


            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ReportEntry findById(Long id) {

        return (ReportEntry) new ReportEntry().superFindById(id);
    }


    public static List<ReportEntry> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new ReportEntry().superFindAll();
        List<ReportEntry> reportEntrys = new ArrayList<ReportEntry>();

        for (AbstractJsonModel jm : abstractJsonModels)
            reportEntrys.add((ReportEntry) jm);

        return reportEntrys;
    }


    public static List<ReportEntry> findByReport(Long id) {
        List<AbstractJsonModel> abstractJsonModels =
                new ReportEntry().superFindCustom("?find=ByReport&report=" + id);
        List<ReportEntry> reportEntries = new ArrayList<ReportEntry>();

        for (AbstractJsonModel jm : abstractJsonModels)
            reportEntries.add((ReportEntry) jm);

        return reportEntries;
    }


    public static List<ReportEntry> findByNurse(Long id) {
        List<AbstractJsonModel> abstractJsonModels =
                new ReportEntry().superFindCustom("?find=ByNurse&nurse=" + id);
        List<ReportEntry> reportEntries = new ArrayList<ReportEntry>();

        for (AbstractJsonModel jm : abstractJsonModels)
            reportEntries.add((ReportEntry) jm);

        return reportEntries;
    }

}
