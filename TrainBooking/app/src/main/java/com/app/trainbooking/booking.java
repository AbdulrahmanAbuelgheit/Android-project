package com.app.trainbooking;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class booking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private static String CHANNEL_ID = "nada1";
    private static int NOTIFICATION_ID = 1;
    EditText ed1, ed2;
    Button cancel, done;
    private Spinner sp, sp1;
    private ArrayAdapter<String> arr;
    private ArrayAdapter<String> arr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        cancel = findViewById(R.id.cancel);
        done = findViewById(R.id.done);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        sp = (Spinner) findViewById(R.id.sp);
        sp1 = (Spinner) findViewById(R.id.sp1);
        arr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Enumz.names());
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arr);
        sp1.setAdapter(arr);

        ed1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
        String e1 = ed1.getText().toString();
        String e2 = ed2.getText().toString();
        String s = sp.getSelectedItem().toString();

        done.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                shownotification();

            }


        });


    }

    private void shownotification() {
        createnotification();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_action_name);
        builder.setContentTitle("book your ticket is done from " + sp.getSelectedItem().toString() + " to " + sp1.getSelectedItem().toString());
        builder.setContentText("Date of your trip :" + ed1.getText().toString());
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

    }

    private void createnotification() {
        if( Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="My notification";
            String description="my notification description" ;
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,name,importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());


        ed1.setText(currentDateString);

    }
}