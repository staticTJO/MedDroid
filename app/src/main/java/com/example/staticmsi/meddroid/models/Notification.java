package com.example.staticmsi.meddroid.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-27.
 */
public class Notification extends AbstractJsonModel {


    private Long id = null;
    private String text;
    private String importance; // make sure (NORMAL, or URGENT)
    private Nurse byNurse;
    private Doctor byDoctor;
    private Date dateAndTime;
    private Nurse toNurse;
    private Doctor toDoctor;
    private boolean isRead;
//    private ReportEntry entry;
    private Long version = 0L;


    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public Nurse getByNurse() {
        return byNurse;
    }

    public void setByNurse(Nurse byNurse) {
        this.byNurse = byNurse;
    }

    public Doctor getByDoctor() {
        return byDoctor;
    }

    public void setByDoctor(Doctor byDoctor) {
        this.byDoctor = byDoctor;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Nurse getToNurse() {
        return toNurse;
    }

    public void setToNurse(Nurse toNurse) {
        this.toNurse = toNurse;
    }

    public Doctor getToDoctor() {
        return toDoctor;
    }

    public void setToDoctor(Doctor toDoctor) {
        this.toDoctor = toDoctor;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

//    public ReportEntry getEntry() {
//        return entry;
//    }
//
//    public void setEntry(ReportEntry entry) {
//        this.entry = entry;
//    }

    @Override
    public String toString() {
        String idTemp;

        if (id == null)
            idTemp = "null";
        else
            idTemp = id.toString();

        return "Notification{" +
                "id=" + idTemp +
                ", text='" + text + '\'' +
                ", importance='" + importance + '\'' +
                ", byNurse=" + byNurse +
                ", byDoctor=" + byDoctor +
                ", dateAndTime=" + dateAndTime +
                ", toNurse=" + toNurse +
                ", toDoctor=" + toDoctor +
                ", isRead=" + isRead +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return id;
    }

    @Override
    protected String getPath() {
        return "/notifications/";
    }


    public static Notification fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (Notification) new Notification().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        Notification n = new Notification();

        try {
            if (jsonObject.has("id"))
                n.id = jsonObject.getLong("id");


            n.text = jsonObject.getString("text");
            n.importance = jsonObject.getString("importance"); // make sure (NORMAL, or URGEN"importanceT)

            n.dateAndTime = new Date(jsonObject.getLong("dateAndTime"));

            n.isRead = jsonObject.getBoolean("isRead");


            if (jsonObject.has("byNurse") && !jsonObject.isNull("byNurse"))
                n.byNurse = Nurse.fromJson(jsonObject.getString("byNurse"));

            if (jsonObject.has("toNurse") && !jsonObject.isNull("toNurse"))
                n.toNurse = Nurse.fromJson(jsonObject.getString("toNurse"));


            if (jsonObject.has("byDoctor") && !jsonObject.isNull("byDoctor"))
                n.byDoctor = Doctor.fromJson(jsonObject.getString("byDoctor"));

            if (jsonObject.has("toDoctor") && !jsonObject.isNull("toDoctor"))
                n.toDoctor = Doctor.fromJson(jsonObject.getString("toDoctor"));


            if (jsonObject.has("version"))
                n.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {

            if (id != null)
                jsonObject.put("id", this.id);

            jsonObject.put("text", this.text);
            jsonObject.put("importance", this.importance); // make sure (NORMAL, or URGEN"importanceT)

            jsonObject.put("dateAndTime", this.dateAndTime.toString());

            jsonObject.put("isRead", this.isRead);


            if (byNurse != null)
                jsonObject.put("byNurse", new JSONObject(byNurse.toJson(true)));

            if (toNurse != null)
                jsonObject.put("toNurse", new JSONObject(toNurse.toJson(true)));


            if (byDoctor != null)
                jsonObject.put("byDoctor", new JSONObject(byDoctor.toJson(true)));

            if (toDoctor != null)
                jsonObject.put("toDoctor", new JSONObject(toDoctor.toJson(true)));


            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Notification findById(Long id) {

        return (Notification) new Notification().superFindById(id);
    }


    public static List<Notification> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new Notification().superFindAll();
        List<Notification> notifications = new ArrayList<Notification>();

        for (AbstractJsonModel jm : abstractJsonModels)
            notifications.add((Notification) jm);

        return notifications;
    }


    public static List<Notification> findByToDoctorAndIsRead(Long id) {
        List<AbstractJsonModel> abstractJsonModels =
                new Notification().superFindCustom("?find=ByToDoctorAndIsRead&toDoctor=" + id);
        List<Notification> notifications = new ArrayList<Notification>();

        for (AbstractJsonModel jm : abstractJsonModels)
            notifications.add((Notification) jm);

        return notifications;
    }


    public static List<Notification> findByToNurseAndIsRead(Long id) {
        List<AbstractJsonModel> abstractJsonModels =
                new Notification().superFindCustom("?find=ByToNurseAndIsRead&toNurse=" + id);
        List<Notification> notifications = new ArrayList<Notification>();

        for (AbstractJsonModel jm : abstractJsonModels)
            notifications.add((Notification) jm);

        return notifications;
    }

    public static List<Notification> findByDateAndTimeBetweenAndToDoctor(Date startDate, Date endDate, Long id) {

        String stDate = new SimpleDateFormat("MMMM+d,+yyyy").format(startDate);
        String enDate = new SimpleDateFormat("MMMM+d,+yyyy").format(endDate);

        Log.i("Json", stDate);
        Log.i("Json", enDate);

        String query = "?find=ByDateAndTimeBetweenAndToDoctor&" +
                "minDateAndTime=" + stDate + '&' +
                "maxDateAndTime=" + enDate + '&' +
                "toDoctor=" + id;

//        Log.i("Json", query);

        List<AbstractJsonModel> abstractJsonModels =
                new Notification().superFindCustom(query);
        List<Notification> notifications = new ArrayList<Notification>();

        for (AbstractJsonModel jm : abstractJsonModels)
            notifications.add((Notification) jm);

        return notifications;
    }

}
