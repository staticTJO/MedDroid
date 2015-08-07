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


public class NewEntryActivity extends ActionBarActivity {

    Long prID = null;

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

        b.setOnClickListener(new View.OnClickListener() {
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


                Toast t = Toast.makeText(NewEntryActivity.this, "new entry is added", Toast.LENGTH_LONG);
                t.show();
            }
        });
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
