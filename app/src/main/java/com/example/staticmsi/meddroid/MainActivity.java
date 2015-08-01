package com.example.staticmsi.meddroid;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.RelativeLayout; // Used for dynamic layouts coded in Java, Container for widgets used in a layout
import android.widget.Button;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.PatientAssessment;

import java.util.List;

import static android.R.attr.textAppearanceLarge;

public class MainActivity extends ActionBarActivity {

    // log function used to trace life cycle of Activity
    // Click 6:Android
    // Click Longcat tab
    // Click Filter, Name your filter whatever you like then copy "MedDroidMessages"
    // Paste into LongTag(Regex)
    // Click ok, then select the Filter name you created
    private static final String TAG = "MedDroidMessages";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //RelativeLayout NurseLayout = new RelativeLayout(this);

        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate Instance Initated");


        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
        spec1.setContent(R.id.homeTab);
        spec1.setIndicator("Home");
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setContent(R.id.allPatientsTab);
        spec2.setIndicator("All Patients");
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
        spec3.setContent(R.id.patientInfoTab);
        spec3.setIndicator("Patient Info");
        tabHost.addTab(spec3);

        TabHost.TabSpec spec4 = tabHost.newTabSpec("tab4");
        spec4.setContent(R.id.assessmentTab);
        spec4.setIndicator("Assessment");
        tabHost.addTab(spec4);

        fillPatients();

    }

    private void fillPatients() {
        TableLayout tbl = (TableLayout) findViewById(R.id.tblPatient);
        List<PatientAssessment> patientAssessments = PatientAssessment.findAll();

        for (PatientAssessment pa : patientAssessments) {
            TableRow trR = new TableRow(this);
            TextView tvIDR = new TextView(this);
            TextView tvStatusR = new TextView(this);
            Button b = new Button(this);


            tvIDR.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tvStatusR.setTextAppearance(this, android.R.style.TextAppearance_Large);

            tvIDR.setText(pa.getPatientFile().getHealthCardNumber());
            tvStatusR.setText(pa.getStatus());

            b.setText("INFO");

            trR.addView(tvIDR);
            trR.addView(tvStatusR);
            trR.addView(b);

            tbl.addView(trR);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_notification, menu);
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


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }
}
