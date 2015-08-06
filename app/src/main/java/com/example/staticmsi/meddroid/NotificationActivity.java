package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Notification;

import java.util.Date;
import java.util.List;


public class NotificationActivity extends Activity {

    private Long NurseMockId = 1L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setupNotification();
        fillNotifications();
    }

    void setupNotification() {
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

    private void fillNotifications() {
        TableLayout t = (TableLayout) findViewById(R.id.tblNotifications);
        List<Notification> notifications =
                Notification.findByDateAndTimeBetweenAndToDoctor(new Date(), new Date(), NurseMockId);

        for (Notification n : notifications) {
            TableRow tr = new TableRow(this);
            Button btnStatus = new Button(this);
            TextView tvDesc = new TextView(this);
            Button btnView = new Button(this);

            if (!n.isRead()) {
                btnStatus = setAsReadButton(n.getId());
            } else
                btnStatus.setVisibility(View.INVISIBLE);

            tvDesc.setText(n.getText());
            btnView.setText("view");

            tr.addView(btnStatus);
            tr.addView(tvDesc);
            tr.addView(btnView);

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
