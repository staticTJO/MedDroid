package com.example.staticmsi.meddroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.staticmsi.meddroid.models.Patient;


public class AddPatientActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        Button cancel = (Button) findViewById(R.id.btnCancel);
        Button add = (Button) findViewById(R.id.btnAdd);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etFirstName = (EditText) findViewById(R.id.editTextFirstName);
                EditText etMiddleName = (EditText) findViewById(R.id.editTextMiddleName);
                EditText etLastName = (EditText) findViewById(R.id.editTextLastName);
                EditText etAge = (EditText) findViewById(R.id.editTextAge);
                RadioButton rdBtnMale = (RadioButton) findViewById(R.id.rdBtnMale);
                RadioButton rdBtnFemale = (RadioButton) findViewById(R.id.rdBtnFemale);
                EditText etPhone = (EditText) findViewById(R.id.editTextPhone);
                EditText etHealth = (EditText) findViewById(R.id.editTextHealth);
                EditText etAddress = (EditText) findViewById(R.id.editTextAddress);

                Patient p = new Patient();
                p.setPhoneNumber(etPhone.getText().toString());

                if (rdBtnMale.isChecked())
                    p.setGender("Male");
                else
                    p.setGender("Female");

                p.setAddress(etAddress.getText().toString());
                p.setHealthCardNumber(etHealth.getText().toString());
                p.setAge(etAge.getText().toString());
                p.setLastName(etLastName.getText().toString());
                p.setMiddleName(etMiddleName.getText().toString());
                p.setFirstName(etFirstName.getText().toString());

                p.save();

                Toast t = Toast.makeText(AddPatientActivity.this, "Patient is added", Toast.LENGTH_SHORT);
                t.show();

                setResult(1);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_patient, menu);
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
