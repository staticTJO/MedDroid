package com.example.staticmsi.meddroid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
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

import com.example.staticmsi.meddroid.models.Notification;
import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientAssessment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.R.attr.tag;
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
    Patient newPatientToBeAssesst = null;
    PatientAssessment patientToBeAssesst = null;
    private long NurseMockId = 2L;
    Handler handler = new Handler();



    class TimerForUpdate implements Runnable {


        @Override
        public void run() {
            refresh();
            handler.postDelayed(this, 10000);
        }
    };

    class BtnViewReportsOnClick implements View.OnClickListener {

        Long pId = null;


        public BtnViewReportsOnClick(Long pId) {
            this.pId = pId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
            intent.putExtra("pId", pId);
            startActivity(intent);
        }

    }

    class BtnStartAssessmentOnClick implements View.OnClickListener {

        Long pId = null;
        Long paId = null;
        MainActivity ma;

        public BtnStartAssessmentOnClick(MainActivity ma, Long pId, Long paId) {
            this.ma = ma;
            this.pId = pId;
            this.paId = paId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, NeuroActivity.class);

            if (pId != null)
                intent.putExtra("pId", pId);

            if (paId != null) {
                intent.putExtra("paExist", true);
                intent.putExtra("paId", paId);
            } else {
                intent.putExtra("paExist", false);
            }

            startActivity(intent);
        }

    }

    static class BtnViewPatientOnClick implements View.OnClickListener {

        Patient p = null;
        MainActivity ma;

        public BtnViewPatientOnClick(MainActivity ma, Patient p) {
            this.ma = ma;
            this.p = p;
        }

        @Override
        public void onClick(View v) {
            ma.changeTapTo(2);
            ma.selectPatientSpinner(p);
        }

    }


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

        setBtnAddNewPatient();
        setBtnStartAssessment();

        setupTimerForRefresh();
    }

    private void setupTimerForRefresh() {
        TimerForUpdate timerForUpdate = new TimerForUpdate();
        handler.postDelayed(timerForUpdate, 10000);
    }

    private void setBtnViewReport() {
        Button b = (Button) findViewById(R.id.btnViewReports);
        b.setOnClickListener(new BtnViewReportsOnClick(this.newPatientToBeAssesst.getId()));

    }

    private void setBtnStartAssessment() {
        Button b = (Button) findViewById(R.id.btnStartAssess);

        if (this.newPatientToBeAssesst != null)
            b.setOnClickListener(new BtnStartAssessmentOnClick(this, this.newPatientToBeAssesst.getId(), null));
    }


    void changeTapTo(int tabNumber) {
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setCurrentTab(tabNumber);
    }

    void selectPatientSpinner(Patient p) {
        Spinner spinner = (Spinner) findViewById(R.id.patients_spinner);
        int i = 0;

        for (Patient patient : this.patients) {
            if (patient.getHealthCardNumber().equals(p.getHealthCardNumber())) {
                spinner.setSelection(i + 1);
                break;
            }

            i++;
        }

    }

    private void setBtnAddNewPatient() {
        Button btn = (Button) findViewById(R.id.btnAddNewPatient);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPatientActivity.class);
                startActivityForResult(intent, 0);
            }
        });
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
        int counts = 0;

        List<Notification> notifications =
                Notification.findByDateAndTimeBetweenAndToDoctor(new Date(), new Date(), NurseMockId);

        // find toNurse or toDoctor
        // find unread yet
        for (Notification n : notifications) {
            if (!n.isRead())
                counts++;
        }


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
        Button b = (Button) findViewById(R.id.btnViewReports);


        for (Patient p : this.patients) {
            if (p.getFirstName().equals(firstName)) {
                patient = p;
                this.newPatientToBeAssesst = p;
                break;
            }
        }

        if (patient == null) {
            b.setVisibility(View.INVISIBLE);
            return;
        }

        b.setVisibility(View.VISIBLE);

        patientId.setText("Patient# " + patient.getHealthCardNumber());

        patientIL.setText("");
        patientIR.setText("");

        patientIL.append("Name: " + patient.getFirstName() + " " + patient.getLastName() + '\n');
        patientIL.append("Age: " + patient.getAge() + '\n');
        patientIL.append("Gender: " + patient.getGender() + '\n');

        patientIR.append("Phone: " + patient.getPhoneNumber() + '\n');
        patientIR.append("Address: " + patient.getAddress() + '\n');

        setBtnViewReport();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void fillHomePatients() {
        Log.i(TAG, "fillHomePatients");

        TableLayout tbl = (TableLayout) findViewById(R.id.home_table);
        TextView tvNoPatients = (TextView) findViewById(R.id.textViewNoPatient);

        tbl.removeAllViews();
        List<PatientAssessment> patientAssessments = PatientAssessment.findAll();

        if (patientAssessments.isEmpty()) {
            tbl.setVisibility(View.INVISIBLE);
            return;
        }

        tvNoPatients.setVisibility(View.INVISIBLE);


        for (PatientAssessment pa : patientAssessments) {
            TableRow trR = new TableRow(this);
            TextView tvIDR = new TextView(this);
            TextView tvStatusR = new TextView(this);
            Button b = new Button(this);


            tvIDR.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tvStatusR.setTextAppearance(this, android.R.style.TextAppearance_Large);

            tvIDR.setText(pa.getPatientFile().getHealthCardNumber());
            tvStatusR.setText(pa.getStatus());

            b.setText("Start Assessment");
            b.setOnClickListener(new BtnStartAssessmentOnClick(this, null, pa.getId()));

            trR.addView(tvIDR);
            trR.addView(tvStatusR);
            trR.addView(b);

            tbl.addView(trR);
        }
    }

    private void fillPatients() {

        TableLayout tbl = (TableLayout) findViewById(R.id.tblPatient);
        List<Patient> patients = Patient.findAll();

        tbl.removeAllViews();

        int i = 0;

        for (Patient p : patients) {
            TableRow tr = new TableRow(this);
            TextView tvID = new TextView(this);
            TextView tvName = new TextView(this);
            Button b = new Button(this);

            if (i % 2 == 1)
                tr.setBackgroundColor(Color.parseColor("#8ebbc9"));


            tvID.setText(p.getHealthCardNumber());
            tvName.setText(p.getFirstName());


            b.setText("VIEW");

            b.setOnClickListener(new BtnViewPatientOnClick(this, p));

            tr.addView(tvID);
            tr.addView(tvName);
            tr.addView(b);

            tbl.addView(tr);

            i++;
        }

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

        fillHomePatients();
        fillPatients();
        fillPatientsSpanner();

        setupNotification();
    }


    public void refresh() {
        fillHomePatients();
        fillPatients();
        fillPatientsSpanner();

        setupNotification();

        Log.i("TIMER", "TIMER");
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.i("onActivityResult", String.valueOf(requestCode));
//        Log.i("onActivityResult", String.valueOf(resultCode));


        if (resultCode != 0) {
            fillHomePatients();
            fillPatients();
            fillPatientsSpanner();
            changeTapTo(resultCode);
        }
    }
}
