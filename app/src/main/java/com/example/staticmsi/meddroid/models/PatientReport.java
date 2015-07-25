package com.example.staticmsi.meddroid.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-23.
 */
public class PatientReport extends AbstractJsonModel {

    private Long id = null;
    private String reportName;
    private Patient patientFile = null;
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

    public void setPatientFile(Patient patientFile) {
        this.patientFile = patientFile;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "PatientReport{" +
                "id=" + id +
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
        PatientReport p = new PatientReport();

        try {
            if (jsonObject.has("id"))
                p.id = jsonObject.getLong("id");

            p.setReportName(jsonObject.getString("reportName"));

            if (jsonObject.has("patientFile"))
                p.patientFile = Patient.fromJson(jsonObject.getString("patientFile"));

            if (jsonObject.has("version"))
                p.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("createdBy", JSONObject.NULL);


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
