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

public class MainActivity extends AppCompatActivity implements OnYearSelectedListener {

    public static int year = 0;
    public static int month = 0;
    public static int day = 0;
    public static int hour = 0;

    public static int minute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.birthday);

        if (year != 0) {
            editText.setText(String.valueOf(year) + "年" + String.valueOf(month) + "月" + String.valueOf(day) + "日 " + String.valueOf(hour) +":"+((minute < 10) ? String.valueOf(0)+String.valueOf(+minute) : String.valueOf(minute)) );
            Lunar date = new Lunar(year,month,day,hour,minute,0);
            Log.d("date", String.valueOf(date.toFullString()));
        }

//        Log.d("date1", String.valueOf(date.getTimeZhi()));

//        Log.d("Yearn", String.valueOf(Year));
//        editText.setText(String.valueOf(Year)+String.valueOf(Month)+String.valueOf(Day));

    }

    public static void actionActivity(Context context, int Year, int Month, int Day, int Hour, int Minute) {
        Intent intent = new Intent(context, MainActivity.class);
        year = Year;
        month = Month;
        day = Day;
        hour = Hour;
        minute = Minute;
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

