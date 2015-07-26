package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientReport;

/**
 * Created by hamadalmarri on 2015-07-25.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        TextView tv = (TextView) findViewById(R.id.testResult);


        Patient p = Patient.findById(24L);
        PatientReport pr = new PatientReport();

        pr.setReportName("Someone's Report");
        pr.setPatientFile(p);

        pr.save();

        pr = PatientReport.findById(13L);

        tv.append(pr.toString());

    }

}
