package com.example.measurementapplication;

//import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ycuwq.datepicker.date.YearPicker;


public class DatePickerDialogActivity extends AppCompatActivity  {
    public static final String TAG = DatePickerDialogActivity.class.getSimpleName();

    private DatePicker datePicker;
    private TimePicker timePicker;

    private DatePickerDialog datePickerDialog;

    private Button quedingConfir;
    private Button quxiaoConfir;
    public static String name;



    public static void actionActivity(Context context,String Name) {
        name=Name;
        Intent intent = new Intent(context, DatePickerDialogActivity.class);
        context.startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);
//        birthday

        datePicker = findViewById(R.id.date_picker);
        timePicker = findViewById(R.id.time_picker);
        quedingConfir = findViewById(R.id.queding);
        quxiaoConfir = findViewById(R.id.quxiao);

    }

    public void goTomainActivity(View view) {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        MainActivity.actionActivity(this,year,month+1,day,hour,minute,name);
    }

    public void breakmainActivity(View view) {

        MainActivity.actionActivity(this,0,0,0,0,0,"");
    }


}
