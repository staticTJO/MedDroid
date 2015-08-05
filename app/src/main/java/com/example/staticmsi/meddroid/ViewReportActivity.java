package com.example.staticmsi.meddroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Nurse;
import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientReport;
import com.example.staticmsi.meddroid.models.ReportEntry;

import java.util.ArrayList;
import java.util.List;

public class ViewReportActivity extends AppCompatActivity {


    Long prID = null;
    List<ReportEntry> reportEntries = new ArrayList<ReportEntry>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);

        fillData();
    }

    private void fillData() {
        prID = (Long) getIntent().getExtras().getSerializable("prID");
        List<ReportEntry> res = ReportEntry.findAll();
        TableLayout t = (TableLayout) findViewById(R.id.tblEntries);

        for (ReportEntry re : res) {
            if (re.getReport().getId().compareTo(prID) == 0) {
                TableRow tr = new TableRow(this);
                TableRow trOther = new TableRow(this);

                TextView tv_bodyTemperature = new TextView(this);
                TextView tv_heartRate = new TextView(this);
                TextView tv_respitory = new TextView(this);
                TextView tv_bloodPressureSystolic = new TextView(this);
                TextView tv_bloodPressureDiastolic = new TextView(this);
                TextView tv_painLevel = new TextView(this);
                TextView tv_other = new TextView(this);


                tv_bodyTemperature.setText(String.valueOf(re.getBodyTemperature()));
                tv_heartRate.setText(String.valueOf(re.getHeartRate()));
                tv_respitory.setText(String.valueOf(re.getRespitory()));
                tv_bloodPressureSystolic.setText(String.valueOf(re.getBloodPressureSystolic()));
                tv_bloodPressureDiastolic.setText(String.valueOf(re.getBloodPressureDiastolic()));
                tv_painLevel.setText(String.valueOf(re.getPainLevel()));
                tv_other.setText(re.getOther());

                tr.addView(tv_bodyTemperature);
                tr.addView(tv_heartRate);
                tr.addView(tv_respitory);
                tr.addView(tv_bloodPressureSystolic);
                tr.addView(tv_bloodPressureDiastolic);
                tr.addView(tv_painLevel);

                trOther.addView(tv_other);

                t.addView(tr);
                t.addView(trOther);

                reportEntries.add(re);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_report, menu);
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
