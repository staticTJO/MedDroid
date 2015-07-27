package com.example.staticmsi.meddroid.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-27.
 */
public class Nurse extends AbstractJsonModel {

    private Long id = null;
    private String givenID;
    private String firstName;
    private String lastName;
    private String age;

//    private List<ReportEntry> entries = new ArrayList<ReportEntry>();
//    private List<PatientReport> reports = new ArrayList<PatientReport>();
//    private List<Notification> createdNotifications = new ArrayList<Notification>();
//    private List<Notification> receivedNotifications = new ArrayList<Notification>();
    private Long version = 0L;


    public Long getId() {
        return id;
    }

    public String getGivenID() {
        return givenID;
    }

    public void setGivenID(String givenID) {
        this.givenID = givenID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

//    public List<ReportEntry> getEntries() {
//        return entries;
//    }
//
//    public void setEntries(List<ReportEntry> entries) {
//        this.entries = entries;
//    }
//
//    public List<PatientReport> getReports() {
//        return reports;
//    }
//
//    public void setReports(List<PatientReport> reports) {
//        this.reports = reports;
//    }
//
//    public List<Notification> getCreatedNotifications() {
//        return createdNotifications;
//    }
//
//    public void setCreatedNotifications(List<Notification> createdNotifications) {
//        this.createdNotifications = createdNotifications;
//    }
//
//    public List<Notification> getReceivedNotifications() {
//        return receivedNotifications;
//    }
//
//    public void setReceivedNotifications(List<Notification> receivedNotifications) {
//        this.receivedNotifications = receivedNotifications;
//    }

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

        return "Nurse{" +
                "id=" + idTemp +
                ", givenID='" + givenID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
//                ", entries=" + entries +
//                ", reports=" + reports +
//                ", createdNotifications=" + createdNotifications +
//                ", receivedNotifications=" + receivedNotifications +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return id;
    }

    @Override
    protected String getPath() {
        return "/nurses/";
    }


    public static Nurse fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (Nurse) new Nurse().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        Nurse nr = new Nurse();
//        JSONArray list;

        try {
            if (jsonObject.has("id"))
                nr.id = jsonObject.getLong("id");


            nr.givenID = jsonObject.getString("givenID");
            nr.firstName = jsonObject.getString("firstName");
            nr.lastName = jsonObject.getString("lastName");
            nr.age = jsonObject.getString("age");

//            list = jsonObject.getJSONArray("entries");
//            if (list != null) {
//                for (int i = 0; i < list.length(); i++) {
//                    JSONObject elem = list.getJSONObject(i);
//                    nr.entries.add(ReportEntry.fromJson(elem.toString()));
//                }
//            }

//            list = jsonObject.getJSONArray("reports");
//            if (list != null) {
//                for (int i = 0; i < list.length(); i++) {
//                    JSONObject elem = list.getJSONObject(i);
//                    nr.reports.add(PatientReport.fromJson(elem.toString()));
//                }
//            }

//            list = jsonObject.getJSONArray("createdNotifications");
//            if (list != null) {
//                for (int i = 0; i < list.length(); i++) {
//                    JSONObject elem = list.getJSONObject(i);
//                    nr.createdNotifications.add(Notification.fromJson(elem.toString()));
//                }
//            }

//            list = jsonObject.getJSONArray("receivedNotifications");
//            if (list != null) {
//                for (int i = 0; i < list.length(); i++) {
//                    JSONObject elem = list.getJSONObject(i);
//                    nr.receivedNotifications.add(Notification.fromJson(elem.toString()));
//                }
//            }

            if (jsonObject.has("version"))
                nr.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return nr;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();
//        JSONArray entriesJsonArray = new JSONArray();
//        JSONArray reportsJsonArray = new JSONArray();
//        JSONArray createdNotificationsJsonArray = new JSONArray();
//        JSONArray receivedNotificationsJsonArray = new JSONArray();

        try {

            if (id != null)
                jsonObject.put("id", this.id);


            jsonObject.put("givenID", this.givenID);
            jsonObject.put("firstName", this.firstName);
            jsonObject.put("lastName", this.lastName);
            jsonObject.put("age", this.age);



//            for (ReportEntry re : entries) {
//                entriesJsonArray.put(re.toJson(true));
//            }
//
//            for (PatientReport pr : reports) {
//                reportsJsonArray.put(pr.toJson(true));
//            }
//
//            for (Notification n : createdNotifications) {
//                createdNotificationsJsonArray.put(n.toJson(true));
//            }
//
//            for (Notification n : receivedNotifications) {
//                receivedNotificationsJsonArray.put(n.toJson(true));
//            }
//
//
//            jsonObject.put("entries", entriesJsonArray);
//            jsonObject.put("reports", reportsJsonArray);
//            jsonObject.put("createdNotifications", createdNotificationsJsonArray);
//            jsonObject.put("receivedNotifications", receivedNotificationsJsonArray);


            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Nurse findById(Long id) {

        return (Nurse) new Nurse().superFindById(id);
    }


    public static List<Nurse> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new Nurse().superFindAll();
        List<Nurse> nurses = new ArrayList<Nurse>();

        for (AbstractJsonModel jm : abstractJsonModels)
            nurses.add((Nurse) jm);

        return nurses;
    }

}
