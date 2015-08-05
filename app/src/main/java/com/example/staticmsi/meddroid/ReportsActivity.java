package com.example.staticmsi.meddroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientReport;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {

    String TAG = "ReportsActivity";
    Patient p = null;
    List<PatientReport> patientReports = new ArrayList<PatientReport>();



    class BtnViewOnClick implements View.OnClickListener {

        Long prID = null;

        public BtnViewOnClick(Long prID ) {
            this.prID = prID;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ReportsActivity.this, ViewReportActivity.class);
            intent.putExtra("prID", prID);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);


        fillData();
    }

    private void fillData() {
        p = (Patient) getIntent().getExtras().getSerializable("p");
        List<PatientReport> prs = PatientReport.findAll();
        TableLayout t = (TableLayout) findViewById(R.id.tblReports);

        t.removeAllViews();

//        Log.i(TAG, p.toJson());

        for (PatientReport pr : prs) {

//            Log.i(TAG, pr.toJson());

            if (pr.getPatientFile().getId().compareTo(p.getId()) == 0) {
                TableRow tr = new TableRow(this);
                TextView tvReportName = new TextView(this);
                Button btnView = new Button(this);

                tvReportName.setText(pr.getReportName());
                btnView.setText("VIEW");
                btnView.setOnClickListener(new BtnViewOnClick(pr.getId()));

                patientReports.add(pr);

                tr.addView(tvReportName);
                tr.addView(btnView);

                t.addView(tr);
//                Log.i(TAG, pr.toJson());
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reports, menu);
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
