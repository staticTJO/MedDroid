package com.example.staticmsi.meddroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.staticmsi.meddroid.models.Doctor;
import com.example.staticmsi.meddroid.models.Notification;
import com.example.staticmsi.meddroid.models.Nurse;
import com.example.staticmsi.meddroid.models.PatientReport;
import com.example.staticmsi.meddroid.models.ReportEntry;

import java.util.Date;


public class NewEntryActivity extends ActionBarActivity {

    Long prID = null;
    Nurse n = Nurse.findById(1L);


    class BtnAddOnClickListener implements View.OnClickListener {

        Nurse n = null;
        PatientReport pr = null;

        public BtnAddOnClickListener(Nurse n, PatientReport pr) {
            this.n = n;
            this.pr = pr;
        }

        @Override
        public void onClick(View v) {
            EditText etBodyTemp = (EditText) findViewById(R.id.etBodyTemp);
            EditText etHeartRate = (EditText) findViewById(R.id.etHeartRate);
            EditText etRes = (EditText) findViewById(R.id.etRes);
            EditText etBPS = (EditText) findViewById(R.id.etBPS);
            EditText etBPD = (EditText) findViewById(R.id.etBPD);
            EditText etPainLevel = (EditText) findViewById(R.id.etPainLevel);
            EditText etOther = (EditText) findViewById(R.id.etOther);
            CheckBox cbNotification = (CheckBox) findViewById(R.id.cbNotification);
            RadioButton rbNormal = (RadioButton) findViewById(R.id.rbNormal);
            RadioButton rbUrgent = (RadioButton) findViewById(R.id.rbUrgent);

            ReportEntry re = new ReportEntry();
            re.setBloodPressureDiastolic(Integer.parseInt(etBPD.getText().toString()));
            re.setBloodPressureSystolic(Integer.parseInt(etBPS.getText().toString()));
            re.setBodyTemperature(Float.parseFloat(etBodyTemp.getText().toString()));
            re.setHeartRate(Integer.parseInt(etHeartRate.getText().toString()));
            re.setPainLevel(Integer.parseInt(etPainLevel.getText().toString()));
            re.setOther(etOther.getText().toString());

            re.setNurse(this.n);
            re.setReport(this.pr);


            if (cbNotification.isChecked()) {
                Notification noti = new Notification();
                noti.setByNurse(this.n);
                noti.setToDoctor(Doctor.findById(1L));
                noti.setDateAndTime(new Date());

                if (rbUrgent.isChecked())
                    noti.setImportance("URGENT");
                else
                    noti.setImportance("NORMAL");

                noti.setText(re.getOther());
                noti.setIsRead(false);

                re.setNotification(noti);
            }

            re.save();


            Toast t = Toast.makeText(NewEntryActivity.this, "new entry is added", Toast.LENGTH_LONG);
            t.show();

            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        setPrId();
        setupCbNotification();
        setupBtnAdd();
    }

    private void setupCbNotification() {
        CheckBox cbNotification = (CheckBox) findViewById(R.id.cbNotification);

        cbNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RadioButton rbNormal = (RadioButton) findViewById(R.id.rbNormal);
                RadioButton rbUrgent = (RadioButton) findViewById(R.id.rbUrgent);

                if (isChecked) {
                    rbNormal.setEnabled(true);
                    rbUrgent.setEnabled(true);
                } else {
                    rbNormal.setEnabled(false);
                    rbUrgent.setEnabled(false);
                }
            }
        });
    }

    private void setupBtnAdd() {
        Button b = (Button) findViewById(R.id.btnAddTheNewReportEntry);

        PatientReport pr = PatientReport.findById(prID);

        b.setOnClickListener(new BtnAddOnClickListener(n, pr));

    }

    private void setPrId() {
        prID = getIntent().getExtras().getLong("prID");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
