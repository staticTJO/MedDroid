package com.example.staticmsi.meddroid.models;

import com.example.staticmsi.meddroid.JsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-22.
 */
public abstract class AbstractJsonModel {

    protected abstract Long getModelId();

    protected abstract String getPath();

    public abstract AbstractJsonModel fromJson(JSONObject jsonObject);

    public abstract String toJson(boolean addVersion);

    public String toJson() {
        return toJson(false);
    }

    public AbstractJsonModel superFindById(Long id) {
        String jsonResponse = JsonHelper.GET(getPath() + id);

        try {
            return fromJson(new JSONObject(jsonResponse));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<AbstractJsonModel> superFindAll() {
        String jsonResponse = JsonHelper.GET(getPath());
        List<AbstractJsonModel> jmList = new ArrayList<AbstractJsonModel>();


        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);


            for (int i = 0; i < jsonArray.length(); i++)
                jmList.add(fromJson(jsonArray.getJSONObject(i)));


            return jmList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*
     update / edit
     */
    public void update() {
        String jsonResponse = JsonHelper.PUT(getPath() + getModelId(), toJson(true));
    }


    /*
    insert new record in database
     */
    public void save() {
        String jsonResponse = JsonHelper.POST(getPath(), toJson());
    }

    /*
    delete a record from database
     */
    public void delete()
    {
        String jsonResponse = JsonHelper.DELETE(getPath() + getModelId());
    }


}
