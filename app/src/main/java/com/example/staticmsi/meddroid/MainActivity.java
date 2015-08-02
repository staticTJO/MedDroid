package com.example.staticmsi.meddroid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.RelativeLayout; // Used for dynamic layouts coded in Java, Container for widgets used in a layout
import android.widget.Button;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.textAppearanceLarge;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // log function used to trace life cycle of Activity
    // Click 6:Android
    // Click Longcat tab
    // Click Filter, Name your filter whatever you like then copy "MedDroidMessages"
    // Paste into LongTag(Regex)
    // Click ok, then select the Filter name you created
    private static final String TAG = "MedDroidMessages";


    List<Patient> patients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //RelativeLayout NurseLayout = new RelativeLayout(this);


        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


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


        fillHomePatients();
        fillPatients();
        fillPatientsSpanner();

        setupNotification();
    }

    private void setupNotification() {
        ImageButton notifBtn = (ImageButton) findViewById(R.id.btnNotification);

        updateCountNotification();

        notifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateCountNotification() {
        TextView counter = (TextView) findViewById(R.id.counterNotification);
        int counts = 100;

        if (counts == 0) {
            counter.setVisibility(View.INVISIBLE);
        } else if (counts > 99) {
            counter.setText("+99");
            counter.setVisibility(View.VISIBLE);
        } else {
            counter.setText(String.valueOf(counts));
            counter.setVisibility(View.VISIBLE);
        }

    }

    private void fillPatientsSpanner() {
        Spinner spinner = (Spinner) findViewById(R.id.patients_spinner);
        List<String> items = new ArrayList<String>();
        this.patients = Patient.findAll();

        items.add("Select Patient ...");

        for (Patient p : this.patients) {
            items.add(p.getFirstName());
        }

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_view, items);


        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        String firstName = parent.getItemAtPosition(pos).toString();
        Patient patient = null;
        TextView patientId = (TextView) findViewById(R.id.textPatientId);
        TextView patientIL = (TextView) findViewById(R.id.textPatientInfoLeft);
        TextView patientIR = (TextView) findViewById(R.id.textPatientInfoRight);

        for (Patient p : this.patients) {
            if (p.getFirstName().equals(firstName)) {
                patient = p;
                break;
            }
        }

        if (patient == null)
            return;

        patientId.setText("Patient# " + patient.getHealthCardNumber());

        patientIL.setText("");
        patientIR.setText("");

        patientIL.append("Name: " + patient.getFirstName() + " " + patient.getLastName() + '\n');
        patientIL.append("Age: " + patient.getAge() + '\n');
        patientIL.append("Gender: " + patient.getGender() + '\n');

        patientIR.append("Phone: " + patient.getPhoneNumber() + '\n');
        patientIR.append("Address: " + patient.getAddress() + '\n');


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void fillHomePatients() {
        TableLayout tbl = (TableLayout) findViewById(R.id.home_table);
        List<Patient> patients = Patient.findAll();

        int i = 0;

        for (Patient p : patients) {
            TableRow tr = new TableRow(this);
            TextView tvID = new TextView(this);
            Button b = new Button(this);

            if (i % 2 == 1)
                tr.setBackgroundColor(Color.parseColor("#8ebbc9"));


            tvID.setText(p.getHealthCardNumber());

            b.setText("VIEW");

            tr.addView(tvID);
            tr.addView(b);

            tbl.addView(tr);

            i++;
        }

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


//    static Button notifCount;
//    static int mNotifCount = 0;
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        getMenuInflater().inflate(R.menu.menu_notification, menu);
//
//
//
////        View count = menu.findItem(R.menu.menu_notification).getActionView();
////        notifCount = (Button) count.findViewById(R.id.notif_count);
////        notifCount.setText(String.valueOf(mNotifCount));
////        return super.onCreateOptionsMenu(menu);
//    }



//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//
//            Toast t = Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT);
//            t.show();
//
//            return true;
//        }
//
//        if (id == R.id.TestAction) {
//            Toast t = Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT);
//            t.show();
//
//            return true;
//        }
//
//        if (id == R.id.notificationBtn2) {
//            Toast t = Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT);
//            t.show();
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//

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
