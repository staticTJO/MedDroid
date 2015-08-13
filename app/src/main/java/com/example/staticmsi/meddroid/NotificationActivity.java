package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Notification;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class NotificationActivity extends Activity {


    class BtnViewOnClickListener implements View.OnClickListener {


        Long prID = null;

        public BtnViewOnClickListener(Long prID) {
            this.prID = prID;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(NotificationActivity.this, ViewReportActivity.class);
            intent.putExtra("prID", prID);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        if (!MainActivity.isDoctor)
            return;

        setupNotification();
        fillNotifications();
    }

    void setupNotification() {
        Calendar calendar = Calendar.getInstance();
        Date min, max;
        TextView counter = (TextView) findViewById(R.id.counterNotification);
        int counts = 0;


        calendar.add(Calendar.DAY_OF_MONTH, -1);
        min = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        max = calendar.getTime();


        List<Notification> notifications =
                Notification.findByDateAndTimeBetweenAndToDoctor(min, max, MainActivity.getUserId());

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

    private void fillNotifications() {

        Calendar calendar = Calendar.getInstance();
        Date min, max;
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        min = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        max = calendar.getTime();

        TableLayout t = (TableLayout) findViewById(R.id.tblNotifications);
        List<Notification> notifications =
                Notification.findByDateAndTimeBetweenAndToDoctor(min, max, MainActivity.getUserId());

        for (Notification n : notifications) {
            TableRow tr = new TableRow(this);
            Button btnMark = new Button(this);
            TextView tvDesc = new TextView(this);
            Button btnView = new Button(this);

            tvDesc.setTextAppearance(this, R.style.TextAppearance_AppCompat_Large);

            if (!n.isRead()) {
                btnMark = setAsReadButton(n.getId());
            } else
                btnMark.setVisibility(View.INVISIBLE);

            tvDesc.setText(n.getText());
            btnView.setText("view");
            btnView.setOnClickListener(new BtnViewOnClickListener(n.getEntry().getReport().getId()));

            tr.addView(tvDesc);
            tr.addView(btnView);
            tr.addView(btnMark);

            t.addView(tr);
        }
    }

    private Button setAsReadButton(Long id) {
        Button b = new Button(this);
        b.setText("mark as read");
        b.setOnClickListener(new OnReadBtnClick(this, id));

        return b;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    static class OnReadBtnClick implements View.OnClickListener {
        NotificationActivity na;
        Long id;

        OnReadBtnClick(NotificationActivity na, Long id) {
            this.na = na;
            this.id = id;
        }


        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            Notification n = Notification.findById(this.id);

            n.setIsRead(true);
            n.update();

            b.setVisibility(View.INVISIBLE);
            na.setupNotification();
        }
    }
}
