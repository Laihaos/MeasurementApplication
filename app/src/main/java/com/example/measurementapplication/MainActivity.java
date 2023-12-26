package com.example.measurementapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.nlf.calendar.Lunar;
import com.ycuwq.datepicker.date.DayPicker;
import com.ycuwq.datepicker.date.MonthPicker;
import com.ycuwq.datepicker.date.YearPicker;
import com.ycuwq.datepicker.date.YearPicker.OnYearSelectedListener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnYearSelectedListener{

    public static int Year=0;
    public static  int Month=0;
    public static  int Day=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lunar date = new Lunar();
        Log.d("date", String.valueOf(date.toFullString()));
//        Log.d("date1", String.valueOf(date.getTimeZhi()));

        EditText editText = (EditText) findViewById(R.id.birthday);

        YearPicker YearPicker = new YearPicker(this);
        YearPicker.setOnYearSelectedListener(this);
        Year= YearPicker.getSelectedYear();
        Log.d("Yearn", String.valueOf(Year));
//        editText.setText(String.valueOf(Year)+String.valueOf(Month)+String.valueOf(Day));

    }
    public static void actionActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);

    }

    public void goToDatePickerDialogActivity(View view) {
        DatePickerDialogActivity.actionActivity(this);
    }

    @Override
    public void onYearSelected(int year) {
        Log.d("onYearSelected", String.valueOf(year));
    }
}

