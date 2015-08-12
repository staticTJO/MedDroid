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
        return "/nurses";
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

        try {
            if (jsonObject.has("id"))
                nr.id = jsonObject.getLong("id");


            nr.givenID = jsonObject.getString("givenID");
            nr.firstName = jsonObject.getString("firstName");
            nr.lastName = jsonObject.getString("lastName");
            nr.age = jsonObject.getString("age");


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

        try {

            if (id != null)
                jsonObject.put("id", this.id);


            jsonObject.put("givenID", this.givenID);
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


    public static List<Nurse> findByLoginUsername(String username) {
        List<AbstractJsonModel> abstractJsonModels =
                new Nurse().superFindCustom("?find=ByLogUsernameEquals&logUsername=" + username);
        List<Nurse> nurses = new ArrayList<Nurse>();

        for (AbstractJsonModel jm : abstractJsonModels)
            nurses.add((Nurse) jm);

        return nurses;
    }


}
