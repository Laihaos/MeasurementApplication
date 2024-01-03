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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int year = 0;
    public static int month = 0;
    public static int day = 0;
    public static int hour = 0;

    public static int minute = 0;

    public EditText editText;
    public EditText editTextname;

    public RadioGroup radioGroup;

    public RadioButton radioButtonm;
    public RadioButton radioButtonfm;
    public Lunar date;

    public static String name;

    public static String selectedOption = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.birthday);
        editTextname = (EditText) findViewById(R.id.name);
        radioGroup = findViewById(R.id.gender);
        radioButtonm = findViewById(R.id.male);
        radioButtonfm = findViewById(R.id.female);

        if (year != 0) {

            editText.setText(String.valueOf(year) + "年" + String.valueOf(month) + "月" + String.valueOf(day) + "日 " + String.valueOf(hour) + ":" + ((minute < 10) ? String.valueOf(0) + String.valueOf(+minute) : String.valueOf(minute)));

            date = new Lunar(year, month, day, hour, minute, 0);

            editTextname.setText(name);

            if (selectedOption.equals("女")) {
                radioButtonfm.setChecked(true);
            }
        }

    }

    public static void actionActivity(Context context, int Year, int Month, int Day, int Hour, int Minute, String Name) {
        Intent intent = new Intent(context, MainActivity.class);
        year = Year;
        month = Month;
        day = Day;
        hour = Hour;
        minute = Minute;
        name = Name;
        context.startActivity(intent);

    }

    public void goToDatePickerDialogActivity(View view) {
        name = editTextname.getText().toString();
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            selectedOption = checkedRadioButton.getText().toString();
        }

        DatePickerDialogActivity.actionActivity(this, name);

    }

    public void goToNatal_chartActivity(View view) {

        String birthday = String.valueOf(editText.getText());
        name = editTextname.getText().toString();


        if (TextUtils.isEmpty(birthday) || TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请填写生日信息", Toast.LENGTH_SHORT).show();
        } else {
            Natal_chart.actionActivity(this, date, month, day, name, selectedOption);
        }
    }

}

