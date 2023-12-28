package com.example.measurementapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.nlf.calendar.Lunar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int year = 0;
    public static int month = 0;
    public static int day = 0;
    public static int hour = 0;

    public static int minute = 0;

    public EditText editText;
    public Lunar date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.birthday);

        if (year != 0) {
            editText.setText(String.valueOf(year) + "年" + String.valueOf(month) + "月" + String.valueOf(day) + "日 " + String.valueOf(hour) + ":" + ((minute < 10) ? String.valueOf(0) + String.valueOf(+minute) : String.valueOf(minute)));
            date = new Lunar(year, month, day, hour, minute, 0);
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

    public void goToNatal_chartActivity(View view) {

        String birthday = String.valueOf(editText.getText());

        if (TextUtils.isEmpty(birthday)) {
            Toast.makeText(this, "请填写生日信息", Toast.LENGTH_SHORT).show();
        } else {
            Natal_chart.actionActivity(this);
        }
    }

}

