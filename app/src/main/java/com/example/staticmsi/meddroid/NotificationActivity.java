package com.example.staticmsi.meddroid;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.staticmsi.meddroid.models.Notification;

import java.util.List;


public class NotificationActivity extends Activity {

    static class OnReadBtnClick implements View.OnClickListener {
        Long id;

        OnReadBtnClick(Long id) {
            this.id = id;
        }


        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            Notification n = Notification.findById(this.id);

            n.setIsRead(true);
            n.update();

            b.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        fillNotifications();
    }

    private void fillNotifications() {
        TableLayout t = (TableLayout) findViewById(R.id.tblNotifications);
        List<Notification> notifications = Notification.findAll();

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

        b.setOnClickListener(new OnReadBtnClick(id));

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
}
