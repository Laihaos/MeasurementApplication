package com.example.measurementapplication;

//import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ycuwq.datepicker.date.DatePicker;
import com.ycuwq.datepicker.date.YearPicker;


public class DatePickerDialogActivity extends AppCompatActivity implements DatePicker.OnDateSelectedListener {
    public static final String TAG = DatePickerDialogActivity.class.getSimpleName();

    public static void actionActivity(Context context) {
        Intent intent = new Intent(context, DatePickerDialogActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);

    }
    public void goTomainActivity(View view) {

        MainActivity.actionActivity(this);
    }



    @Override
    public void onDateSelected(int year, int month, int day) {
        Log.d("onDateSelected", String.valueOf(year+":"+month+":"+day));
    }
}
