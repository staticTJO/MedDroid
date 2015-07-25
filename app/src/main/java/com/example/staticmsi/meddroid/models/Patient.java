package com.example.staticmsi.meddroid.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-22.
 */
public class Patient extends AbstractJsonModel {

    private Long id = null;

    private String healthCardNumber;

    private String age;

    private String gender;

    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNumber;

    private String address;

    private Long version = 0L;


    public Patient() {
    }

    public Patient(String healthCardNumber, String age, String gender, String firstName,
                   String lastName, String middleName, String phoneNumber, String address) {
        this.healthCardNumber = healthCardNumber;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHealthCardNumber() {
        return healthCardNumber;
    }

    public void setHealthCardNumber(String healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getVersion() {
        return version;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", healthCardNumber='" + healthCardNumber + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    protected Long getModelId() {
        return getId();
    }

    @Override
    protected String getPath() {
        return "/patients/";
    }


    public static Patient fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (Patient) new Patient().fromJson(jsonObject);
    }

    @Override
    public AbstractJsonModel fromJson(JSONObject jsonObject) {
        Patient p = new Patient();

        try {
            if (jsonObject.has("id"))
                p.setId(jsonObject.getLong("id"));

            p.setHealthCardNumber(jsonObject.getString("healthCardNumber"));
            p.setAge(jsonObject.getString("age"));
            p.setGender(jsonObject.getString("gender"));
            p.setFirstName(jsonObject.getString("firstName"));
            p.setLastName(jsonObject.getString("lastName"));
            p.setMiddleName(jsonObject.getString("middleName"));
            p.setPhoneNumber(jsonObject.getString("phoneNumber"));
            p.setAddress(jsonObject.getString("address"));

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
            jsonObject.put("address", this.address);
            jsonObject.put("age", this.age);
            jsonObject.put("firstName", this.firstName);
            jsonObject.put("gender", this.gender);
            jsonObject.put("healthCardNumber", this.healthCardNumber);

            if (id != null)
                jsonObject.put("id", this.id);

            jsonObject.put("lastName", this.lastName);
            jsonObject.put("middleName", this.middleName);
            jsonObject.put("phoneNumber", this.phoneNumber);

            if (addVersion)
                jsonObject.put("version", this.version);

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Patient findById(Long id) {
        return (Patient) new Patient().superFindById(id);
    }


    public static List<Patient> findAll() {

        List<AbstractJsonModel> abstractJsonModels = new Patient().superFindAll();
        List<Patient> patients = new ArrayList<Patient>();

        for (AbstractJsonModel jm : abstractJsonModels)
            patients.add((Patient) jm);

        return patients;
    }

}
