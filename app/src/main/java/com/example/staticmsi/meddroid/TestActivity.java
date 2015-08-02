package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Doctor;
import com.example.staticmsi.meddroid.models.Notification;
import com.example.staticmsi.meddroid.models.Nurse;
import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;
import com.example.staticmsi.meddroid.models.PatientReport;
import com.example.staticmsi.meddroid.models.ReportEntry;

import java.util.Calendar;

/**
 * Created by hamadalmarri on 2015-07-25.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView tv = (TextView) findViewById(R.id.testResult);


        Notification x = Notification.findById(2L);

        tv.append(x.toJson());

    }
}
