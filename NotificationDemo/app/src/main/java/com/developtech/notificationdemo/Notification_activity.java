package com.developtech.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notification_activity extends AppCompatActivity {

    private EditText etid,ettitle,etmsg;
    private Button btnclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_activity);
        initComponents();
    }

    private void initComponents()
    {
        etid=(EditText)findViewById(R.id.etid);
        etmsg=(EditText)findViewById(R.id.etmsg);
        ettitle=(EditText)findViewById(R.id.ettitle);
        btnclick=(Button)findViewById(R.id.btnclick);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent intent=new Intent(Notification_activity.this,Notification_screen.class);

                PendingIntent pendingIntent=PendingIntent.getActivity(Notification_activity.this,1001,intent,0);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Notification_activity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle(etid.getText().toString());
                builder.setContentText(etid.getText().toString());
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                builder.setWhen(SystemClock.elapsedRealtime());
                notificationManager.notify(Integer.parseInt(etid.getText().toString()),builder.build());

            }
        });
    }
}
