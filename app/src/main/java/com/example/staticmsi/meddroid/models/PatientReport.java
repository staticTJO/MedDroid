package com.example.staticmsi.meddroid.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-23.
 */
public class PatientReport extends AbstractJsonModel {

    private Long id = null;
    private String reportName;
    private Patient patientFile = null;
    private Nurse createdBy;
    private Long version = 0L;


    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatientFile() {
        return patientFile;
    }

    public Nurse getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Nurse createdBy) {
        this.createdBy = createdBy;
    }

    public void setPatientFile(Patient patientFile) {
        this.patientFile = patientFile;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        String idTemp;

        if (id == null)
            idTemp = "null";
        else
            idTemp = id.toString();

        return "PatientReport{" +
                "id=" + idTemp +
                ", reportName='" + reportName + '\'' +
                ", patient{" + patientFile.toString() + "}" +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return id;
    }

    @Override
    protected String getPath() {
        return "/patientreports/";
    }


    public static PatientReport fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (PatientReport) new PatientReport().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        PatientReport pr = new PatientReport();

        try {
            if (jsonObject.has("id"))
                pr.id = jsonObject.getLong("id");

            pr.setReportName(jsonObject.getString("reportName"));

            if (jsonObject.has("createdBy"))
                pr.createdBy = Nurse.fromJson(jsonObject.getString("createdBy"));

            if (jsonObject.has("patientFile"))
                pr.patientFile = Patient.fromJson(jsonObject.getString("patientFile"));

            if (jsonObject.has("version"))
                pr.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pr;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {

            if (createdBy != null)
                jsonObject.put("createdBy", new JSONObject(createdBy.toJson(true)));


            if (id != null)
                jsonObject.put("id", this.id);


            if (patientFile != null)
                jsonObject.put("patientFile", new JSONObject(patientFile.toJson(true)));

            jsonObject.put("reportName", this.reportName);

            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static PatientReport findById(Long id) {

        return (PatientReport) new PatientReport().superFindById(id);
    }


    public static List<PatientReport> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new PatientReport().superFindAll();
        List<PatientReport> patientReports = new ArrayList<PatientReport>();

        for (AbstractJsonModel jm : abstractJsonModels)
            patientReports.add((PatientReport) jm);

        return patientReports;
    }

}
