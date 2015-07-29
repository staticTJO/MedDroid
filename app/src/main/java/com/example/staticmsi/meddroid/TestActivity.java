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


        Nurse n = new Nurse();
        n.setAge("22");
        n.setFirstName("Noor");
        n.setGivenID("65165165");
        n.setLastName("James");
        n.save();

        n = Nurse.findById(1L);

        Patient p = Patient.findById(1L);
        PatientReport pr = new PatientReport();
        pr.setPatientFile(p);
        pr.setReportName("second repo");
        pr.setCreatedBy(n);

        pr.save();

        pr = PatientReport.findById(1L);

        ReportEntry rp = new ReportEntry();
        rp.setBloodPressureDiastolic(3);
        rp.setBloodPressureSystolic(2);
        rp.setBodyTemperature(2.1f);
        rp.setHeartRate(60);
        rp.setNurse(n);
        rp.setOther("dlkfhgldjfhgld");
        rp.setPainLevel(5);
        rp.setReport(pr);
        rp.setRespitory(1);

        rp.save();



//        Notification x = Notification.findById(1L);


//        tv.append(x.toJson());

    }

}
