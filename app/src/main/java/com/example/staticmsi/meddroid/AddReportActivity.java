package com.example.staticmsi.meddroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.staticmsi.meddroid.models.Nurse;
import com.example.staticmsi.meddroid.models.Patient;
import com.example.staticmsi.meddroid.models.PatientReport;

public class AddReportActivity extends AppCompatActivity {

    private long pId;


    class BtnCreateReport implements View.OnClickListener {

        Long pId = null;


        public BtnCreateReport(Long pId) {
            this.pId = pId;
        }

        @Override
        public void onClick(View v) {
            EditText etReportName = (EditText) findViewById(R.id.etReportName);
            PatientReport pr = new PatientReport();
            Nurse n = Nurse.findById(MainActivity.getUserId());
            Patient p = Patient.findById(this.pId);

            pr.setCreatedBy(n);
            pr.setPatientFile(p);
            pr.setReportName(etReportName.getText().toString());

            pr.save();

            Toast t = Toast.makeText(AddReportActivity.this, "new report is created", Toast.LENGTH_LONG);
            t.show();

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);

        setup();
    }

    private void setup() {
        pId = getIntent().getExtras().getLong("pId");
        Button b = (Button) findViewById(R.id.btnCreateReport);

        b.setOnClickListener(new BtnCreateReport(this.pId));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_report, menu);
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
