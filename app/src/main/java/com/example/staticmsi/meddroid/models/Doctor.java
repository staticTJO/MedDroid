package com.example.staticmsi.meddroid.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-27.
 */
public class Doctor extends AbstractJsonModel {

    private Long id = null;
    private String firstName;
    private String lastName;
    private String age;
    private Long version = 0L;

    public Long getId() {
        return id;
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

        return "Doctor{" +
                "id=" + idTemp +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return id;
    }

    @Override
    protected String getPath() {
        return "/doctors/";
    }


    public static Doctor fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (Doctor) new Doctor().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        Doctor dr = new Doctor();

        try {
            if (jsonObject.has("id"))
                dr.id = jsonObject.getLong("id");

            dr.firstName = jsonObject.getString("firstName");
            dr.lastName = jsonObject.getString("lastName");
            dr.age = jsonObject.getString("age");

            if (jsonObject.has("version"))
                dr.version = jsonObject.getLong("version");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dr;
    }

    @Override
    public String toJson(boolean addVersion) {
        JSONObject jsonObject = new JSONObject();

        try {

            if (id != null)
                jsonObject.put("id", this.id);

            jsonObject.put("firstName", this.firstName);
            jsonObject.put("lastName", this.lastName);
            jsonObject.put("age", this.age);

            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Doctor findById(Long id) {

        return (Doctor) new Doctor().superFindById(id);
    }


    public static List<Doctor> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new Nurse().superFindAll();
        List<Doctor> doctors = new ArrayList<Doctor>();

        for (AbstractJsonModel jm : abstractJsonModels)
            doctors.add((Doctor) jm);

        return doctors;
    }


}
